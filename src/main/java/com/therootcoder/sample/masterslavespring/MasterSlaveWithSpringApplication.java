package com.therootcoder.sample.masterslavespring;

import com.therootcoder.sample.masterslavespring.config.ReadOnlyDataSourceProperties;
import com.therootcoder.sample.masterslavespring.config.ReadOnlyJpaProperties;
import com.therootcoder.sample.masterslavespring.config.ReadWriteDataSourceProperties;
import com.therootcoder.sample.masterslavespring.config.ReadWriteJpaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.therootcoder.sample.masterslavespring.*",
		exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@EnableConfigurationProperties({ReadOnlyDataSourceProperties.class, ReadWriteDataSourceProperties.class,
		ReadOnlyJpaProperties.class, ReadWriteJpaProperties.class})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MasterSlaveWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSlaveWithSpringApplication.class, args);
	}
}