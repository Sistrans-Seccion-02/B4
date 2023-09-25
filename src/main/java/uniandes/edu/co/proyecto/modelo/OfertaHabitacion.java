package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFERTAHABITACION")
public class OfertaHabitacion {

    //id
    //capacidad
    //fechaInicio
    //fechaFin
    //costo
    //tipoHabitacion
    //idHotel
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer capacidad;

    private Date fechaInicio;

    private Date fechaFin;

    private float costo;

    private String tipoHabitacion;

    @ManyToOne
    @JoinColumn(name="idHotel", referencedColumnName = "id")
    private Hotel idHotel;

    public OfertaHabitacion() 
    {;}

    public OfertaHabitacion(Integer id, Integer capacidad, Date fechaInicio, Date fechaFin, float costo, String tipoHabitacion, Hotel idHotel) {
        this.id = id;
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.tipoHabitacion = tipoHabitacion;
        this.idHotel = idHotel;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public float getCosto() {
        return this.costo;
    }

    public String getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    public Hotel getIdHotel() {
        return this.idHotel;
    }

    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad=capacidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio=fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin=fechaFin;
    }

    public void setCosto(float costo) {
        this.costo=costo;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion=tipoHabitacion;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel=idHotel;
    }

    
    
}
