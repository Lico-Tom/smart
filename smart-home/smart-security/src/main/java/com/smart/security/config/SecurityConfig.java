package com.smart.security.config;

import com.smart.core.utils.JwtTokenUtil;
import com.smart.security.component.DynamicSecurityFilter;
import com.smart.security.component.DynamicSecurityService;
import com.smart.security.component.JwtAuthenticationTokenFilter;
import com.smart.security.component.RestAuthenticationEntryPoint;
import com.smart.security.component.RestfulAccessDeniedHandler;
import jakarta.persistence.Access;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.function.Supplier;

/**
 * @author Lico-Tom
 * 2023/12/3 8:39
 * @version V1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final IgnoreUrlsConfig ignoreUrlsConfig;

    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final DynamicSecurityService dynamicSecurityService;

    private final DynamicSecurityFilter dynamicSecurityFilter;

    public SecurityConfig(@Autowired IgnoreUrlsConfig ignoreUrlsConfig,
                          @Autowired RestfulAccessDeniedHandler restfulAccessDeniedHandler,
                          @Autowired RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                          @Autowired JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter,
                          @Autowired(required = false) DynamicSecurityService dynamicSecurityService,
                          @Autowired(required = false) DynamicSecurityFilter dynamicSecurityFilter) {
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
                    authorizeHttpRequest.anyRequest().authenticated();
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
