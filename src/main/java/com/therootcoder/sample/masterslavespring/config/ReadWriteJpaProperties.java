package com.therootcoder.sample.masterslavespring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Read-write jpa properties
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@ConfigurationProperties(prefix = "spring.jpa.readwrite")
public class ReadWriteJpaProperties extends AbstractJpaProperties {

}