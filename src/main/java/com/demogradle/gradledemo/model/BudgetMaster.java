package com.demogradle.gradledemo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class BudgetMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "prod-generator")
	@GenericGenerator(name = "prod-generator", parameters = @Parameter(name = "prefix", value = "prod"), strategy = "com.demogradle.gradledemo.generators.CustomSequenceGenerator")
	@Column(name = "BUDGETID")
	private String budgetId;

	@Column(name = "ORDERNO")
	private String orderNo;

	@Column(name = "CONTRACTID")
	private String contractId;

	@Column(name = "STARTDATE")
	private Date startDate;

	@Column(name = "ENDDATE")
	private Date endDate;

	@Column(name = "CREATEDDATE")
	private Date createdDate;

	@Column(name = "UPDATEDDATE")
	private Date updatedDate;

	public String getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public BudgetMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BudgetMaster(String orderNo, String contractId, Date startDate, Date endDate,
			Date createdDate, Date updatedDate) {
		super();
		this.orderNo = orderNo;
		this.contractId = contractId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
