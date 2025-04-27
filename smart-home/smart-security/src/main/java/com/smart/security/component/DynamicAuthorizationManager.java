package com.smart.security.component;

import cn.hutool.core.util.URLUtil;
import com.smart.security.service.DynamicSecurityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Supplier;

/**
 * 动态权限决策管理器，用于判断用户是否有访问权限
 *
 * @author lizhonghao
 * @date 2023/12/3
 */
@Component
public class DynamicAuthorizationManager implements AuthorizationManager<HttpServletRequest> {

    private static Map<String, ConfigAttribute> configAttributeMap = null;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, HttpServletRequest authorizationContext) {
        Collection<ConfigAttribute> configAttributes = getAttributes(authorizationContext);
        if (configAttributes == null || configAttributes.isEmpty()) {
            return new AuthorizationDecision(true);
        }
        for (ConfigAttribute configAttribute : configAttributes) {
            //将访问所需资源或用户拥有资源进行比对
            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.get().getAuthorities()) {
                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                    return new AuthorizationDecision(true);
                }
            }
        }
        return new AuthorizationDecision(false);
    }

    public Collection<ConfigAttribute> getAttributes(HttpServletRequest authorizationContext) {
        if (configAttributeMap == null) {
            this.loadDataSource();
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        //获取当前访问的路径
        String url = UrlUtils.buildFullRequestUrl(authorizationContext);
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        for (Map.Entry<String, ConfigAttribute> attributeEntry : configAttributeMap.entrySet()) {
            if (pathMatcher.match(attributeEntry.getKey(), path)) {
                configAttributes.add(attributeEntry.getValue());
            }
        }
        // 未设置操作请求权限，返回空集合
        return configAttributes;
    }
}
