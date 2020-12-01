package com.ibm.convertcurrency.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("currencyconversionfactor")
public interface CurrencyConvFactorClient {
	
	@GetMapping("/conversionfactor/countryCode/{countryCode}")
	 @ResponseBody public Double getConversionFactor(@PathVariable(value="countryCode") String countryCode);

}
