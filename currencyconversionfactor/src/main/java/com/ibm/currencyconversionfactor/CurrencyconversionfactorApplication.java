package com.ibm.currencyconversionfactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyconversionfactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyconversionfactorApplication.class, args);
	}

}
