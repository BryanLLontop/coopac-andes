package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleReciboResponseDTO {
    private int statusCode;
    private String message;
    private List<ReciboDataDTO> data;
    private String messages;
    private String code;
}
