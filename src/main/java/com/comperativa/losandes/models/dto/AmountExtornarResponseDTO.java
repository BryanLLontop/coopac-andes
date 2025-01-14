package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AmountExtornarResponseDTO {
    private AmountValueDTO amountValue;
    private String id;
    private String number;
    private StatusDTO status;
    private String operationNumber;
    private String isDeferredPayment;
}
