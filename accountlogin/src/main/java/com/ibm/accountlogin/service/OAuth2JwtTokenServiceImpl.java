package com.ibm.accountlogin.service;

import java.util.Arrays;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.accountlogin.dto.UserDataDTO;

@Service
public class OAuth2JwtTokenServiceImpl implements OAuth2JwtTokenService {

	private static Logger logger = LoggerFactory.getLogger(OAuth2JwtTokenServiceImpl.class);
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${oauth2.server.url}")
	String oauthServerUrl;
	
	@Override
	public String getAccessToken(UserDataDTO userDto) {
		ResponseEntity<String> response = null;
		String credentials = userDto.getClientId() + ":" + userDto.getClientSecret();
		String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		String access_token_url = oauthServerUrl+"/token";
		access_token_url += "?username=" + userDto.getUserId();
		access_token_url += "&password="  + userDto.getPassword();
		access_token_url += "&grant_type=password";
		

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		logger.info("Access Token Response======" + response.getBody());

		// Get the Access Token From the recieved JSON response
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node =null;
		try {
			
			node = mapper.readTree(response.getBody());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String token = node.path("access_token").asText();

		
		return token;
	}
	
	
}
