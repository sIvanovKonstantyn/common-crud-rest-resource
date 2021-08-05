package com.example.demo.rest;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.ProductModel;
import com.example.demo.service.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductResource extends CrudResource<ProductDto, ProductModel> {

    @Autowired
    public ProductResource(ModelMapper mapper, CrudService<ProductModel> crudService) {
        super(mapper, crudService, ProductModel.class, ProductDto.class);
    }
}
