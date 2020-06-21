package com.demogradle.gradledemo.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demogradle.gradledemo.model.BudgetMaster;

public interface BudgetRepo extends JpaRepository<BudgetMaster,Long> {

}
