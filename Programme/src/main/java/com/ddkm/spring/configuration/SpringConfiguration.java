package com.ddkm.spring.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.ddkm.dto","com.ddkm.controller", "com.ddkm.dao","com.ddkm.beans","com.ddkm.sevice"})
public class SpringConfiguration {


	@Bean(name = "SessionFactory")
	public SessionFactory getSessionFactory() {
		try {
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ddkm_owner");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "1qaz!QAZ");
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hibernate.hbm2ddl.auto","update");
			prop.setProperty("hibernate.show_sql","true");
			org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
					.addAnnotatedClass(com.ddkm.dto.ProgrammeArchiveDto.class)
					.addAnnotatedClass(com.ddkm.dto.PersonDto.class)
					.setProperties(prop);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

}