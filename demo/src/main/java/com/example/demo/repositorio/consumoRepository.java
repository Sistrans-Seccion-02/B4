package com.example.demo.repositorio;
import java.util.List;

import com.example.demo.modelo.consumo;

public interface consumoRepository {
    List<consumo> findByid_servicio(String id_servicio);
    
}
