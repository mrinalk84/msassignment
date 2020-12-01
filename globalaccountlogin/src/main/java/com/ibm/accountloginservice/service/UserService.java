package com.ibm.accountloginservice.service;

import org.springframework.security.core.Authentication;

import com.ibm.accountloginservice.dto.UserDataDTO;

public interface UserService {
	
	public Authentication signin(String username, String password);
	public String signup(UserDataDTO user);
	public void delete(String username);	
	public UserDataDTO search(String username);

}
