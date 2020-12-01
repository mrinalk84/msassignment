package com.ibm.currencyconversionfactor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCYCONVFACTOR")
public class CurrencyConvFactor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "COUNTRYCODE")
	private String countrycode;
	@Column(name = "CONVERSIONFACTOR")
	private Double conversionfactor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
