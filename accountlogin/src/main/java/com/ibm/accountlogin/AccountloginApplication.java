package com.ibm.accountlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AccountloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountloginApplication.class, args);
	}
	
	@Bean 
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
