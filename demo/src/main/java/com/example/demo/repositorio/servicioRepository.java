package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Servicio;

public interface ServicioRepository extends MongoRepository <Servicio, String> {
    
}
