package com.kai.model;

public class User {
	private long id;
	private String account;
	private String password;
	
	public User() {
		super();
	}

	public User(long id, String account, String password) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
	}

	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
