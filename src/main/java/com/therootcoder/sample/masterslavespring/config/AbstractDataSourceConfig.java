package com.therootcoder.sample.masterslavespring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * This should be used as base class while creating any datasource in the application
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
public abstract class AbstractDataSourceConfig {

    protected DataSource buildDataSource(AbstractDataSourceProperties dataSourceProperties) {
        HikariDataSource dataSource = new HikariDataSource(dataSourceProperties.getPoolProperties());
        return dataSource;
    }

    protected <T extends AbstractDataSourceProperties> LocalContainerEntityManagerFactoryBean buildLocalContainerEntityManagerFactoryBean(
            DataSource dataSource, T prop, AbstractJpaProperties jpaProperties) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(prop.getEntityPackageToScan());
        em.getJpaPropertyMap().putAll(jpaProperties.getProperties());

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(jpaProperties.isShowSql());
        vendorAdapter.setDatabase(jpaProperties.getDatabase());
        vendorAdapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
        vendorAdapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(jpaProperties.getProperties());
        return em;
    }

    protected PlatformTransactionManager buildTransactionManager(LocalContainerEntityManagerFactoryBean emFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emFactoryBean.getObject());
        return transactionManager;
    }
}