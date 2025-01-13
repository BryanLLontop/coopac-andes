package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataUserDTO {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private String value;
}
