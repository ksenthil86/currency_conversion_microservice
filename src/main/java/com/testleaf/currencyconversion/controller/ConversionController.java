package com.testleaf.currencyconversion.controller;

import com.testleaf.currencyconversion.model.CurrencyConversion;
import com.testleaf.currencyconversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @GetMapping(value="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyConversion> returnCurrencyConvertedValue(@PathVariable String from,@PathVariable String to,@PathVariable Integer quantity){

        CurrencyConversion currencyConversion = conversionService.getConversionOutput(from,to,quantity);
        return new ResponseEntity<>(currencyConversion, HttpStatus.OK);

    }
}
