package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.nt.service", "com.nt.dao"})
@PropertySource(value="com/nt/commons/jdbc.properties")
//@PropertySource(value= {"com/nt/commons/jdbc.properties", "com/nt/commons/jdbc.properties"})
public class BusinessAppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="hkDs")
	public DataSource createDS() {
		HikariDataSource hkDs = null;
		//Create DataSource
		hkDs = new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.user"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.password"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("pool.minIdle")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("pool.maxSize")));
		return hkDs;
	}
	
}
