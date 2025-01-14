package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AmountDTO {
    private AmountTypeDTO amountType;
    private AmountValueDTO amountValue;
}
