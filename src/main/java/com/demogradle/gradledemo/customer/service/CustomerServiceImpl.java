package com.demogradle.gradledemo.customer.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demogradle.gradledemo.cache.CacheAccess;
import com.demogradle.gradledemo.customer.repo.BudgetRepo;
import com.demogradle.gradledemo.customer.repo.CustomerRepository;
import com.demogradle.gradledemo.model.BudgetMaster;
import com.demogradle.gradledemo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private BudgetRepo budgetRepo;

	public void createCustomer(Customer cust) {
		custRepo.save(cust);
	}
	
	public Optional<Customer> findCustomerById(int id){
		return custRepo.findById(id);
	}
	
	public void saveBudget(){
		for(int i=0;i<100;i++){
			BudgetMaster bm=new BudgetMaster( "ORD100002729", "00051/TKAL/2020", new Date(), new Date(),  new Date(), null);
			budgetRepo.save(bm);
		}
	}
	
	public  BudgetMaster  getBudgetMaster(String budgetId){
		Map<String,BudgetMaster> budgetMap=  CacheAccess.getCacheMap("budgetMaster");
		return budgetMap.get(budgetId);
	}

	@Override
	public List<BudgetMaster> getBudgetList() {
		Map<String, BudgetMaster> budgetMap = CacheAccess.getCacheMap("budgetMaster");
		List<BudgetMaster> budgetList = budgetMap.values().stream().collect(Collectors.toList());
		Collections.sort(budgetList, new Comparator<BudgetMaster>() {
			@Override
			public int compare(BudgetMaster o1, BudgetMaster o2) {
				return o1.getBudgetId().compareTo(o2.getBudgetId());
			}
		});
		return budgetList;
	}

}
