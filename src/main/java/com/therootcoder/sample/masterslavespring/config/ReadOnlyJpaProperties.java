package com.therootcoder.sample.masterslavespring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Read-only jpa properties
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@ConfigurationProperties(prefix = "spring.jpa.readonly")
public class ReadOnlyJpaProperties extends AbstractJpaProperties {

}