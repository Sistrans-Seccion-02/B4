package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EstablecimientoProductoPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="idProducto", referencedColumnName = "id")
    private Producto idProducto;


    @ManyToOne
    @JoinColumn(name="idEstablecimiento", referencedColumnName = "id")
    private Establecimiento idEstablecimiento;

    public EstablecimientoProductoPK(Producto idProducto, Establecimiento idEstablecimiento)
    {
        super();
        this.idProducto = idProducto;
        this.idEstablecimiento = idEstablecimiento;
    }
    public EstablecimientoProductoPK()
    {super();}
    public Producto getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }
    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    
}
