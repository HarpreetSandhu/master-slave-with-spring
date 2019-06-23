package com.therootcoder.sample.masterslavespring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigurationProperties file to map readonly datasource properties to pojo
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.readwrite")
public class ReadWriteDataSourceProperties extends AbstractDataSourceProperties {

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
    }
}