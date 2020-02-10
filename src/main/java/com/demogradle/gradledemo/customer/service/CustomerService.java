package com.demogradle.gradledemo.customer.service;

import java.util.Optional;

import com.demogradle.gradledemo.model.Customer;


public interface CustomerService {

	public void createCustomer(Customer cust);
	public Optional<Customer> findCustomerById(int id);
	
}
