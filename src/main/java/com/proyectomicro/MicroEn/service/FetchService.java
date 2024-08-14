package com.proyectomicro.MicroEn.service;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.repository.FetchRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchService {
    private static final Logger LOG = LoggerFactory.getLogger(FetchService.class);

    private final FetchRepository repository;

    public ResponseEntity<ResponseData<MobileDevice>> consultaFetch(RestConsumerRequest<MobileDevice> consumerRequest){
        try{
            Long id = Long.parseLong(consumerRequest.getPathParams().get("id"));
            return  null;
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }
}
