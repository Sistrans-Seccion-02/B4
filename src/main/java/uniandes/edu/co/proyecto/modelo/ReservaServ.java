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
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    public Servicio id_servicio;

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
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getfechaInicio() {
        return this.fechaInicio;
    }
    public void setfechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getfechaFin() {
        return this.fechaFin;
    }
    public void setfechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Float getPago() {
        return this.pago;
    }
    public void setPago(Float pago) {
        this.pago = pago;
    }
    public Servicio getid_servicio() {
        return this.id_servicio;
    }
    public void setid_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    
}
