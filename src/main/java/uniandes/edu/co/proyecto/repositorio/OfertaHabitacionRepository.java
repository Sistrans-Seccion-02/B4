package uniandes.edu.co.proyecto.repositorio;
import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OfertaHabitacion;

public interface OfertaHabitacionRepository extends JpaRepository<OfertaHabitacion, Integer> {

    //id
    //capacidad
    //fechaInicio
    //fechaFin
    //costo
    //tipoHabitacion
    //idHotel

    //mostrar todas las ofertas de habitacion
    @Query(value = "SELECT * FROM ofertahabitacion", nativeQuery = true)
    Collection<OfertaHabitacion> mostrarOfertasHabitacion();

    //mostrar oferta de habitacion por id
    @Query(value = "SELECT * FROM ofertahabitacion WHERE id = :id", nativeQuery = true)
    OfertaHabitacion mostrarOfertaHabitacionPorId(@Param("id") Integer id);

    //insertar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ofertahabitacion (capacidad, fechaInicio, fechaFin, costo, tipoHabitacion, idHotel) VALUES (:capacidad, :fechaInicio, :fechaFin, :costo, :tipoHabitacion, :idHotel)", nativeQuery = true)
    void insertarOfertaHabitacion(@Param("capacidad") Integer capacidad, 
    @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, 
    @Param("costo") float costo, @Param("tipoHabitacion") String tipoHabitacion, @Param("idHotel") Integer idHotel);

    //actualizar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE ofertahabitacion SET capacidad = :capacidad, fechaInicio = :fechaInicio, fechaFin = :fechaFin, costo = :costo, tipoHabitacion = :tipoHabitacion, idHotel = :idHotel WHERE id = :id", nativeQuery = true)
    void actualizarOfertaHabitacion(@Param("id") Integer id, @Param("capacidad") Integer capacidad, 
    @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, 
    @Param("costo") float costo, @Param("tipoHabitacion") String tipoHabitacion, @Param("idHotel") Integer idHotel);

    //eliminar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ofertahabitacion WHERE id = :id", nativeQuery = true)
    void eliminarOfertaHabitacion(@Param("id") Integer id);
    
}
