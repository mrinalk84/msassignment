package com.ibm.convertcurrency.service;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.convertcurrency.restclient.CurrencyConvFactorClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConvertCurrencyService {
	
	Logger logger = LoggerFactory.getLogger(ConvertCurrencyService.class);
	
	final  CurrencyConvFactorClient  client;
	
	@Autowired
	public ConvertCurrencyService(CurrencyConvFactorClient  client) {
		this.client= client;
	}
	
	@HystrixCommand(fallbackMethod = "convertCurrencyFallBack")
	public Double convertCurrency(String countryCode, Double amount) {
		logger.info("CountryCode :" +countryCode );
		Double conversionFactor = client.getConversionFactor(countryCode);
		
		Double convertedAmount = amount*conversionFactor;
		return convertedAmount;
		
		
	}
	public Double convertCurrencyFallBack(String countryCode, Double amount)
	{
		return 0.0;
	}
	

}
