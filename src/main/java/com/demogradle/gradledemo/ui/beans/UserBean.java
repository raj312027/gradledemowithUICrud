package com.demogradle.gradledemo.ui.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
