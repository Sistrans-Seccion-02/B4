package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;

public class EstablecimientoProducto{
    @EmbeddedId
    private EstablecimientoProductoPK pk;

    public EstablecimientoProducto()
    {;}

    public EstablecimientoProducto(Establecimiento idEstablecimiento, Producto idProducto)
    {
        this.pk = new EstablecimientoProductoPK(idProducto, idEstablecimiento);
    }

    public EstablecimientoProductoPK getPk() {
        return pk;
    }

    public void setPk(EstablecimientoProductoPK pk) {
        this.pk = pk;
    }

    
}