package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.ReservaHabitacion;

public interface ReservaHabitacionRepository extends MongoRepository<ReservaHabitacion, String>{
    
}
