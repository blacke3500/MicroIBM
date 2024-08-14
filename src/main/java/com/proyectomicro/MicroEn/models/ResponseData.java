package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseData<T> {
    @JsonProperty("data")
    private T data;

    @JsonProperty("notifications")
    private List<Notification> notifications;
}