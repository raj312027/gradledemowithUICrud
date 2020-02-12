package com.demogradle.gradledemo.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demogradle.gradledemo.customer.repo.TransactionRepo;
import com.demogradle.gradledemo.model.TransactionEntity;

@Service
public class TxnEnduserServiceImpl implements TransactionUserService {

	@Autowired
	private TransactionRepo txnRepo;

	@Override
	public void makeTransaction(TransactionEntity tx) {

		txnRepo.save(tx);

	}

}
