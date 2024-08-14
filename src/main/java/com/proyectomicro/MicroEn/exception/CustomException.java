package com.proyectomicro.MicroEn.exception;

import com.proyectomicro.MicroEn.models.Notification;
import com.proyectomicro.MicroEn.models.SeverityEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    final Notification notification;

    public CustomException(Exceptions exceptions){
        super(exceptions.getNotification().getMessage());
        this.httpStatus = exceptions.getHttpStatus();
        this.notification = Notification.builder()
                .code(SeverityEnum.ERROR,
                        "MICROEN_OLIVER",
                        exceptions.getNotification().getCode().split("_")[2]
                ).message(exceptions.getNotification().getMessage())
                .build();


    }
}
