package com.smart.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lizhonghao
 */

@EnableScheduling
@EnableRetry
@ConfigurationPropertiesScan
@ImportResource(value = "classpath:spring-aop.xml")
@MapperScan("com.smart.*.mapper")
@SpringBootApplication(scanBasePackages = "com.smart", exclude = SecurityAutoConfiguration.class)
public class SmartStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStarterApplication.class, args);
    }

}

