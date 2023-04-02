package com.testleaf.currencyconversion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CurrencyConversion {

    private Integer quantity;
    private Double totalCalculateAmount;
    private CurrencyExchange currencyExchange;
}
