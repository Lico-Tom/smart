package com.smart.security.config;

import com.smart.security.component.*;
import com.smart.security.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author Lico-Tom
 * 2023/12/3 8:39
 * @version V1.0
 */
@Configuration
@EnableWebSecurity
public class SmartSecurityConfig {


    private final IgnoreUrlsConfig ignoreUrlsConfig;

    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final DynamicSecurityService dynamicSecurityService;

    private final DynamicSecurityFilter dynamicSecurityFilter;

    public SmartSecurityConfig(@Autowired IgnoreUrlsConfig ignoreUrlsConfig,
                               @Autowired RestfulAccessDeniedHandler restfulAccessDeniedHandler,
                               @Autowired RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                               @Autowired JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter,
                               @Autowired DynamicSecurityService dynamicSecurityService,
                               @Autowired DynamicSecurityFilter dynamicSecurityFilter) {
        this.ignoreUrlsConfig = ignoreUrlsConfig;
        this.restfulAccessDeniedHandler = restfulAccessDeniedHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
        this.dynamicSecurityService = dynamicSecurityService;
        this.dynamicSecurityFilter = dynamicSecurityFilter;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        HttpSecurity register = httpSecurity.authorizeHttpRequests(authorizeHttpRequest -> {
                    ignoreUrlsConfig.getUrls().forEach(url -> authorizeHttpRequest.requestMatchers(url).permitAll());
                    authorizeHttpRequest.requestMatchers(HttpMethod.OPTIONS).permitAll();
                    authorizeHttpRequest.requestMatchers(HttpMethod.POST, "/v1/smart/user/login").permitAll();
                    authorizeHttpRequest.anyRequest().authenticated();
                   // authorizeHttpRequest.anyRequest().access(dynamicAuthorizationManager);
                })
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptionHand -> exceptionHand
                        .accessDeniedHandler(restfulAccessDeniedHandler)
                        .authenticationEntryPoint(restAuthenticationEntryPoint))
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        if (dynamicSecurityService != null) {
            register.addFilterBefore(dynamicSecurityFilter, AuthorizationFilter.class);
        }
        return register.build();
    }

}
