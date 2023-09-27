package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ReservaServ {
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private Float pago;

    public ReservaServ(Integer id, Date fechaInicio, Date fechaFin, Float pago)
    {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pago = pago;
    }
    public ReservaServ()
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Float getPago() {
        return pago;
    }
    public void setPago(Float pago) {
        this.pago = pago;
    }

    
}
