package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.Project;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Autowired
	private DataSource ds;
	
	@Bean(name = "sesfact")
	public LocalSessionFactoryBean createLocalSessionFactBean() {
		LocalSessionFactoryBean bean = null;
		Properties props = null;
		bean = new LocalSessionFactoryBean();
		bean.setDataSource(ds);
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
