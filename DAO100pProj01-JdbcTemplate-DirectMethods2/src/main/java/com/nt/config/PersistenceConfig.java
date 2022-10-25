package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="hkDs")
	public HikariDataSource createDataSource() {
		HikariDataSource hkDs = null;
		hkDs = new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.user"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.pwd"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.hcp.minisize")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("jdbc.hcp.maxsize")));
		return hkDs;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDataSource());
	}
	
}
