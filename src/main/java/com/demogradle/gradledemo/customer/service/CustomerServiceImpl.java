package com.demogradle.gradledemo.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demogradle.gradledemo.customer.repo.CustomerRepository;
import com.demogradle.gradledemo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	public void createCustomer(Customer cust) {

		custRepo.save(cust);

	}
	
	public Optional<Customer> findCustomerById(int id){
		return custRepo.findById(id);
	}

}
