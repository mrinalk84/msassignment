package com.ibm.accountlogin.service;

import com.ibm.accountlogin.dto.UserDataDTO;

public interface OAuth2JwtTokenService {
	
	public String getAccessToken(UserDataDTO userDto);

}
