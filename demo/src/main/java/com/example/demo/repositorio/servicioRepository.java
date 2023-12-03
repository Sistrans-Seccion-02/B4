package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.servicio;

public interface servicioRepository extends MongoRepository <servicio, String> {
    
}
