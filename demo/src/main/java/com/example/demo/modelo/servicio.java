package com.example.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "servicios")
public class servicio {
    @Id
    public String id;

    // Nombre del servicio
    private String nombre;

    // Inicio del servicio
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioServicio;

    // Fin del servicio
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finServicio;


    // Costo del servicio
    private float costo;

    // Productos del servicio
    private String productos;

    // Constructor vacio para el uso de Spring
    public servicio(){}

    public servicio(String nombre, Date inicioServicio, Date finServicio, float costo, String productos) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.nombre = nombre;
        this.inicioServicio = inicioServicio;
        this.finServicio = finServicio;
        this.costo = costo;
        this.productos = productos;
    }

    //<---------- Getters and Setters ---------->

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String name){
        this.nombre = name;
    }


    public Date getInicioServicio(){
        return inicioServicio;
    }

    public void setInicioServicio(Date inicioServicio){
        this.inicioServicio = inicioServicio;
    }

    public Date getFinServicio(){
        return finServicio;
    }

    public void setfinServicio(Date finServicio){
        this.finServicio = finServicio;
    }

    public float getCosto(){
        return costo;
    }

    public void setCosto(float costo){
        this.costo = costo;
    }

    public String getProductos(){
        return productos;
    }

    public void setProductos(String productos){
        this.productos = productos;
    }


    
}
