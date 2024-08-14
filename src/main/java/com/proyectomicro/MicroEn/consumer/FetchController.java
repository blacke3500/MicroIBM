package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
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
public class FetchController {
    private final FetchConsultaDelegate fetchConsultaDelegate;

    @GetMapping("/consultaFetch")
    public ResponseEntity<ResponseData<MobileDevice>> consultaFetch(@RequestParam(name = "id", required = true) Long id, @RequestBody MobileDevice mobileDevice){
        String req_id = String.valueOf(id);
        RestConsumerRequest<MobileDevice> restRequest = scotiaConsultaFetchPrepareRequest(req_id, mobileDevice);
        return fetchConsultaDelegate.consultaFetchConfiguration(restRequest);
    }

    private RestConsumerRequest<MobileDevice> scotiaConsultaFetchPrepareRequest(@RequestParam(value = "id", required = true) String id, @RequestBody MobileDevice mobileDevice) {
        Map<String, String> pathParams =  new HashMap<>();
        pathParams.put("id", id);
        RestConsumerRequest<MobileDevice> restRequest = RestConsumerRequest.<MobileDevice>builder()
                .pathParams(pathParams)
                .request(mobileDevice)
                .build();
        return restRequest;
    }
}
