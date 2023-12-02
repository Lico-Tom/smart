package com.smart.admin.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.admin.component.DynamicSecurityFilter;
import com.smart.admin.component.DynamicSecurityService;
import com.smart.admin.component.JwtAuthenticationTokenFilter;
import com.smart.admin.component.RestAuthenticationEntryPoint;
import com.smart.admin.component.RestfulAccessDeniedHandler;
import com.smart.admin.domain.Admin;
import com.smart.admin.domain.UserDetailsImpl;
import com.smart.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Lico-Tom
 * 2023/11/22 21:30
 * @version V1.0
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {


    private final IgnoreUrlsConfig ignoreUrlsConfig;

    private final AdminService adminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;
    @Autowired(required = false)
    private DynamicSecurityFilter dynamicSecurityFilter;

    @Autowired
    public SecurityConfig(IgnoreUrlsConfig ignoreUrlsConfig, AdminService adminService) {
        this.ignoreUrlsConfig = ignoreUrlsConfig;
        this.adminService = adminService;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        HttpSecurity register = http.authorizeHttpRequests((authorizeHttpRequests) -> {
                    // 不需要保护的资源路径允许问
                    ignoreUrlsConfig.getUrls().forEach(url -> authorizeHttpRequests.requestMatchers(url).permitAll());
                    authorizeHttpRequests
                            .requestMatchers("/index").permitAll()
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/static/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin((formLogin) -> formLogin.loginPage("/index").failureForwardUrl("/error/404"))
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
                .userDetailsService(userDetailsService)
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //有动态权限配置时添加动态权限校验过滤器
        if(dynamicSecurityService!=null){
            register.addFilterBefore(dynamicSecurityFilter, FilterSecurityInterceptor.class);
        }
        return register.build();
    }

 /*   @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            return User.withUserDetails(new UserDetailsImpl(adminService.getOne(wrapper)))
                    .passwordEncoder(new BCryptPasswordEncoder()::encode).build();
        };
    }*/
}
