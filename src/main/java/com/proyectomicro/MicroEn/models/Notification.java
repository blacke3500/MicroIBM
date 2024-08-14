package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    private static final String UNDERSCORE = "_";

    @JsonProperty("category")
    private String category;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("description")
    private String description;

    @JsonProperty("action")
    private String action;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("uuid")
    @Builder.Default
    UUID uuid = UUID.randomUUID();

    @JsonProperty("timestamp")
    @Builder.Default
    Instant timestamp = Instant.now();

    @JsonProperty("severity")
    private SeverityEnum severity;

    public static class NotificationBuilder {
        public NotificationBuilder code(SeverityEnum severity, String componentName, String errorNumber) {
            this.code = SeverityEnum.toChar(severity) + UNDERSCORE + componentName + UNDERSCORE + errorNumber;
            return this;
        }
    }
}
