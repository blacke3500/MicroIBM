package com.proyectomicro.MicroEn.operation;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.service.impl.FeignServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignConsultaOperation {

    private final FeignServiceImpl feignService;

    private static final Logger LOG = LoggerFactory.getLogger(FeignConsultaOperation.class);

    public ResponseData<MobileDevice> handleFeign(RestConsumerRequest<ResponseData<MobileDevice>> consumerRequest){
        LOG.info("Entered /scotia-consulta-feign Operation");
        return prepareConsumerResponse(consumerRequest);
    }

    private ResponseData<MobileDevice> prepareConsumerResponse(RestConsumerRequest<ResponseData<MobileDevice>> consumerRequest) {
        LOG.info("Entered /scotia-consulta-fetch In prepareConsumerResponse");
        Long id = Long.valueOf(consumerRequest.getPathParams().get("id"));
        return feignService.consultaFeign(id);
    }
}
