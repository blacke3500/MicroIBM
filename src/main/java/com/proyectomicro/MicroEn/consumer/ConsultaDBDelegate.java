package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.Entity.LogCategory;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.operation.ScotiaConsultaDBOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ConsultaDBDelegate {
    private static final Logger LOG = LoggerFactory.getLogger(ConsultaDBDelegate.class);

    @Autowired
    @Qualifier("scotiaConsultaDBOperation")
    private final ScotiaConsultaDBOperation scotiaConsultaDBOperation;


    public ResponseEntity<ResponseData<CategoryConfigRequest>> consultaDBConfiguration(RestConsumerRequest<CategoryConfigRequest> restConsumerRequest){
        LOG.info("Entered /Scotia-Consulta-DB-configuration RequestDelegate");
        return scotiaConsultaDBOperation.handle(restConsumerRequest);
    }

    public ResponseEntity<ResponseData<List<CategoryConfigRequest>>> consultaDBAllConfiguration(){
        LOG.info("Entered /scotia-consulta-db ConfigurationAll RequestDelegate");
        return scotiaConsultaDBOperation.handleAll();
    }

}
