package com.proyectomicro.MicroEn.exception;

import com.proyectomicro.MicroEn.models.Notification;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.SeverityEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

import static com.fasterxml.jackson.databind.util.ClassUtil.getRootCause;
import static org.apache.logging.log4j.message.ParameterizedMessage.ERROR_PREFIX;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@ControllerAdvice
public class GlobalExceptionHandler extends  RuntimeException{
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String RESOLVED_EXCEPTION = "Resolved Exception";
    private static final String RESOLVED_SERVLET_EXCEPTION = "Resolved Servlet Exception";
    private static final String RESOLVED_INTERNAL_EXCEPTION = "Resolved Internal Exception";
    private static final String RESOLVED_AUTH_EXCEPTION = "Resolved Authentication Exception";


    private static final String UNEXPECTED_RESPONSE = "Unexpected response";
    private static final String UNHANDLED_ERROR_MESSAGE = "Unhandled error occurred";

    public static final Notification DEFAULT_NOTIFICATION = Notification.builder()
            .code(SeverityEnum.ERROR, "MICROEN_OLIVER", "XXXX")
            .message(UNEXPECTED_RESPONSE)
            .build();

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseData<Object>> exception(final CustomException exception){
        LOG.warn(RESOLVED_EXCEPTION, getRootCause(exception));
        return ResponseEntity.internalServerError().body(ResponseData.builder()
                .notifications(Collections.singletonList(exception.getNotification()))
                .build()
        );
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity<ResponseData<Object>> handleGlobalException(Exception ex) {

        LOG.error(UNHANDLED_ERROR_MESSAGE, ex);

        return ResponseEntity.status(INTERNAL_SERVER_ERROR.value())
                .body(ResponseData.builder()
                        .notifications(Collections.singletonList(Notification.builder()
                                .code(SeverityEnum.ERROR, "MICROEN_OLIVER", String.valueOf(INTERNAL_SERVER_ERROR.value()))
                                .message(ex.getMessage())
                                .severity(SeverityEnum.ERROR)
                                .build()
                        )).build()
                );
    }

}
