package com.proyectomicro.MicroEn.service;

import com.proyectomicro.MicroEn.models.MobileDevice;

public interface FeignService {
    MobileDevice consultaFeign(Long id);
}
