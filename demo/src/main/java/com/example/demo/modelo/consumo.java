package com.example.demo.modelo;

import java.lang.annotation.Inherited;
import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumos")
public class consumo {

    @Id
    private String id;

    //id del servicio
    private String id_servicio;

    //inicio
    private Date inicio;

    //fin
    private Date fin;

    //pago
    private float pago;

    public consumo(){
        //Constructor vacio para el uso de Spring
    }

    public consumo(String id_servicio, Date inicio, Date fin, float pago) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.id_servicio = id_servicio;
        this.inicio = inicio;
        this.fin = fin;
        this.pago = pago;
    }

    //<---------- Getters and Setters ---------->
    public String getId_servicio(){
        return id_servicio;
    }

    public void setId_servicio(String id_servicio){
        this.id_servicio = id_servicio;
    }

    public Date getInicio(){
        return inicio;
    }

    public void setInicio(Date inicio){
        this.inicio = inicio;
    }

    public Date getFin(){
        return fin;
    }

    public void setFin(Date fin){
        this.fin = fin;
    }

    public float getPago(){
        return pago;
    }

    public void setPago(float pago){
        this.pago = pago;
    }
    
    
}
