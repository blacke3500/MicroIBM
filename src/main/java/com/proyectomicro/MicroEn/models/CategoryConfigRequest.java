package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryConfigRequest {
    @JsonProperty("category_id")
    private UUID categoryId;

    @JsonProperty("category_description")
    private String categoryDescription;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("category_parent")
    private UUID categoryParent;

    @JsonProperty("log_code")
    private String logCode;


}
