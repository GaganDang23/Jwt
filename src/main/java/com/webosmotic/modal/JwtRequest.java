package com.webosmotic.modal;

import java.io.Serializable;

public class JwtRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5998662168825755161L;
	
	private String username;
	
	private String password;

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
