package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaHabitacion;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer> {

    //id
    //fechaInicio
    //fechaFin
    //pago
    //idHabitacion
    //idCliente

    //mostrar todas las reservas de habitacion
    @Query(value = "SELECT * FROM reservahabitacion", nativeQuery = true)
    Collection<ReservaHabitacion> mostrarReservasHabitacion();

    //mostrar reserva de habitacion por id
    @Query(value = "SELECT * FROM reservahabitacion WHERE id = :id", nativeQuery = true)
    ReservaHabitacion mostrarReservaHabitacionPorId(@Param("id") Integer id);

    //insertar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservahabitacion (fechaInicio, fechaFin, pago, idHabitacion, idCliente) VALUES (:fechaInicio, :fechaFin, :pago, :idHabitacion, :idCliente)", nativeQuery = true)
    void insertarReservaHabitacion(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin,
            @Param("pago") float pago, @Param("idHabitacion") Integer idHabitacion,
            @Param("idCliente") Integer idCliente);

    //actualizar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservahabitacion SET fechaInicio = :fechaInicio, fechaFin = :fechaFin, pago = :pago, idHabitacion = :idHabitacion, idCliente = :idCliente WHERE id = :id", nativeQuery = true)
    void actualizarReservaHabitacion(@Param("id") Integer id, @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin, @Param("pago") float pago, @Param("idHabitacion") Integer idHabitacion,
            @Param("idCliente") Integer idCliente);

    //eliminar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservahabitacion WHERE id = :id", nativeQuery = true)
    void eliminarReservaHabitacion(@Param("id") Integer id);
    
}
