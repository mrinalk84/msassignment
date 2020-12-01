package com.ibm.currencyconversionfactor.mapper;

import com.ibm.currencyconversionfactor.dto.CurrencyConvFactorDTO;
import com.ibm.currencyconversionfactor.entity.CurrencyConvFactor;

public class CurrencyConvFactorMapper {
	
	public CurrencyConvFactor convertToCurrencyConvFactor(CurrencyConvFactorDTO dto) {
		CurrencyConvFactor entity = new CurrencyConvFactor();
		entity.setCountrycode(dto.getCountrycode());
		entity.setConversionfactor(dto.getConversionfactor());
		
		return entity;	
		
	}
	

}
