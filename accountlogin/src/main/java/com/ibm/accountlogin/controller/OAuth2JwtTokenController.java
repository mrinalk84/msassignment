package com.ibm.accountlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.accountlogin.dto.UserDataDTO;
import com.ibm.accountlogin.service.OAuth2JwtTokenService;

@RestController
@RequestMapping("/auth")
public class OAuth2JwtTokenController {
	
	@Autowired
	OAuth2JwtTokenService oAuth2JwtTokenService;
	
	@PostMapping("/accesstoken")
	public String getOAuth2AccessToken(@RequestBody UserDataDTO user) {
		return oAuth2JwtTokenService.getAccessToken(user);
		
	}
	

}
