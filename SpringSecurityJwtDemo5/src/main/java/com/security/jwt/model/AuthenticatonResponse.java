package com.security.jwt.model;

public class AuthenticatonResponse {

	private String token;

	public AuthenticatonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticatonResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
