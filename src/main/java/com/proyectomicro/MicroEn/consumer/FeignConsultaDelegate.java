package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.operation.FeignConsultaOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignConsultaDelegate {
    private static final Logger LOG = LoggerFactory.getLogger(FeignConsultaDelegate.class);

    @Autowired
    @Qualifier("feignConsultaOperation")
    private final FeignConsultaOperation feignConsultaOperation;

    public MobileDevice consultaFeignConfiguration(RestConsumerRequest<MobileDevice> restConsumerRequest){
        LOG.info("Entered /Scotia-Consulta-Fetch-configuration RequestDelegate");
        return feignConsultaOperation.handleFeign(restConsumerRequest);
    }
}
