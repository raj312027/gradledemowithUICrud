package com.demogradle.gradledemo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demogradle.gradledemo.custom.exceptions.CustomValidationEx;
import com.demogradle.gradledemo.custom.exceptions.CustomerException;
import com.demogradle.gradledemo.customer.service.CustomerService;
import com.demogradle.gradledemo.customer.service.SecurityUserService;
import com.demogradle.gradledemo.customer.service.TransactionUserService;
import com.demogradle.gradledemo.model.Customer;
import com.demogradle.gradledemo.model.EndUser;
import com.demogradle.gradledemo.model.SecurityUser;
import com.demogradle.gradledemo.model.TransactionEntity;

@RestController
public class HomeController {

	@Autowired
	private CustomerService custService;

	@Autowired
	private TransactionUserService txUser;

	@Autowired
	private SecurityUserService securityUserService;

	@GetMapping("/")
	public String welcomeMsg() {

		return "Welcome to Spring boot app with gradle";
	}

	@PostMapping("/saveCustomer")
	public Customer createCustomer(@RequestBody Customer cust) throws Exception {

		custService.createCustomer(cust);
		return cust;
	}

	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {

		Optional<Customer> cust = custService.findCustomerById(id);
		if (!cust.isPresent())
			throw new CustomerException();

		return cust.get();
	}

	@PostMapping("/createUser")
	public String createUser(@Valid @RequestBody SecurityUser user, BindingResult rs, HttpSession session)
			throws Exception {

		if (!rs.hasErrors()) {
			if (securityUserService.createUser(user)) {
				return "User created successfully";
			}

			throw new CustomerException();
		} else {
			session.setAttribute("bindingRs", rs);
			throw new CustomValidationEx();
		}
	}

/*	@PostMapping("/createEnduser")
	public String createEnuser(@RequestBody EndUser user) {
		txUser.createEndUser(user);
		return "End user created";
	}*/

	@PostMapping("/maketransaction")
	public String makeTransaction(@RequestBody TransactionEntity txn) {
		txUser.makeTransaction(txn);
		return "Transaction successfully";
	}
}
