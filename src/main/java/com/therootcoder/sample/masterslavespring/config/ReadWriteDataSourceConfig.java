package com.therootcoder.sample.masterslavespring.config;

import com.therootcoder.sample.masterslavespring.annotation.ReadOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Read-write data source configuration
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@Configuration
@EnableJpaRepositories(basePackages = "com.therootcoder.sample.masterslavespring.repository",
        entityManagerFactoryRef = "readWriteEntityManagerFactory",
        transactionManagerRef = "transactionManager",
        excludeFilters = @ComponentScan.Filter(ReadOnly.class))
@EnableTransactionManagement(proxyTargetClass = true)
public class ReadWriteDataSourceConfig extends AbstractDataSourceConfig {

    @Autowired
    private ReadWriteDataSourceProperties readWriteDataSourceProperties;

    @Autowired
    private ReadWriteJpaProperties readWriteJpaProperties;

    @Bean(name = "readWriteDataSource")
    DataSource readWriteDataSource() {
        return buildDataSource(readWriteDataSourceProperties);
    }

    @Bean(name = "readWriteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readWriteEntityManagerFactory() {
        return buildLocalContainerEntityManagerFactoryBean(readWriteDataSource(), readWriteDataSourceProperties, readWriteJpaProperties);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager readWriteTransactionManager() {
        return buildTransactionManager(readWriteEntityManagerFactory());
    }
}