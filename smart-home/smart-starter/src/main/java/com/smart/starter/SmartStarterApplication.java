package com.smart.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lizhonghao
 */

@EnableRetry
@EnableScheduling
@MapperScan({"com.smart.*.mapper", "com.smart.*.*.mapper"})
@ImportResource(value = "classpath:spring-aop.xml")
@ConfigurationPropertiesScan(basePackages = "com.smart.*.config")
@SpringBootApplication(scanBasePackages = "com.smart")
public class SmartStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStarterApplication.class, args);
    }

}


