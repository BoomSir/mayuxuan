package com.qianfeng.domain;

public class User {
//	username,userpassword,realname,email,telephone
	private String username;
	private String password;
	private String realname;
	private String email;
	private String phone;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return password;
	}
	public void setUserpassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return phone;
	}
	public void setTelephone(String phone) {
		this.phone = phone;
	}
	public User() {
		super();
	}
}
