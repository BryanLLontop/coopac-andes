package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DetalleServiceDataDTO {
    private String id;
    private String business;
    private String name;
    private String description;
    private ServiceTypeDTO serviceType;
    private String serviceProvider;
    private List<IndicatorsDTO> indicators;
    @JsonProperty("additional-payment-fields")
    private List<AdditionalPaymentFieldDTO> additionalPaymentFields;

}
