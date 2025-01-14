package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SimulacionPagoRequestDTO {
    private ServiceRequestDTO service;
    private List<BillDTO> bills;
    private List<AdditionalFieldDTO> additionalFields;
    private String serviceProvider;
}
