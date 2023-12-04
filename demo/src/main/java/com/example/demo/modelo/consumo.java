package com.example.demo.modelo;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumos")
public class consumo {

    @Id
    private String id;

    //id del servicio
    private String idServicio;

    //id de la reserva
    private String idReserva;

    //inicio
    private Date inicio;

    //fin
    private Date fin;

    //pago
    private float pago;

    public consumo(){
        //Constructor vacio para el uso de Spring
    }

    public consumo(String idServicio,String idReserva, Date inicio, Date fin, float pago) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.idServicio = idServicio;
        this.idReserva = idReserva;
        this.inicio = inicio;
        this.fin = fin;
        this.pago = pago;
    }

    //<---------- Getters and Setters ---------->
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getidServicio(){
        return idServicio;
    }

    public void setidServicio(String idServicio){
        this.idServicio = idServicio;
    }

    public String getidReserva(){
        return idReserva;
    }

    public void setidReserva(String idReserva){
        this.idReserva = idReserva;
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
