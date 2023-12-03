package com.example.demo.modelo;

public class productoEmbedded {

    private String nombre;
    private String descripcion;
    private int costo;

    public productoEmbedded(){}

    public productoEmbedded(String nombre, String descripcion, int costo){

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
}
