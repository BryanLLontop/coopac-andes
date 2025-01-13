package com.comperativa.losandes.models.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
public class SimulacionPagoRequestDTO {
    private ServiceRequestDTO service;
    private List<BillRequestDTO> bills;
    private List<AdditionalFieldDTO> additionalFields;
    private String serviceProvider;
    private String ers;
}
