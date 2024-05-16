package com.smart.security.component;

import com.smart.security.config.IgnoreUrlsConfig;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;

/**
 * 动态权限过滤器，用于实现基于路径的动态权限过滤
 *
 * @author lizhonghao
 * @date 2023/12/3
 */
@Component
@ConditionalOnBean(name = "dynamicSecurityService")
public class DynamicSecurityFilter extends AuthorizationFilter implements Filter {

    private final DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    private final IgnoreUrlsConfig ignoreUrlsConfig;

    /**
     * Creates an instance.
     *
     * @param authorizationManager the {@link AuthorizationManager} to use
     */
    public DynamicSecurityFilter(AuthorizationManager<HttpServletRequest> authorizationManager,
                                 @Autowired DynamicSecurityMetadataSource dynamicSecurityMetadataSource,
                                 @Autowired IgnoreUrlsConfig ignoreUrlsConfig) {
        super(authorizationManager);
        this.dynamicSecurityMetadataSource = dynamicSecurityMetadataSource;
        this.ignoreUrlsConfig = ignoreUrlsConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
        //OPTIONS请求直接放行
        if(request.getMethod().equals(HttpMethod.OPTIONS.toString())){
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            return;
        }
        //白名单请求直接放行
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrlsConfig.getUrls()) {
            if(pathMatcher.match(path,request.getRequestURI())){
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
                return;
            }
        }
        // todo 此处会调用AccessDecisionManager中的decide方法进行鉴权操作
        fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
    }

    @Override
    public void destroy() {
    }

}
