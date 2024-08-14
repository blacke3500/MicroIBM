package com.proyectomicro.MicroEn.operation;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.service.FetchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FetchConsultaOperation {

    private final FetchService fetchService;

    private static final Logger LOG = LoggerFactory.getLogger(FetchConsultaOperation.class);

    public ResponseEntity<ResponseData<MobileDevice>> handleFetch(RestConsumerRequest<MobileDevice> consumerRequest){
        LOG.info("Entered /scotia-consulta-fetch Operation");
        return prepareConsumerResponse(consumerRequest);
    }

    private ResponseEntity<ResponseData<MobileDevice>> prepareConsumerResponse(RestConsumerRequest<MobileDevice> consumerRequest) {
        LOG.info("Entered /scotia-consulta-fetch In prepareConsumerResponse");
        return fetchService.consultaFetch(consumerRequest);
    }
}
