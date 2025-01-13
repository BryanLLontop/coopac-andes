package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataPagoServicioDTO {
    private String id;
    private ServiceDataResponseDTO service;
    private List<AdditionalFieldResponseDTO> additionalFields;
    private List<BillResponseDTO> bills;
    private ChargeAmountDTO chargeAmount;
    private FeesDTO fees;
    private TotalAmountDTO totalAmount;
    private ExchangeRateDTO exchangeRate;
    private String creationDate;
    private String serviceCode;
}
