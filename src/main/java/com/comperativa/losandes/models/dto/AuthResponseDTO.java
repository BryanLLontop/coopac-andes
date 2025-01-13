package com.comperativa.losandes.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponseDTO {
    private int statusCode;
    private String message;
    private String token;
    private String tokenType;
    private int expiresIn;
    private List<DataUserDTO> dataUser;
}
