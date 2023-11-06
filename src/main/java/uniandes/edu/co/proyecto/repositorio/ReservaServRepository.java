package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.interfaces.req1;
import uniandes.edu.co.proyecto.interfaces.req2;
import uniandes.edu.co.proyecto.modelo.ReservaServ;

public interface ReservaServRepository extends JpaRepository<ReservaServ, Integer> {
    
    //mostrar dinero recolectado por reservas de cada habitacion en el ultimo año
    @Query(value = "SELECT habitacion_id, sum(pago) as pago FROM reservaservicios WHERE fechafin >= ADD_MONTHS(TRUNC(SYSDATE),-12) AND fechafin < TRUNC(SYSDATE) GROUP BY habitacion_id", nativeQuery = true)
    Collection<req1> mostrarReservasHabitacion(); 

    //mostrar reserva por un id
    @Query(value = "SELECT * FROM reservaservicios WHERE id = :id", nativeQuery = true)
    ReservaServ mostrarReservaServicioPorId(@Param("id") Integer id);

    //insertar reserva
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaservicios(id,fechaInicio, fechaFin, pago, servicios_id, habitacion_id, nombre_servicio, existe) VALUES (hoteles_sequence.nextval,:fechaInicio, :fechaFin, :pago, :servicios_id, :habitacion_id, :nombre_servicio, 1)", nativeQuery = true)
    void insertarReservaServicio(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("pago") Float pago, @Param("servicios_id") Integer servicios_id, @Param("habitacion_id") Integer habitacion_id, @Param("nombre_servicio") String nombre_servicio);

    //actualizar reserva
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaservicios SET fechaInicio = :fechaInicio, fechaFin = :fechaFin, pago = :pago, servicios_id = :servicios_id WHERE id = :id", nativeQuery = true)
    void actualizarReservaServicio(@Param("id") Integer id, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("pago") Float pago, @Param("servicios_id") Integer servicios_id);

    //borrar reserva
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaservicios WHERE id = :id", nativeQuery = true)
    void eliminarReservaServicio(@Param("id") Integer id);
    
    //mostrar todas las reservas de servicios
    @Query(value= "SELECT * FROM reservaservicios"
    , nativeQuery= true)
    Collection<ReservaServ> mostrarReservasServicios();

    //mostrar servicios populares
    @Query(value="SELECT nombre_servicio, sum(existe) as existe FROM reservaservicios WHERE fechafin <= :fecha2 AND fechafin >= :fecha1 GROUP BY nombre_servicio ORDER BY existe DESC",
    nativeQuery = true)
    Collection<req2> mostrarServiciosPopulares( @Param("fecha2") Date fecha2,  @Param("fecha1") Date fecha1);
}

