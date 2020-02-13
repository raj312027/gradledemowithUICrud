package com.demogradle.gradledemo.ui.beans;

import javax.validation.constraints.NotBlank;

public class UserInfo {

	@NotBlank(message = "{userid.notblank}")
	private String userid;
	@NotBlank(message = "{name.notblank}")
	private String name;
	@NotBlank(message = "{email.notblank}")
	private String email;
	@NotBlank(message = "{address.notblank}")
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userid + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
