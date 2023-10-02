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
;

@Entity
@Table(name = "RERSERVASHABITACIONES")
public class ReservaHabitacion {

    //id
    //fechaInicio
    //fechaFin
    //pago
    //ofertashabitaciones_id
    //usuarios_id

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fechainicio")
    private Date fechaInicio;
    
    @Column(name = "fechafin")
    private Date fechaFin;

    private float pago;

    @ManyToOne
    @JoinColumn(name="planesconsumo_id", referencedColumnName = "id")
    private PlanConsumo planesconsumo_id;

    @ManyToOne
    @JoinColumn(name="ofertashabitaciones_id", referencedColumnName = "id")
    private OfertaHabitacion ofertashabitaciones_id;

    @ManyToOne
    @JoinColumn(name="usuarios_id", referencedColumnName = "id")
    private Usuario usuarios_id;

    public ReservaHabitacion() 
    {;}

    public ReservaHabitacion(Date fechaInicio, Date fechaFin, float pago,PlanConsumo planesconsumo_id ,OfertaHabitacion ofertashabitaciones_id, Usuario usuarios_id) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pago = pago;
        this.planesconsumo_id = planesconsumo_id;
        this.ofertashabitaciones_id = ofertashabitaciones_id;
        this.usuarios_id = usuarios_id;
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

    public PlanConsumo getplanesconsumo_id() {
        return this.planesconsumo_id;
    }

    public OfertaHabitacion getIdHabitacion() {
        return this.ofertashabitaciones_id;
    }

    public Usuario getIdCliente() {
        return this.usuarios_id;
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

    public void setplanesconsumo_id(PlanConsumo planesconsumo_id) {
        this.planesconsumo_id=planesconsumo_id;
    }

    public void setIdHabitacion(OfertaHabitacion ofertashabitaciones_id) {
        this.ofertashabitaciones_id=ofertashabitaciones_id;
    }

    public void setIdCliente(Usuario usuarios_id) {
        this.usuarios_id=usuarios_id;
    }

    
}
