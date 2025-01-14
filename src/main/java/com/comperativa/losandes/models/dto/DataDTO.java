package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataDTO {
    private String id;
    private ServiceDataResponseDTO service;
    private List<BillDTO> bills;
    private List<AdditionalFieldRequestDTO> additionalFields;
    private ChargeAmountDTO chargeAmount;
    private FeesDTO fees;
    private TotalAmountDTO totalAmount;
    private ExchangeRateDTO exchangeRate;
    private String simulationDate;
}
