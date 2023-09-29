package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicioshoteles")
public class ServicioHotel {
    
    @EmbeddedId
    private ServicioHotelPK pk;

    public ServicioHotel() 
    {;}

    public ServicioHotel(Servicio idServicio, Hotel idHotel) 
    {
        this.pk = new ServicioHotelPK(idServicio, idHotel);
    }

    public ServicioHotelPK getPk() {
        return this.pk;
    }

    public void setPk(ServicioHotelPK pk) {
        this.pk = pk;
    }

}
