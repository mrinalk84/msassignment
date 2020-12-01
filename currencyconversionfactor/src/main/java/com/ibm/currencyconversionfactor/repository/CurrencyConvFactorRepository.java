package com.ibm.currencyconversionfactor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.currencyconversionfactor.entity.CurrencyConvFactor;

@Repository
public interface CurrencyConvFactorRepository extends JpaRepository<CurrencyConvFactor, Long>{
	Optional<CurrencyConvFactor> findByCountrycode(String countrycode);
}
