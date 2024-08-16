package com.proyectomicro.MicroEn.service.impl;

import com.proyectomicro.MicroEn.dataprovider.feign.MicroEnFeign;
import com.proyectomicro.MicroEn.exception.CustomException;
import com.proyectomicro.MicroEn.exception.Exceptions;
import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.Notification;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeignServiceImpl implements FeignService {
    private static final Logger LOG = LoggerFactory.getLogger(FeignServiceImpl.class);

    private final MicroEnFeign microEnFeign;
    @Override
    public ResponseData<MobileDevice> consultaFeign(Long id) {
        LOG.info("Entered in Scotia Feign Service...");
        try {
            ResponseEntity<List<MobileDevice>> responseEntity = microEnFeign.consultaFeign(id);
            List<MobileDevice> devices = responseEntity.getBody();
            MobileDevice mobileDevice = devices.get(0);

            ResponseData<MobileDevice> responseData = ResponseData.<MobileDevice>builder()
                    .data(mobileDevice)
                    .notifications(Collections.emptyList())
                    .build();

            return responseData;

        } catch (Exception e) {
            LOG.error("Error occurred while processing the feign service", e);
            throw  new CustomException(Exceptions.NULL_RESPONSE);
        }
    }

}

