package com.example.demo.repositorio;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.modelo.consumo;

public interface consumoRepository extends MongoRepository<consumo, String>{
    

    
}
