package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.HabitacionDotacion;

public interface HabitacionDotacionRepository extends JpaRepository<HabitacionDotacion, Integer> {

    //idOfertaHabitacion
    //idDotacion

    //mostrar todas las relaciones habitacion dotacion
    @Query(value = "SELECT * FROM habitaciondotacion", nativeQuery = true)
    Collection<HabitacionDotacion> mostrarHabitacionesDotaciones();

    //mostrar relacion habitacion dotacion por id
    @Query(value = "SELECT * FROM habitaciondotacion WHERE idOfertaHabitacion = :idOfertaHabitacion AND idDotacion = :idDotacion", nativeQuery = true)
    HabitacionDotacion mostrarHabitacionDotacionPorId(@Param("idOfertaHabitacion") Integer idOfertaHabitacion, @Param("idDotacion") Integer idDotacion);

    //insertar relacion habitacion dotacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciondotacion (idOfertaHabitacion, idDotacion) VALUES (:idOfertaHabitacion, :idDotacion)", nativeQuery = true)
    void insertarHabitacionDotacion(@Param("idOfertaHabitacion") Integer idOfertaHabitacion, @Param("idDotacion") Integer idDotacion);

    //actualizar relacion habitacion dotacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciondotacion SET idOfertaHabitacion = :idOfertaHabitacion, idDotacion = :idDotacion WHERE idOfertaHabitacion = :idOfertaHabitacion AND idDotacion = :idDotacion", nativeQuery = true)
    void actualizarHabitacionDotacion(@Param("idOfertaHabitacion") Integer idOfertaHabitacion, @Param("idDotacion") Integer idDotacion);

    //eliminar relacion habitacion dotacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciondotacion WHERE idOfertaHabitacion = :idOfertaHabitacion AND idDotacion = :idDotacion", nativeQuery = true)
    void eliminarHabitacionDotacion(@Param("idOfertaHabitacion") Integer idOfertaHabitacion, @Param("idDotacion") Integer idDotacion);
    

    
}
