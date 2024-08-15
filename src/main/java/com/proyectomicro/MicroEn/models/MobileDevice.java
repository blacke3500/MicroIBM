package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileDevice {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private DataDetails data;
}
