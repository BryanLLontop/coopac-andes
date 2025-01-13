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
