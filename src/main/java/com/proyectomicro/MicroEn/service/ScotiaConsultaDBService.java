package com.proyectomicro.MicroEn.service;

import com.proyectomicro.MicroEn.exception.CustomException;
import com.proyectomicro.MicroEn.exception.Exceptions;
import com.proyectomicro.MicroEn.models.CategoryConfigRequest;
import com.proyectomicro.MicroEn.models.Entity.LogCategory;
import com.proyectomicro.MicroEn.models.ResponseData;
import com.proyectomicro.MicroEn.models.RestConsumerRequest;
import com.proyectomicro.MicroEn.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScotiaConsultaDBService {
    private static final Logger LOG = LoggerFactory.getLogger(ScotiaConsultaDBService.class);

    private final CategoryRepository repository;

    public ResponseEntity<ResponseData<CategoryConfigRequest>> consulta(RestConsumerRequest<CategoryConfigRequest> consumerRequest) {
        LOG.info("Entered in ScotiaConsultaDBService...");
        try {
            UUID categoryId = UUID.fromString(consumerRequest.getPathParams().get("category_id"));

            LOG.info("Query performed with :\n category_id : " + categoryId + " \n");
            Optional<LogCategory> categoryOptional =  repository.findById(categoryId); //quitar generalizar en un find by categoryid
            if (categoryOptional.isPresent()) {
                LogCategory category = categoryOptional.get(); //ispresent.get()
                CategoryConfigRequest categoryConfigRequest = toCategoryConfigRequest(category);
                return new ResponseEntity<>(ResponseData.<CategoryConfigRequest>builder()
                        .data(categoryConfigRequest)
                        .notifications(Collections.emptyList())
                        .build(), HttpStatus.OK);
            }

            LOG.error("Category not found launching CustomException");
            throw  new CustomException(Exceptions.CATEGORY_NOT_FOUND);

        } catch (Exception e) {
            LOG.error("Error occurred while processing the db", e);
            throw  new CustomException(Exceptions.DATABASE_ERROR);
        }

    }

        public ResponseEntity<ResponseData<List<CategoryConfigRequest>>> consultaAll(){
            LOG.info("Fetching all categories from database...");
            try{
                Iterable<LogCategory> categories = repository.findAll();
                List<CategoryConfigRequest> categoryConfigRequests = new ArrayList<>();

                for (LogCategory category : categories) {
                    CategoryConfigRequest categoryConfigRequest = toCategoryConfigRequest(category);
                    categoryConfigRequests.add(categoryConfigRequest);
                }

                if (categoryConfigRequests.isEmpty()) {
                    LOG.error("No data found, launching CustomException");
                    throw new CustomException(Exceptions.NO_DATA_IN_DB);
                }

                return new ResponseEntity<>(ResponseData.<List<CategoryConfigRequest>>builder()
                        .data(categoryConfigRequests)
                        .notifications(Collections.emptyList())
                        .build(),HttpStatus.OK);


            } catch (Exception e) {
                LOG.error("Error occurred while processing the db", e);
                throw new CustomException(Exceptions.DATABASE_ERROR);
            }
        }


    private CategoryConfigRequest toCategoryConfigRequest(LogCategory logCategory) {
        return CategoryConfigRequest.builder()
                .categoryId(logCategory.getCategoryId())
                .categoryDescription(logCategory.getCategoryDescription())
                .categoryName(logCategory.getCategoryName())
                .categoryParent(logCategory.getCategoryParent())
                .logCode(logCategory.getLogCode())
                .build();
    }
}
