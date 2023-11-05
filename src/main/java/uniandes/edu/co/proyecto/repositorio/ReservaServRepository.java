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
    @Query(value = "INSERT INTO reservaservicios(id,fechaInicio, fechaFin, pago, servicios_id, habitacion_id) VALUES (hoteles_sequence.nextval,:fechaInicio, :fechaFin, :pago, :servicios_id, :habitacion_id)", nativeQuery = true)
    void insertarReservaServicio(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("pago") Float pago, @Param("servicios_id") Integer servicios_id, @Param("habitacion_id") Integer habitacion_id);

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
}

