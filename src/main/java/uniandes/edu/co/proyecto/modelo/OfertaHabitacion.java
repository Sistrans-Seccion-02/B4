package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.controller.OfertaHabitacionController;

@Entity
@Table(name = "OFERTASHABITACIONES")
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
    public Integer id;

    private Integer capacidad;

    @Column(name = "fechainicio")
    private Date fechaInicio;

    @Column(name = "fechafin")
    private Date fechaFin;

    private float costo;

    @Column(name = "tipohabitacion")
    private String tipoHabitacion;

    @ManyToOne
    @JoinColumn(name="usuarios_id", referencedColumnName = "id")
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName = "id")
    private Hotel id_hotel;

    public Double existe;

    public Integer habitacion_id;

    public OfertaHabitacion() 
    {;}

    public OfertaHabitacion(Integer capacidad, Date fechaInicio, Date fechaFin, Float costo, String tipoHabitacion,Usuario id_usuario ,Hotel id_hotel, Integer habitacion_id) {
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.tipoHabitacion = tipoHabitacion;
        this.id_usuario = id_usuario;
        this.id_hotel = id_hotel;
        this.habitacion_id = habitacion_id;
        this.existe = 1.0;
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

    public Usuario getIdUsuario() {
        return this.id_usuario;
    }

    public Hotel getIdHotel() {
        return this.id_hotel;
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

    public void setIdUsuario(Usuario idUsuario) {
        this.id_usuario=idUsuario;
    }

    public void setIdHotel(Hotel idHotel) {
        this.id_hotel=idHotel;
    }

    public Double getExiste() {
        return this.existe;
    }

    public void setExiste(Double existe) {
        this.existe = existe;
    }

    public Integer getHabitacion_id() {
        return this.habitacion_id;
    }

    public void setHabitacion_id(Integer habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    
    
}
