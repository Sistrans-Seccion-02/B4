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
@Table(name = "checks")
public class Check {

    //id 
    //llegada:bool para saber si es llegada o salida
    //fecha
    //idReserva
    //idUsuario
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean llegada;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name="idReserva", referencedColumnName = "id")
    private ReservaHabitacion idReserva;

    @ManyToOne
    @JoinColumn(name="idUsuario", referencedColumnName = "id")
    private Usuario idUsuario;

    public Check() 
    {;}

    public Check(boolean llegada, Date fecha, ReservaHabitacion idReserva, Usuario idUsuario) {
        this.llegada = llegada;
        this.fecha = fecha;
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
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
        return this.idReserva;
    }

    public Usuario getIdUsuario() {
        return this.idUsuario;
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

    public void setIdReserva(ReservaHabitacion idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
