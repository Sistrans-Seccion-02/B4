package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
;

@Entity
@Table(name = "RERSERVAHABITACION")
public class ReservaHabitacion {

    //id
    //fechaInicio
    //fechaFin
    //pago
    //idHabitacion
    //idCliente

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date fechaInicio;

    private Date fechaFin;

    private float pago;

    @ManyToOne
    @JoinColumn(name="idHabitacion", referencedColumnName = "id")
    private OfertaHabitacion idHabitacion;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "id")
    private Usuario idCliente;

    public ReservaHabitacion() 
    {;}

    public ReservaHabitacion(Integer id, Date fechaInicio, Date fechaFin, float pago, OfertaHabitacion idHabitacion, Usuario idCliente) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pago = pago;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public float getPago() {
        return this.pago;
    }

    public OfertaHabitacion getIdHabitacion() {
        return this.idHabitacion;
    }

    public Usuario getIdCliente() {
        return this.idCliente;
    }

    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio=fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin=fechaFin;
    }

    public void setPago(float pago) {
        this.pago=pago;
    }

    public void setIdHabitacion(OfertaHabitacion idHabitacion) {
        this.idHabitacion=idHabitacion;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente=idCliente;
    }

    
}
