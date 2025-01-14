package com.comperativa.losandes.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdditionalPaymentFieldDTO {
    private String id;
    private String name;
    private FieldTypeDTO fieldType;
    private String fieldMask;
    private int maximumLength;
    @JsonProperty("isMandatory")
    private boolean mandatory;
    @JsonProperty("isEditable")
    private boolean editable;
}
