package com.demogradle.gradledemo.ui.beans;

import javax.validation.constraints.NotBlank;

public class UserInfo {

	@NotBlank(message = "{userid.notblank}")
	private String userid;
	
	@NotBlank(message="{pswd.notblank}")
	private String password;
	@NotBlank(message = "{name.notblank}")
	private String name;
	@NotBlank(message = "{email.notblank}")
	private String email;
	/*@NotBlank(message = "{address.notblank}")
	private String address;*/
	@NotBlank(message="{houseNo.notblank}")
	private String houseNO;

	@NotBlank(message="{street.notblank}")
	private String street;
	@NotBlank(message="{area.notblank}")
	private String area;
	private String city;
	private String state;
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}*/

	@Override
	public String toString() {
		return "UserInfo [userId=" + userid + ", name=" + name + ", email=" + email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getHouseNO() {
		return houseNO;
	}

	public void setHouseNO(String houseNO) {
		this.houseNO = houseNO;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
