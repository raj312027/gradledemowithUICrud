package com.demogradle.gradledemo.controller.advise;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demogradle.gradledemo.custom.exceptions.CustomValidationEx;
import com.demogradle.gradledemo.custom.exceptions.CustomerException;

@ControllerAdvice
public class CustomerAdvise {

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

	@ExceptionHandler(CustomValidationEx.class)
	private ResponseEntity<String> securityUserValidate(HttpServletRequest request) {
		String errorMsg = "";
		List<String> errorList = new ArrayList<>();
        HttpSession session=request.getSession(false);
        BindingResult rs=(BindingResult) session.getAttribute("bindingRs");
		rs.getAllErrors().forEach(x -> {
			errorList.add(((FieldError) x).getDefaultMessage());

		});
		for (String s : errorList)
			errorMsg += s + "\n";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);

	}
	
	


}
