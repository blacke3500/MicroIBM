package com.proyectomicro.MicroEn.service.impl;

import com.proyectomicro.MicroEn.dataprovider.feign.MicroEnFeign;
import com.proyectomicro.MicroEn.exception.CustomException;
import com.proyectomicro.MicroEn.exception.Exceptions;
import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignServiceImpl implements FeignService {
    private static final Logger LOG = LoggerFactory.getLogger(FeignServiceImpl.class);

    private final MicroEnFeign microEnFeign;
    @Override
    public MobileDevice consultaFeign(Long id) {
        LOG.info("Entered in Scotia Feign Service...");
        try {
            return microEnFeign.consultaFeign(id).getBody().getData();

        } catch (Exception e) {
            LOG.error("Error occurred while processing the db", e);
            throw  new CustomException(Exceptions.DATABASE_ERROR);
        }
    }

}

