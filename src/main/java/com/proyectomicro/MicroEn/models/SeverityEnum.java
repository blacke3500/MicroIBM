package com.proyectomicro.MicroEn.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SeverityEnum {
    INFO("INFO"),
    WARNING("WARNING"),
    ERROR("ERROR"),
    UNSPECIFIED("UNSPECIFIED");
    private String value;

    SeverityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static SeverityEnum fromValue(String value) {
        for (SeverityEnum b : SeverityEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static char toChar(SeverityEnum severity) {
        switch (severity) {
            case ERROR:
                return 'E';
            case WARNING:
                return 'W';
            case INFO:
                return 'I';
            default:
                return 'U';
        }
    }
}
