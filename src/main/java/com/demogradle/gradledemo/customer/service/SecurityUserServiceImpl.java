package com.demogradle.gradledemo.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demogradle.gradledemo.customer.repo.CustomerRepository;
import com.demogradle.gradledemo.customer.repo.SecurityUserRepo;
import com.demogradle.gradledemo.model.SecurityUser;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

	@Autowired
	private SecurityUserRepo repo;
	@Autowired
	private CustomerRepository cust;

	@Override
	public boolean createUser(SecurityUser user) {
		List<String> customerIDs = new ArrayList<>();
		boolean flag=false;
		cust.findAll().forEach(x -> {
			customerIDs.add(x.getCustomerId());
		});

		if (!customerIDs.isEmpty() && customerIDs.contains(user.getCustId())) {
			flag=true;
			repo.save(user);
		}
		repo.save(user);
		return flag;
	}
}
