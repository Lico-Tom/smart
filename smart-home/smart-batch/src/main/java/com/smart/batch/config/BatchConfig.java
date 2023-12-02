package com.smart.batch.config;

import org.springframework.stereotype.Component;


/**
 * @author Lico-Tom
 * 2023/11/15 19:44
 * @version V1.0
 */
@Component
public class BatchConfig {

    /**
     * JobRepository 定义： Job 的注册容器以及和数据库 事务管理
     * @param dataSource
     * @param platformTransactionManager
     * @return
     * @throws Exception
     */
    /*
    @Bean
    public JobRepository jobRepository(DataSource dataSource,
                                       PlatformTransactionManager platformTransactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(platformTransactionManager);
        return jobRepositoryFactoryBean.getObject();
    }*/

}
