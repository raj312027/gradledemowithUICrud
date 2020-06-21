package com.demogradle.gradledemo.customer.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demogradle.gradledemo.model.PICMaster;
@Transactional
public interface PicRepo extends JpaRepository<PICMaster,Integer> {
	
	@Modifying
	@Query("update PICMaster set name='sagar'")
	public Integer updateName(int id);

}
