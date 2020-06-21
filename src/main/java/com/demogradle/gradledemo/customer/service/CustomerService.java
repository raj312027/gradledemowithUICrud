package com.demogradle.gradledemo.customer.service;

import java.util.List;
import java.util.Optional;

import com.demogradle.gradledemo.model.BudgetMaster;
import com.demogradle.gradledemo.model.Customer;


public interface CustomerService {

	public void createCustomer(Customer cust);
	public Optional<Customer> findCustomerById(int id);
	public void saveBudget();
	public BudgetMaster getBudgetMaster(String contractId);
	public List<BudgetMaster> getBudgetList();
	
}
