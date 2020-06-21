package com.demogradle.gradledemo.customer.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demogradle.gradledemo.model.ProductDetails;

public interface ProductRepository extends PagingAndSortingRepository<ProductDetails, Integer>{

}
