package com.proyectomicro.MicroEn.service;

import com.proyectomicro.MicroEn.models.MobileDevice;
import com.proyectomicro.MicroEn.models.ResponseData;

public interface FeignService {
    ResponseData<MobileDevice> consultaFeign(Long id);
}
