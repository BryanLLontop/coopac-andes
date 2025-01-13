package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagoServicioRequestDTO {
    private int statusCode;
    private String message;
    private DataPagoServicioDTO data;
    private String messages;
    private String code;
}
