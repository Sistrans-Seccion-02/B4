package com.example.demo.modelo;

import java.lang.annotation.Inherited;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "productos")
public class producto {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("descripcion")
    private String descripcion;

    @Field("costo")
    private int costo;


    public producto(){}

    public producto(String nombre, String descripcion, int costo){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo= costo;
    }

    public String getId(){
        return id;
    }
}
