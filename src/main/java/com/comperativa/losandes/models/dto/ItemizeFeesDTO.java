package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemizeFeesDTO {
    private FeeTypeDTO feeType;
    private FeeAmountDTO feeAmount;
}
