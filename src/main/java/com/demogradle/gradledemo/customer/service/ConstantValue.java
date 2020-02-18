package com.demogradle.gradledemo.customer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class ConstantValue {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<String> getStateList(String cnt){
		
		return em.createNativeQuery("select state_name from stateMaster where cnt="+"'"+cnt+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCityList(String st){
		
		return em.createNativeQuery("select city from citymaster where stateid="+"'"+st+"'").getResultList();
	}
	
	
}
