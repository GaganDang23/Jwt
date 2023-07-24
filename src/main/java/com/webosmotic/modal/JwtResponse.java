package com.webosmotic.modal;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3781476078789339943L;
	
	public  final String jwttoken;
	
	
	public JwtResponse(String jwttoken) {
		this.jwttoken=jwttoken;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + "]";
	}
	
	
	

}
