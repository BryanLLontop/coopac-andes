package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BillResponseSimulacionDTO {
    private String id;
    private String number;
    private List<AmountResponseDTO> amounts;
    private String maturityDate;
    private String prueba;
}
