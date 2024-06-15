package com.smart.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Lico-Tom
 * 2024/8/8 23:49
 * @version V1.0
 */

@Profile("proc")
@Component
public class DataSourceConfig {

    @Value("${MYSQL_IP:}")
    private String MYSQL_IP;

    @Value("${MYSQL_PORT:3306}")
    private int MYSQL_PORT;

    @Value("${DATABASE_NAME:}")
    private String DATABASE_NAME;

    @Value("${MYSQL_USER:}")
    private String username;

    @Value("${MYSQL_PASSWORD:}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&useSSL=false",
                MYSQL_IP,
                MYSQL_PORT,
                DATABASE_NAME);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
