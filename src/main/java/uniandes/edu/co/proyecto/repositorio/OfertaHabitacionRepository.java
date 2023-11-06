package uniandes.edu.co.proyecto.repositorio;
import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.interfaces.req3;
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
    @Query(value = "SELECT * FROM ofertashabitaciones", nativeQuery = true)
    Collection<OfertaHabitacion> mostrarOfertasHabitacion();

    //mostrar oferta de habitacion por id
    @Query(value = "SELECT * FROM ofertashabitaciones WHERE id = :id", nativeQuery = true)
    OfertaHabitacion mostrarOfertaHabitacionPorId(@Param("id") Integer id);

    //insertar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ofertashabitaciones (id,capacidad, fechaInicio, fechaFin, costo, tipoHabitacion,usuarios_id ,hoteles_id, existe, habitacion_id) VALUES (hoteles_sequence.nextval,:capacidad, :fechaInicio, :fechaFin, :costo, :tipoHabitacion,:usuarios_id ,:hoteles_id, ROUND((:fechaFin - :fechaInicio)/3.65,2), :habitacion_id)", nativeQuery = true)
    void insertarOfertaHabitacion(@Param("capacidad") Integer capacidad, 
    @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, 
    @Param("costo") float costo, @Param("tipoHabitacion") String tipoHabitacion,@Param("usuarios_id") Integer usuarios_id ,@Param("hoteles_id") Integer hoteles_id, @Param("habitacion_id") Integer habitacion_id);

    //actualizar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE ofertashabitaciones SET capacidad = :capacidad, fechaInicio = :fechaInicio, fechaFin = :fechaFin, costo = :costo, tipoHabitacion = :tipoHabitacion,:usuarios_id ,:hoteles_id, :habitacion_id WHERE id = :id", nativeQuery = true)
    void actualizarOfertaHabitacion(@Param("id") Integer id, @Param("capacidad") Integer capacidad, 
    @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, 
    @Param("costo") float costo, @Param("tipoHabitacion") String tipoHabitacion, @Param("usuarios_id") Integer usuarios_id ,@Param("hoteles_id") Integer hoteles_id, @Param("habitacion_id") Integer habitacion_id);

    //eliminar oferta de habitacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ofertashabitaciones WHERE id = :id", nativeQuery = true)
    void eliminarOfertaHabitacion(@Param("id") Integer id);

    //mostrar porcentaje ocupacion
    @Query(value= "SELECT habitacion_id, sum(existe) as existe FROM ofertashabitaciones WHERE fechafin >= ADD_MONTHS(TRUNC(SYSDATE),-12) AND fechafin < TRUNC(SYSDATE) GROUP BY habitacion_id"
    , nativeQuery = true)
    Collection<req3> mostrarPorcentajeOcupacion();


    @Query(value ="UPDATE ofertashabitaciones SET existe = :nuevoExiste WHERE id = :id" , nativeQuery = true)
    void cambiarExiste(@Param("id") Integer id, @Param("nuevoExiste") Double nuevoExiste);
}
