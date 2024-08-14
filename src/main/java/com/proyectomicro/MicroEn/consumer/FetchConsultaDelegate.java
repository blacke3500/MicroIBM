package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.operation.FetchConsultaOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FetchConsultaDelegate {
    private static final Logger LOG = LoggerFactory.getLogger(FetchConsultaDelegate.class);

    @Autowired
    @Qualifier("fetchConsultaOperation")
    private final FetchConsultaOperation fetchConsultaOperation;

    public ResponseEntity<ResponseData<MobileDevice>> consultaFetchConfiguration(RestConsumerRequest<MobileDevice> restConsumerRequest){
        LOG.info("Entered /Scotia-Consulta-Fetch-configuration RequestDelegate");
        return fetchConsultaOperation.handleFetch(restConsumerRequest);
    }
}
