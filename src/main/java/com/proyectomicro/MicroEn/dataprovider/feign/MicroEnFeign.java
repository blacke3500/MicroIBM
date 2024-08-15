package com.proyectomicro.MicroEn.dataprovider.feign;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://api.restful-api.dev", name = "MicroEnFeign")
public interface MicroEnFeign {
    @GetMapping("/objects?id=1")
    ResponseEntity<List<MobileDevice>> consultaFeign(@RequestParam(name = "id", required = true) Long id);
}
