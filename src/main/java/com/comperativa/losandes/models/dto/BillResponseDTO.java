package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BillResponseDTO {
    private String id;
    private String number;
    private List<AmountResponseDTO> amounts;
    private String maturityDate;
    private StatusDTO status;
    private String operationNumber;
    @JsonProperty("isDeferredPayment")
    private boolean isDeferredPayment;
}
