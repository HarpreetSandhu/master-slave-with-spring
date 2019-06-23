/*
 * Copyright (c) 2019. Lenskart and/or its affiliates. All rights reserved.
 */
package com.therootcoder.sample.masterslavespring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigurationProperties file to map readonly datasource properties to pojo
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@ConfigurationProperties(prefix = "spring.datasource.readonly")
@Configuration
public class ReadOnlyDataSourceProperties extends AbstractDataSourceProperties {

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
    }
}