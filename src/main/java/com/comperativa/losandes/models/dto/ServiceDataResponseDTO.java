package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDataResponseDTO {
    private String id;
    private String business;
    private String name;
    private String description;
    private ServiceTypeDTO serviceType;
}
