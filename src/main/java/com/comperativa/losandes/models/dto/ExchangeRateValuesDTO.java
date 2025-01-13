package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExchangeRateValuesDTO {
    private ExchangeFactorDTO factor;
    private AmountRateDTO amountRate;
    private String baseCurrency;
}
