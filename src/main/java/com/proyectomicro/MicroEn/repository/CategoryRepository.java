package com.proyectomicro.MicroEn.repository;

import com.proyectomicro.MicroEn.models.Entity.LogCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<LogCategory, UUID> {
}
