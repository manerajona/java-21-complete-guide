package com.manerajona.jvm.escapingreferences.example2;

import java.util.HashMap;
import java.util.Map;

public class Price {

	private final Map<String,Double> rates;
	private final Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = new HashMap<>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}
		
	public Double convert(String toCurrency) {
		
		if (toCurrency.equals("USD")) {
			return value;
		}
		else {
			Double conversion = rates.get("USD") * rates.get(toCurrency);
			return conversion * value;
			
		}
	}
	
	public String toString() {
		return this.value.toString();
	}
	
	public Map<String,Double> getRates() {
		return Map.copyOf(rates);
	}
		
}
