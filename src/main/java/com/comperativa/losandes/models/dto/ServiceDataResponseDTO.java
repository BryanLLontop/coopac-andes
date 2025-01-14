package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDataResponseDTO {
    private String id;
    private String name;
    private ServiceTypeDTO serviceType;
}
