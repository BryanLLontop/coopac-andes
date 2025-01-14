package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDataDTO {
    private String id;
    private String business;
    private String name;
    private String description;
    private ServiceTypeDTO serviceType;
}
