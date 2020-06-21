package com.demogradle.gradledemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Details")
public class ProductDetails {

	@Id
	@Column(name = "Product_ID")
	private int prodId;

	@Column(name = "Product_Name")
	private String productName;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public ProductDetails(int prodId, String productName) {
		super();
		this.prodId = prodId;
		this.productName = productName;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductDetails [prodId=" + prodId + ", productName=" + productName + "]";
	}
}
