package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtornarResponseDTO {
    private String statusCode;
    private String message;
    private DataExtornarResponseDTO data;
    private String messages;
    private String code;
}
