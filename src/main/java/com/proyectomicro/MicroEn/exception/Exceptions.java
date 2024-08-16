package com.proyectomicro.MicroEn.exception;

import com.proyectomicro.MicroEn.models.Notification;
import com.proyectomicro.MicroEn.models.SeverityEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Exceptions {
    DATABASE_ERROR(Notification.builder()
            .code(SeverityEnum.ERROR, "MICROEN_OLIVER", "XXXX")
            .message("Database Error")
            .uuid(UUID.randomUUID())
            .severity(SeverityEnum.ERROR)
            .timestamp(Instant.now())
            .build(), HttpStatus.INTERNAL_SERVER_ERROR),

    CATEGORY_NOT_FOUND(Notification.builder()
            .code(SeverityEnum.WARNING, "MICROEN_OLIVER", "XXXX")
            .message("There is no category with the given parameters.")
            .uuid(UUID.randomUUID())
            .severity(SeverityEnum.WARNING)
            .timestamp(Instant.now())
            .build(), HttpStatus.NOT_FOUND),

    INVALID_UUID(Notification.builder()
            .code(SeverityEnum.ERROR, "MICROEN_OLIVER", "XXXX")
            .message("wrong UUID.")
            .uuid(UUID.randomUUID())
            .severity(SeverityEnum.ERROR)
            .timestamp(Instant.now())
            .build(), HttpStatus.INTERNAL_SERVER_ERROR),

    NO_DATA_IN_DB(Notification.builder()
            .code(SeverityEnum.WARNING, "MICROEN_OLIVER", "XXXX")
            .message("There are no registers in the DB .")
            .uuid(UUID.randomUUID())
            .severity(SeverityEnum.WARNING)
            .timestamp(Instant.now())
            .build(), HttpStatus.INTERNAL_SERVER_ERROR),
    NULL_RESPONSE(Notification.builder()
            .code(SeverityEnum.ERROR, "MICROEN_OLIVER", "XXXX")
            .message("Received null or empty response from Feign client")
            .uuid(UUID.randomUUID())
            .severity(SeverityEnum.ERROR)
            .timestamp(Instant.now())
            .build(), INTERNAL_SERVER_ERROR);

    private Notification notification;
    private  HttpStatus httpStatus;


}
