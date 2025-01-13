package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataExtornarResponseDTO {
    private String id;
    private ServiceTypeDTO service;
    private List<BillExtornarResponseDTO> bills;
    private String billholder;
    private String creationDate;
    private String serviceCode;
}
