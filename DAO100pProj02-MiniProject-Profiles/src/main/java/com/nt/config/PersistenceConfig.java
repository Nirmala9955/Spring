package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	@Profile("dev")
	public DataSource createC3P0DS() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///nssp713db");
		ds.setUser("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	@Profile("test")
	public DataSource createApacheDBCPDSMySQL() throws Exception {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///nssp713db");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}

	@Bean
	@Profile("uat")
	public DataSource createApacheDBCPDSOracle() throws Exception {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		return bds;
	}
	
	@Bean
	@Profile("prod")
	public DataSource createHikariCPDS() throws Exception {
		HikariDataSource hds = new HikariDataSource();
		hds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hds.setUsername("system");
		hds.setPassword("manager");
		return hds;
	} 
	
	@Bean
	@Profile("dev")
	public JdbcTemplate createJTUsingC3PODS() throws Exception {
		return new JdbcTemplate(createC3P0DS());
	}
	
	@Bean
	@Profile("test")
	public JdbcTemplate createJTUsingApacheDPCPDSWithMySQL() throws Exception {
		return new JdbcTemplate(createApacheDBCPDSMySQL());
	}
	
	@Bean
	@Profile("uat")
	public JdbcTemplate createJTUsingApacheDPCPDSWithOracle() throws Exception {
		return new JdbcTemplate(createApacheDBCPDSOracle());
	}
	
	@Bean
	@Profile("prod")
	public JdbcTemplate createJTUsingHikariCPDS() throws Exception {
		return new JdbcTemplate(createHikariCPDS());
	}
	
}
