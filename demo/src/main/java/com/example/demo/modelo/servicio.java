package com.example.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicios")
public class servicio {
    @Id
    private String id;

    // Nombre del servicio
    private String nombre;

    // Inicio del servicio
    private Date inicio_servicio;

    // Fin del servicio
    private Date fin_servicio;


    // Costo del servicio
    private float costo;

    // Productos del servicio
    private List<productoEmbedded> productos;

    // Constructor vacio para el uso de Spring
    public servicio(){}

    public servicio(String nombre, Date inicio_servicio, Date fin_servicio, float costo, List<productoEmbedded> productos) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.nombre = nombre;
        this.inicio_servicio = inicio_servicio;
        this.fin_servicio = fin_servicio;
        this.costo = costo;
        this.productos = productos;
    }

    //<---------- Getters and Setters ---------->

    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String name){
        this.nombre = name;
    }


    public Date getInicio_Servicio(){
        return inicio_servicio;
    }

    public void setInicio_Servicio(Date inicio_servicio){
        this.inicio_servicio = inicio_servicio;
    }

    public Date getFin_Servicio(){
        return fin_servicio;
    }

    public void setFin_Servicio(Date fin_servicio){
        this.fin_servicio = fin_servicio;
    }

    public float getCosto(){
        return costo;
    }

    public void setCosto(float costo){
        this.costo = costo;
    }

    public List<productoEmbedded> getProductos(){
        return productos;
    }

    public void setProductos(List<productoEmbedded> productos){
        this.productos = productos;
    }

    public void addProducto(productoEmbedded producto){
        this.productos.add(producto);
    }

    
}
