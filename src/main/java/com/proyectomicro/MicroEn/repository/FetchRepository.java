package com.proyectomicro.MicroEn.repository;

import com.proyectomicro.MicroEn.models.MobileDevice;
import org.springframework.data.repository.CrudRepository;

public interface FetchRepository extends CrudRepository<MobileDevice, Long> {
}
