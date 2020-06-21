package com.demogradle.gradledemo.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demogradle.gradledemo.customer.repo.BudgetRepo;
import com.demogradle.gradledemo.customer.repo.CustomerRepository;
import com.demogradle.gradledemo.customer.service.CustomerServiceImpl;
import com.demogradle.gradledemo.model.BudgetMaster;

@RunWith(SpringJUnit4ClassRunner.class)
public class GradleServiceTest {
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	private BudgetRepo budgetRepo;
	
	
	@Mock
	private CustomerRepository custRepo;
	
	public static final int ID=5;
	@Test
	public void saveBudgetTest(){
		
		customerService.saveBudget();
		
	}
	
	@Test
	public void findCustomerByIdTest(){
		customerService.findCustomerById(ID);
	//	verify(custRepo.findById(ID));
	}

}
