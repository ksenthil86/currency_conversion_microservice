package com.testleaf.currencyconversion.service;

import com.testleaf.currencyconversion.model.CurrencyConversion;
import com.testleaf.currencyconversion.model.CurrencyExchange;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConversionService {

    RestTemplate restTemplate = new RestTemplate();

    CurrencyConversion currencyConversion = new CurrencyConversion();

    public CurrencyConversion getConversionOutput(String fromCurrency,String toCurrency,Integer quantity){

        Double multiplier;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");

        ResponseEntity<CurrencyExchange> exchange = restTemplate.exchange("http://localhost:8080/currency-exchange/from/"+fromCurrency+"/to/"+toCurrency+"",HttpMethod.GET,
                new HttpEntity<>(httpHeaders), CurrencyExchange.class);
        Double convertedValue = exchange.getBody().getConversion_multiple()*quantity;
        return currencyConversion.toBuilder().quantity(quantity)
                .totalCalculateAmount(convertedValue)
                .currencyExchange(exchange.getBody())
                .build();

    }
}
