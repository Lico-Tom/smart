package com.smart.security.config;

import com.smart.core.utils.JwtTokenUtil;
import com.smart.security.component.DynamicSecurityService;
import com.smart.security.domain.Resource;
import com.smart.security.service.ResourceService;
import com.smart.security.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lico-Tom
 * 2023/12/3 15:49
 * @version V1.0
 */
@Configuration
public class CommonConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        //获取登录用户信息
        return userService::loadUserByUsername;
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService(ResourceService resourceService) {
        return () -> {
            Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
            List<Resource> resourceList = resourceService.listAll();
            for (Resource resource : resourceList) {
                map.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
        };
    }

}
