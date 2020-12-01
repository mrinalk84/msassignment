package com.ibm.currencyconversionfactor.dto;

public class CurrencyConvFactorDTO {
	
	private String countrycode;
	private Double conversionfactor;
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public Double getConversionfactor() {
		return conversionfactor;
	}
	public void setConversionfactor(Double conversionfactor) {
		this.conversionfactor = conversionfactor;
	}
	
	

}
