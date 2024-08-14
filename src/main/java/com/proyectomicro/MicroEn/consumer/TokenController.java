package com.proyectomicro.MicroEn.consumer;

import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.Entity.LogCategory;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/MicroEn")
@RequiredArgsConstructor
public class TokenController {
    private final ConsultaDBDelegate delegateConsulta;

    @PostMapping("/consultaDB")
    public ResponseEntity<ResponseData<CategoryConfigRequest>> consultaDB(@RequestParam(name = "category_id", required = true) UUID category_id, @RequestBody CategoryConfigRequest categoryConfigRequest){
        String cat_id = String.valueOf(category_id);
        RestConsumerRequest<CategoryConfigRequest> restRequest = scotiaConsultaDBPrepareRequest(cat_id, categoryConfigRequest);
        return delegateConsulta.consultaDBConfiguration(restRequest);
    }

    @GetMapping("/consultaDBAll")
    public ResponseEntity<ResponseData<List<CategoryConfigRequest>>> consultaDBAll(@RequestBody CategoryConfigRequest categoryConfigRequest){
        RestConsumerRequest<CategoryConfigRequest> restRequest = scotiaConsultaDBAllPrepareRequest(categoryConfigRequest);
        return delegateConsulta.consultaDBAllConfiguration();
    }

    private RestConsumerRequest<CategoryConfigRequest> scotiaConsultaDBPrepareRequest(@RequestParam(value = "category_id", required = true) String category_id, @RequestBody CategoryConfigRequest categoryConfigRequest) {
        Map<String, String> pathParams =  new HashMap<>();
        pathParams.put("category_id", category_id);
        RestConsumerRequest<CategoryConfigRequest> restRequest = RestConsumerRequest.<CategoryConfigRequest>builder()
                .pathParams(pathParams)
                .request(categoryConfigRequest)
                .build();
        return restRequest;
    }

    private RestConsumerRequest<CategoryConfigRequest> scotiaConsultaDBAllPrepareRequest(@RequestBody CategoryConfigRequest categoryConfigRequest) {
        RestConsumerRequest<CategoryConfigRequest> restRequest = RestConsumerRequest.<CategoryConfigRequest>builder()
                .request(categoryConfigRequest)
                .build();
        return restRequest;
    }

}
