package com.demogradle.gradledemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfig {

	@Autowired
	private Environment env;
/*	private static final String ds_url="spring.datasource.url";
	private static final String ds_username="spring.datasource.username";
	private static final String ds_pwd="spring.datasource.password";
	private static final String ds_classname="spring.datasource.driver-class-name";
*/
	private static final String ds_url="oracle_url";
	private static final String ds_username="oracle_username";
	private static final String ds_pwd="oracle_pwd";
	private static final String ds_classname="oracle_classname";
	
	@Bean
	public DataSource setDataSource(){
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName(env.getProperty(ds_classname));
		ds.setJdbcUrl(env.getProperty(ds_url));
		ds.setUsername(env.getProperty(ds_username));
		ds.setPassword(env.getProperty(ds_pwd));
		
		return ds;
		
	}
	
	
}
