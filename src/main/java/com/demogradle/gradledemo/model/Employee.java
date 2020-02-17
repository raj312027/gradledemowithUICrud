package com.demogradle.gradledemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int empId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String ename;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Emp_Prj", joinColumns = { @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "Project_ID") })
	Set<Project> projects = new HashSet<>();

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
