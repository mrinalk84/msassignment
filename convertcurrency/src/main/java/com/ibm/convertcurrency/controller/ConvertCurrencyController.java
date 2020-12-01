package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.dto.ConvertCurrencyDTO;
import com.ibm.convertcurrency.service.ConvertCurrencyService;


@RestController
public class ConvertCurrencyController {
	
	@Autowired
	ConvertCurrencyService service;
	
	
	
	@PostMapping("/convertcurrency")
	public Double convertCurrency(@RequestBody ConvertCurrencyDTO request) {
		
		Double convertedAmount =service.convertCurrency(request.getCountrycode(), request.getAmount());
		return convertedAmount;
		
	}

}
