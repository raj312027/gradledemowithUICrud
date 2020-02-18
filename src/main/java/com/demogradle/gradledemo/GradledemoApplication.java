package com.demogradle.gradledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@PropertySource(value = { "classpath:application-error_mapping.properties","classpath:country_state_mapping.properties"})
public class GradledemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GradledemoApplication.class, args);
	}

	@Bean
	public MessageSource getMsgSource() {
		ReloadableResourceBundleMessageSource rs = new ReloadableResourceBundleMessageSource();
		rs.setBasename("classpath:messages");
		rs.setDefaultEncoding("UTF-8");
		return rs;

	}

	@Bean
	public LocalValidatorFactoryBean getFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(getMsgSource());
		return bean;
	}

	
	


}
