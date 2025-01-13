package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IndicatorsDTO {
    private String id;
    private String name;
    @JsonProperty("isActive")
    private boolean active;
}
