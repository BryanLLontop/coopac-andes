package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDataResponseDTO {
    private String id;
    private String business;
    private String name;
    private String description;
    private ServiceTypeDTO serviceType;
    private String serviceProvider;
    private List<IndicatorsDTO> indicators;
    @JsonProperty("additional-payment-fields")
    private List<AdditionalPaymentFieldRequestDTO> additionalPaymentFields;
}
