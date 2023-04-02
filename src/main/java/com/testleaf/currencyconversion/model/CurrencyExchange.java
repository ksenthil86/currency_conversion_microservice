package com.testleaf.currencyconversion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CurrencyExchange {

    private Integer id;
    @JsonProperty("from")
    private String currency_from;
    @JsonProperty("to")
    private String currency_to;
    private Double conversion_multiple;


}
