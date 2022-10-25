package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name = "oracleADSB")
	public AtomikosDataSourceBean createADSForOracle() {
		AtomikosDataSourceBean adsOracle = new AtomikosDataSourceBean();
		adsOracle.setUniqueResourceName("oracleXADS");
		adsOracle.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		Properties props = new Properties();
		props.setProperty("databaseName", "xe");
		props.setProperty("user", "system");
		props.setProperty("password", "manager");
		props.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:xe");
		adsOracle.setXaProperties(props);
		return adsOracle;
	}

	@Bean(name = "mysqlADBS")
	public AtomikosDataSourceBean createADSForMySQL() {
		AtomikosDataSourceBean adsMySQL = new AtomikosDataSourceBean();
		adsMySQL.setUniqueResourceName("mysqlXADS");
		adsMySQL.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		Properties props = new Properties();
		props.setProperty("databaseName", "nssp713db");
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		props.setProperty("URL", "jdbc:mysql:///nssp713db");
		adsMySQL.setXaProperties(props);
		return adsMySQL;
	}
	
	@Bean(name = "oracleTemplate")
	public JdbcTemplate createJTForOracle() {
		return new JdbcTemplate(createADSForOracle());
	}

	@Bean(name = "mysqlTemplate")
	public JdbcTemplate createJTForMySQL() {
		return new JdbcTemplate(createADSForMySQL());
	}
	
}
