package com.demogradle.gradledemo.controller.advise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demogradle.gradledemo.custom.exceptions.CustomerException;

@ControllerAdvice
@PropertySource("classpath:application-error_mapping.properties")
public class CustomerAdvise {

	// @Value("${C102}")
	// private String error;

	@Autowired
	private Environment env;

	@ExceptionHandler({ RuntimeException.class })
	private ResponseEntity<String> handleDataAccessException(RuntimeException e) throws Exception {

		return handleOracleEx(HttpStatus.NOT_FOUND, e);
	}

	private ResponseEntity<String> handleOracleEx(HttpStatus status, RuntimeException e) {
		if (e instanceof DataIntegrityViolationException) {
			return ResponseEntity.status(status).body("Customer already exists");
		}
		return ResponseEntity.status(status).body(e.getMessage());
	}

	@ExceptionHandler(CustomerException.class)
	private ResponseEntity<String> customerNotFoundEx(CustomerException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(env.getProperty("C102"));

	}
	
	
}
