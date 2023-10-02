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
@Table(name = "check")
public class Check {

    //id 
    //llegada:bool para saber si es llegada o salida
    //fecha
    //idReserva
    //usuarios_id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean llegada;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name="reservahabitaciones_id", referencedColumnName = "id")
    private ReservaHabitacion reservahabitaciones_id;

    @ManyToOne
    @JoinColumn(name="usuarios_id", referencedColumnName = "id")
    private Usuario usuarios_id;

    public Check() 
    {;}

    public Check(boolean llegada, Date fecha, ReservaHabitacion reservahabitaciones_id, Usuario usuarios_id) {
        this.llegada = llegada;
        this.fecha = fecha;
        this.reservahabitaciones_id = reservahabitaciones_id;
        this.usuarios_id = usuarios_id;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public boolean getLlegada() {
        return this.llegada;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public ReservaHabitacion getIdReserva() {
        return this.reservahabitaciones_id;
    }

    public Usuario getIdUsuario() {
        return this.usuarios_id;
    }

    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLlegada(boolean llegada) {
        this.llegada = llegada;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdReserva(ReservaHabitacion reservahabitaciones_id) {
        this.reservahabitaciones_id = reservahabitaciones_id;
    }

    public void setIdUsuario(Usuario usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    
}
