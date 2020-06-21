package com.demogradle.gradledemo.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demogradle.gradledemo.customer.repo.ProductRepository;
import com.demogradle.gradledemo.model.ProductDetails;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRepo;
	
	
	public void createProductDetails(ProductDetails prd){
		try{
		   prodRepo.save(prd);
		}
		catch(Exception e){
			System.out.println("Exception occured in creating product "+e);
		}
	}
	
	
	public ProductDetails findByProductId(int id) {
		try {
			Optional<ProductDetails> prodOptional = prodRepo.findById(id);
			if (prodOptional.isPresent()) {
				return prodOptional.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Exception occured in geting  product by ID " + e);
		}
		
		
		return null;
	}
	
	public Page<ProductDetails> findAll(Pageable pageable){
		return prodRepo.findAll(pageable);
	}


	public ProductRepository getProdRepo() {
		return prodRepo;
	}
}
