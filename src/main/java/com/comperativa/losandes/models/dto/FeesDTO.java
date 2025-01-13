package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FeesDTO {
    private TotalFeesDTO totalFees;
    private List<ItemizeFeesDTO> itemizeFees;
}
