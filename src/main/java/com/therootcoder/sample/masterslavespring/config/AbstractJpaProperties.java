package com.therootcoder.sample.masterslavespring.config;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;

/**
 *  Base class to read jpa properties.
 *  Note: custom common props can be added here which could be used by
 *  read-write/read-only datasources
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
public abstract class AbstractJpaProperties extends JpaProperties {

}