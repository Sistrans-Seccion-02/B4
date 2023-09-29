package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaServ;

public interface ReservaServRepository extends JpaRepository<ReservaServ, Integer> {
    //mostrar todas las reservas de servicios
    @Query(value = "SELECT * FROM reservaservicios", nativeQuery = true)
    Collection<ReservaServ> mostrarReservasServicios();

    //mostrar reserva por un id
    @Query(value = "SELECT * FROM reservaservicios WHERE id = :id", nativeQuery = true)
    ReservaServ mostrarReservaServicioPorId(@Param("id") Integer id);

    //insertar reserva
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaservicios(fechaInicio, fechaFin, pago, id_servicio) VALUES (:fechaInicio, :fechaFin, :pago, :id_servicio)", nativeQuery = true)
    void insertarReservaServicio(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("pago") Float pago, @Param("id_servicio") Integer id_servicio);

    //actualizar reserva
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaservicios SET fechaInicio = :fechaInicio, fechaFin = :fechaFin, pago = :pago, id_servicio = :id_servicio WHERE id = :id", nativeQuery = true)
    void actualizarReservaServicio(@Param("id") Integer id, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("pago") Float pago, @Param("id_servicio") Integer id_servicio);

    //borrar reserva
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaservicios WHERE id = :id", nativeQuery = true)
    void eliminarReservaServicio(@Param("id") Integer id);
}

