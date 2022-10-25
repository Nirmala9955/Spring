	package com.nt.config;
	
	import java.util.Properties;
	
	import javax.sql.DataSource;
	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.orm.hibernate5.HibernateTemplate;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
	
	import com.nt.entity.Project;
	import com.zaxxer.hikari.HikariDataSource;
	
	@Configuration
	@ComponentScan(basePackages = "com.nt.dao")
	public class PersistenceConfig {
	
		@Bean(name = "hkDs")
		public DataSource createDataSource() {
			HikariDataSource hkDs = null;
			hkDs = new HikariDataSource();
			hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
			hkDs.setUsername("system");
			hkDs.setPassword("manager");
			hkDs.setMaximumPoolSize(100);
			hkDs.setMinimumIdle(10);
			return hkDs;
		}
	
		@Bean(name = "sesfact")
		public LocalSessionFactoryBean createLocalSessionFactBean() {
			LocalSessionFactoryBean bean = null;
			Properties props = null;
			bean = new LocalSessionFactoryBean();
			bean.setDataSource(createDataSource());
			bean.setAnnotatedClasses(Project.class);
			props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			props.setProperty("hibernate.hbm2ddl.auto", "update");
			props.setProperty("hibernate.show_sql", "true");
			props.setProperty("hibernate.format_sql", "true");
			bean.setHibernateProperties(props);
			return bean;
		}
		
		@Bean(name = "ht")
		public HibernateTemplate createHibernateTemplate() {
			return new HibernateTemplate(createLocalSessionFactBean().getObject());
		}
		
	}
