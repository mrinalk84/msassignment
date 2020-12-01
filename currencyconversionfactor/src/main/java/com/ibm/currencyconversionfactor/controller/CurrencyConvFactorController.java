package com.ibm.currencyconversionfactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconversionfactor.dto.CurrencyConvFactorDTO;
import com.ibm.currencyconversionfactor.dto.ResponseStatus;
import com.ibm.currencyconversionfactor.service.CurrencyConvFactorService;

@RestController
public class CurrencyConvFactorController {
	@Autowired
	private CurrencyConvFactorService service;
	
	@PostMapping("/conversionfactor")
	public ResponseEntity<ResponseStatus> addConversionFactor(@RequestBody CurrencyConvFactorDTO request) {
		ResponseStatus response = new ResponseStatus();
		response.setStatus("Success");
		service.addConversionFactor(request);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/conversionfactor")
	public ResponseEntity<ResponseStatus> updateConversionFactor(@RequestBody CurrencyConvFactorDTO request) {
		ResponseStatus response = new ResponseStatus();
		response.setStatus("Success");
		service.updateConversionFactor(request);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/conversionfactor/countryCode/{countryCode}")
	public Double getConversionFactor(@PathVariable(value="countryCode") String countryCode) {
		
		Double conversionFactor = 0.0;
		conversionFactor = service.getConversionFactor(countryCode);
		return conversionFactor;
	
	}

}
