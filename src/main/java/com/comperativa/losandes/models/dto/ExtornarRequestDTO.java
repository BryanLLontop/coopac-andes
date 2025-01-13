package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExtornarRequestDTO {
    private ServiceRequestDTO service;
    private String agencyOperationCode;
    private String agencyNameOperation;
    private String operationNumber;
    private List<BillExtornarDTO> bills;
    private double amount;
    private String entityOperationNumber;
    private String ers;
}
