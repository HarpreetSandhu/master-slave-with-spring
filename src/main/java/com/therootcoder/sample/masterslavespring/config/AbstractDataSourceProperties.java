package com.therootcoder.sample.masterslavespring.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

/**
 * Base class to read data source properties. It should be extended by all datasource properties pojo files
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
public class AbstractDataSourceProperties extends DataSourceProperties {

    private static final String KEY_USERNAME = "user";
    private static final String KEY_PASSWORD = "password";

    private HikariConfig poolProperties;

    //common connection pooling and other props
    protected String[] entityPackageToScan;

    /**
     * NOTE: Other connection pool properties can be added here
     * Currently, I have added only those properties which I'm going to
     * use for Hikari Pool
     *
     * CAUTION: datatype of few of following properties is as per
     * specifications of datasource provider(HIKARI, TOMCAT, DBCP/DBCP2, etc)
     */
    // --START Pool Properties
    protected int maxActive;
    protected int minEvictableIdleTimeMillis;
    protected boolean testOnBorrow;
    protected boolean testOnReturn;
    protected int timeBetweenEvictionRunsMillis;
    protected int maxWait;
    private String validationQuery;
    // --END Pool Properties

    public String[] getEntityPackageToScan() {
        return entityPackageToScan;
    }

    public void setEntityPackageToScan(String[] entityPackageToScan) {
        this.entityPackageToScan = entityPackageToScan;
    }

    protected HikariConfig getPoolProperties() {
        return poolProperties;
    }

    /**
     * It creates PoolProperties object specific to
     * data source provider
     */
    private void createPoolProperties() {
        poolProperties = new HikariConfig();
        poolProperties.getDataSourceProperties().put(KEY_USERNAME, getUsername());
        poolProperties.getDataSourceProperties().put(KEY_PASSWORD, getPassword());
        poolProperties.setDriverClassName(getDriverClassName());
        poolProperties.setUsername(getUsername());
        poolProperties.setPassword(getPassword());
        poolProperties.setConnectionTestQuery(getValidationQuery());
        poolProperties.setJdbcUrl(getUrl());

        //connection pool specific props
        poolProperties.setMaximumPoolSize(maxActive);
        //poolProperties.set(minEvictableIdleTimeMillis);
        //poolProperties.(testOnBorrow);
        //poolProperties.setTestOnReturn(testOnReturn);
        //poolProperties.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        poolProperties.setConnectionTimeout(maxWait);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        createPoolProperties();
        super.afterPropertiesSet();
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }
}