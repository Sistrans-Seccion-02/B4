package com.example.demo.repositorio;
import java.util.List;

import com.example.demo.modelo.consumo;

public interface consumoRepository {
    List<consumo> findAll();
    consumo findById(String id);
    consumo save(consumo consumo);
    void deleteById(String id);
    //buscar reservas por id de servicio
    List<consumo> findByIdServicio(String idServicio);
    
    
}
