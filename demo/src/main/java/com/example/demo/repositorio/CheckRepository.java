package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Check;

public interface CheckRepository extends MongoRepository<Check, String> {
    
}
