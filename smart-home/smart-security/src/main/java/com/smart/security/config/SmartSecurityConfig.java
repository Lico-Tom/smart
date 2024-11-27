package com.smart.security.config;

import com.smart.security.component.JwtAuthenticationTokenFilter;
import com.smart.security.component.RestAuthenticationEntryPoint;
import com.smart.security.component.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


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



    public SmartSecurityConfig(@Autowired IgnoreUrlsConfig ignoreUrlsConfig,
                               @Autowired RestfulAccessDeniedHandler restfulAccessDeniedHandler,
                               @Autowired RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                               @Autowired JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.ignoreUrlsConfig = ignoreUrlsConfig;
        this.restfulAccessDeniedHandler = restfulAccessDeniedHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        HttpSecurity http = httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequest -> {
                    ignoreUrlsConfig.getUrls().forEach(url -> authorizeHttpRequest.requestMatchers(url).permitAll());
                    authorizeHttpRequest.anyRequest().authenticated();
                })
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptionHand -> exceptionHand
                        .accessDeniedHandler(restfulAccessDeniedHandler)
                        .authenticationEntryPoint(restAuthenticationEntryPoint))
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
