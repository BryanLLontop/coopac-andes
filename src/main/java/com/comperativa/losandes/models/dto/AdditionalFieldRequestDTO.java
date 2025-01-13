package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdditionalFieldRequestDTO {
    private AdditionalPaymentFieldRequestDTO additionalPaymentField;
    private String value;
}
