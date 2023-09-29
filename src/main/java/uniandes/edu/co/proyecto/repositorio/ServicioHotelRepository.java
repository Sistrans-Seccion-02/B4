package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.ServicioHotel;

public interface ServicioHotelRepository extends JpaRepository<ServicioHotel, Integer> {

    //mostrar todas las relaciones servicio hotel
    @Query(value = "SELECT * FROM serviciohotel", nativeQuery = true)
    Collection<ServicioHotel> mostrarServiciosHoteles();

    //mostrar relacion servicio hotel por id
    @Query(value = "SELECT * FROM serviciohotel WHERE idServicio = :idServicio AND idHotel = :idHotel", nativeQuery = true)
    ServicioHotel mostrarServicioHotelPorId(@Param("idServicio") Integer idServicio, @Param("idHotel") Integer idHotel);

    //insertar relacion servicio hotel
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciohotel (idServicio, idHotel) VALUES (:idServicio, :idHotel)", nativeQuery = true)
    void insertarServicioHotel(@Param("idServicio") Integer idServicio, @Param("idHotel") Integer idHotel);

    //actualizar relacion servicio hotel
    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciohotel SET idServicio = :idServicio, idHotel = :idHotel WHERE idServicio = :idServicio AND idHotel = :idHotel", nativeQuery = true)
    void actualizarServicioHotel(@Param("idServicio") Integer idServicio, @Param("idHotel") Integer idHotel);

    //eliminar relacion servicio hotel
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciohotel WHERE idServicio = :idServicio AND idHotel = :idHotel", nativeQuery = true)
    void eliminarServicioHotel(@Param("idServicio") Integer idServicio, @Param("idHotel") Integer idHotel);
}
