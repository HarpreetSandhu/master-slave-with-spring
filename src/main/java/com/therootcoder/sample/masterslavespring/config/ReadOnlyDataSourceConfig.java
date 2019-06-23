package com.therootcoder.sample.masterslavespring.config;

import com.therootcoder.sample.masterslavespring.annotation.ReadOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Read-only datasource configuration
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@Configuration
@EnableJpaRepositories(basePackages = "com.therootcoder.sample.masterslavespring.repository",
        entityManagerFactoryRef = "readOnlyEntityManagerFactory",
        includeFilters = @ComponentScan.Filter(ReadOnly.class))
@EnableTransactionManagement(proxyTargetClass = true)
public class ReadOnlyDataSourceConfig extends AbstractDataSourceConfig {

    @Autowired
    private ReadOnlyDataSourceProperties readOnlyDataSourceProperties;

    @Autowired
    private ReadOnlyJpaProperties readOnlyJpaProperties;

    @Bean(name = "readOnlyDataSource")
    DataSource readOnlyDataSource() {
        return buildDataSource(this.readOnlyDataSourceProperties);
    }

    @Bean(name = "readOnlyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readOnlyEntityManagerFactory() {
        return buildLocalContainerEntityManagerFactoryBean(readOnlyDataSource(), readOnlyDataSourceProperties, readOnlyJpaProperties);
    }
}