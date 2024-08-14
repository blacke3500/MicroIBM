package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RestConsumerRequest<I> {
    private static final long serialVersionUID = -7480432481957171502L;
    private I request;

    @JsonFilter("ignoreHeaders")
    private Map<String, Object> headerParams;

    private Map<String, Object> queryParams;

    private Map<String, String> pathParams;

    private Map<String, Object> formData;
}
