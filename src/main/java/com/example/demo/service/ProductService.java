package com.example.demo.service;

import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService implements CrudService<ProductModel> {

    @Autowired
    private ProductRepository repository;

    @Override
    public CrudRepository<ProductModel, Long> getRepository() {
        return repository;
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}
