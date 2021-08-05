package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface CrudService<MODEL> extends LoggedService {

    default MODEL save(final MODEL model) {
        this.getLogger().info("save called for {}", model);
        return this.getRepository().save(model);
    }

    default MODEL update(final MODEL model) {
        this.getLogger().info("update called for {}", model);
        return this.getRepository().save(model);
    }

    default MODEL findOne(Long id) {
        this.getLogger().info("update called for id {}", id);
        return this.getRepository().findById(id)
                .orElseThrow();
    }

    default List<MODEL> findAll() {
        this.getLogger().info("findAll called");
        return StreamSupport.stream(this.getRepository().findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    CrudRepository<MODEL, Long> getRepository();
}
