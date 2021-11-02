package com.example.lab2spring.repository;

import com.example.lab2spring.entity.ElectronicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ElectronicRepo extends CrudRepository<ElectronicEntity, Long> {
    ElectronicEntity findByNameModel(String nameModel);
}
