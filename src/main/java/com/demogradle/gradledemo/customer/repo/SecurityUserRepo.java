package com.demogradle.gradledemo.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demogradle.gradledemo.model.SecurityUser;

public interface SecurityUserRepo extends JpaRepository<SecurityUser, Integer>{

}
