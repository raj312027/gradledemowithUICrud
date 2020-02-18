package com.demogradle.gradledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stateMaster")
public class StateMaster {

	@Id
	private String stateId;
	private String state_name;
	private String cnt;
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public StateMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
