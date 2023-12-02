package com.example.demo.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.modelo.producto;

public interface productoRepository  extends MongoRepository<producto, String>{
    List<producto> findByNombre(String nombre);
}
