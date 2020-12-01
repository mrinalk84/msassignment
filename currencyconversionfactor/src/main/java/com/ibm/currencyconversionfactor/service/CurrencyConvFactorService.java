package com.ibm.currencyconversionfactor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.currencyconversionfactor.dto.CurrencyConvFactorDTO;
import com.ibm.currencyconversionfactor.entity.CurrencyConvFactor;
import com.ibm.currencyconversionfactor.mapper.CurrencyConvFactorMapper;
import com.ibm.currencyconversionfactor.repository.CurrencyConvFactorRepository;

@Service
public class CurrencyConvFactorService {
	
	@Autowired
	private CurrencyConvFactorRepository repository;
	
	public void addConversionFactor(CurrencyConvFactorDTO req) {
		CurrencyConvFactorMapper mapper = new CurrencyConvFactorMapper();
		CurrencyConvFactor entity = mapper.convertToCurrencyConvFactor(req);
		repository.save(entity);	
	}
	
	public void updateConversionFactor(CurrencyConvFactorDTO req) {
		CurrencyConvFactorMapper mapper = new CurrencyConvFactorMapper();
		CurrencyConvFactor entity = mapper.convertToCurrencyConvFactor(req);
		repository.save(entity);
	}

	public Double getConversionFactor(String countryCode) {
		
		Double conversionFactor = 0.0;
		Optional<CurrencyConvFactor> entity = repository.findByCountrycode(countryCode);
		if(entity.isPresent()) {
			conversionFactor = entity.get().getConversionfactor();
		}
		return conversionFactor;
	
	}

}
