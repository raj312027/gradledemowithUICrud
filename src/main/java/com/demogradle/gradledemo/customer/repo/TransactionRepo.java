package com.demogradle.gradledemo.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demogradle.gradledemo.model.TransactionEntity;
@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {

}
