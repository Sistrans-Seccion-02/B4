package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaservicios")
public class ReservaServ {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name = "fechainicio")
    public Date fechaInicio;
    @Column (name = "fechafin")
    public Date fechaFin;
    private Float pago;

    @ManyToOne
    @JoinColumn(name="id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    public ReservaServ(Integer id, Date fechaInicio, Date fechaFin, Float pago, Servicio id_servicio)
    {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pago = pago;
        this.id_servicio = id_servicio;
    }
    public ReservaServ()
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getfechaInicio() {
        return fechaInicio;
    }
    public void setfechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getfechaFin() {
        return fechaFin;
    }
    public void setfechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Float getPago() {
        return pago;
    }
    public void setPago(Float pago) {
        this.pago = pago;
    }
    public Servicio getid_servicio() {
        return id_servicio;
    }
    public void setid_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    
}
