package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/MicroEn")
@RequiredArgsConstructor
public class FeignController {
    private final FeignConsultaDelegate feignConsultaDelegate;

    @GetMapping("/consultaFeign")
    public MobileDevice consultaFeign(@RequestParam(name = "id", required = true) Long id){
        String req_id = String.valueOf(id);
        RestConsumerRequest<MobileDevice> restRequest = scotiaConsultaFeignPrepareRequest(req_id);
        return feignConsultaDelegate.consultaFeignConfiguration(restRequest);
    }

    private RestConsumerRequest<MobileDevice> scotiaConsultaFeignPrepareRequest(@RequestParam(value = "id", required = true) String id) {
        Map<String, String> pathParams =  new HashMap<>();
        pathParams.put("id", id);
        RestConsumerRequest<MobileDevice> restRequest = RestConsumerRequest.<MobileDevice>builder()
                .pathParams(pathParams)
                .build();
        return restRequest;
    }
}
