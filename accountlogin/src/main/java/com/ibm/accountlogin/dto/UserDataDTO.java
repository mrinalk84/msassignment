package com.ibm.accountlogin.dto;

import java.io.Serializable;

public class UserDataDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9119582059069988092L;
	private String userId;
	private String password;
	private String clientId;
	private String clientSecret;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	
	
	

}
