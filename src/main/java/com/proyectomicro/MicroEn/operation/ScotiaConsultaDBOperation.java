package com.proyectomicro.MicroEn.operation;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.Entity.LogCategory;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.service.ScotiaConsultaDBService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScotiaConsultaDBOperation {
    private final ScotiaConsultaDBService scotiaConsultaDBService;

    private static final Logger LOG = LoggerFactory.getLogger(ScotiaConsultaDBOperation.class);
    public ResponseEntity<ResponseData<CategoryConfigRequest>> handle(RestConsumerRequest<CategoryConfigRequest> consumerRequest){
        LOG.info("Entered /scotia-consulta-db Operation");
        return prepareConsumerResponse(consumerRequest);
    }

    private ResponseEntity<ResponseData<CategoryConfigRequest>> prepareConsumerResponse(RestConsumerRequest<CategoryConfigRequest> consumerRequest) {
        LOG.info("Entered /scotia-consulta-db In prepareConsumerResponse");
        return scotiaConsultaDBService.consulta(consumerRequest);
    }

    public ResponseEntity<ResponseData<List<CategoryConfigRequest>>> handleAll(){
        LOG.info("Entered /scotia-consulta-db Operation All");
        return prepareConsumerResponseAll();
    }

    private ResponseEntity<ResponseData<List<CategoryConfigRequest>>> prepareConsumerResponseAll(){
        LOG.info("Entered /scotia-consulta-db In prepareConsumerResponse");
        return scotiaConsultaDBService.consultaAll();
    }

}
