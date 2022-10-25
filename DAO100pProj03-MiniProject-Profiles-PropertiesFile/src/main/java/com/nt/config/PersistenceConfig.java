package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	@Profile("dev")
	public DataSource createC3P0DS() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(env.getProperty("jdbc.mysql.driverclass"));
		ds.setJdbcUrl(env.getProperty("jdbc.mysql.url"));
		ds.setUser(env.getProperty("jdbc.mysql.username"));
		ds.setPassword(env.getProperty("jdbc.mysql.password"));
		return ds;
	}

	@Bean
	@Profile("test")
	public DataSource createApacheDBCPDSMySQL() throws Exception {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("jdbc.mysql.driverclass"));
		bds.setUrl(env.getProperty("jdbc.mysql.url"));
		bds.setUsername(env.getProperty("jdbc.mysql.username"));
		bds.setPassword(env.getProperty("jdbc.mysql.password"));
		return bds;
	}

	@Bean
	@Profile("uat")
	public DataSource createApacheDBCPDSOracle() throws Exception {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("jdbc.oracle.driverclass"));
		bds.setUrl(env.getProperty("jdbc.oracle.url"));
		bds.setUsername(env.getProperty("jdbc.oracle.username"));
		bds.setPassword(env.getProperty("jdbc.oracle.password"));
		return bds;
	}
	
	@Bean
	@Profile("prod")
	public DataSource createHikariCPDS() throws Exception {
		HikariDataSource hds = new HikariDataSource();
		hds.setDriverClassName(env.getProperty("jdbc.oracle.driverclass"));
		hds.setJdbcUrl(env.getProperty("jdbc.oracle.url"));
		hds.setUsername(env.getProperty("jdbc.oracle.username"));
		hds.setPassword(env.getProperty("jdbc.oracle.password"));
		return hds;
	} 
	
	@Bean(autowire = Autowire.BY_TYPE)
	public JdbcTemplate createJT() throws Exception {
		return new JdbcTemplate();
	}

}
