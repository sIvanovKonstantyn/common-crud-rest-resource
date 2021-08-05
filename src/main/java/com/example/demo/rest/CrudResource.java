package com.example.demo.rest;

import com.example.demo.service.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudResource<DTO, MODEL> {

    private final ModelMapper mapper;
    private final CrudService<MODEL> crudService;
    private final Class<MODEL> modelClass;
    private final Class<DTO> dtoClass;

    public CrudResource(
            ModelMapper mapper,
            CrudService<MODEL> crudService,
            Class<MODEL> modelClass,
            Class<DTO> dtoClass
    ) {
        this.mapper = mapper;
        this.crudService = crudService;
        this.modelClass = modelClass;
        this.dtoClass = dtoClass;
    }

    @PostMapping
    public DTO save(@RequestBody DTO dto) {
        return mapper.map(
                crudService.save(mapper.map(dto, modelClass)),
                dtoClass
        );
    }

    @PutMapping
    public DTO update(@RequestBody DTO dto) {
        return mapper.map(
                crudService.update(mapper.map(dto, modelClass)),
                dtoClass
        );
    }

    @GetMapping
    public List<DTO> findAll() {
        return crudService.findAll().stream()
                .map(model -> mapper.map(model, dtoClass))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DTO findOne(@PathVariable Long id) {
        return mapper.map(crudService.findOne(id), dtoClass);
    }
}