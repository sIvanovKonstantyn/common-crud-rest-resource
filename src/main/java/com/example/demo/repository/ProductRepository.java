package com.example.demo.repository;

import com.example.demo.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
