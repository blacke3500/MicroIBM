package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDetails {
    @JsonProperty("color")
    private String color;

    @JsonProperty("capacity")
    private String capacity;
}
