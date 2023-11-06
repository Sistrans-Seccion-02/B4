package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

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
    @Query(value = "SELECT * FROM reservahabitaciones", nativeQuery = true)
    Collection<ReservaHabitacion> mostrarReservasHabitacion();

    //mostrar reserva de habitacion por id
    @Query(value = "SELECT * FROM reservahabitaciones WHERE id = :id", nativeQuery = true)
    ReservaHabitacion mostrarReservaHabitacionPorId(@Param("id") Integer id);

    //insertar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservahabitaciones (fechaInicio, fechaFin, pago,planesconsumo_id,ofertashabitaciones_id, usuarios_id ) VALUES (:fechaInicio, :fechaFin, :pago,:planesconsumo_id ,:ofertashabitaciones_id, :usuarios_id)", nativeQuery = true)
    void insertarReservaHabitacion(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin,
            @Param("pago") float pago,@Param("planesconsumo_id") Integer planesconsumo_id  ,@Param("ofertashabitaciones_id") Integer ofertashabitaciones_id,
            @Param("usuarios_id") Integer usuarios_id);

    //actualizar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservahabitaciones SET fechaInicio = :fechaInicio, fechaFin = :fechaFin, pago = :pago, planesconsumo_id = :planesconsumo_id, ofertashabitaciones_id = :ofertashabitaciones_id, usuarios_id = :usuarios_id WHERE id = :id", nativeQuery = true)
    void actualizarReservaHabitacion(@Param("id") Integer id, @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin, @Param("pago") float pago,
            @Param("planesconsumo_id") Integer planesconsumo_id ,
            @Param("ofertashabitaciones_id") Integer ofertashabitaciones_id,
            @Param("usuarios_id") Integer usuarios_id);

    //eliminar reserva de habitacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservahabitaciones WHERE id = :id", nativeQuery = true)
    void eliminarReservaHabitacion(@Param("id") Integer id);

    //mostrar fechas con mayor ocupacion
    @Query(value = "SELECT fechainicio, COUNT(*) " +
    "FROM reservahabitaciones " +
    "GROUP BY fechainicio " +
    "ORDER BY COUNT(*) DESC", nativeQuery = true)
    List<Object[]> mostrarMayorOcupacion();

    //mostrar fechas con menor ocupacion
    @Query(value = "SELECT fechainicio, COUNT(*) " +
    "FROM reservahabitaciones " +
    "GROUP BY fechainicio " +
    "ORDER BY COUNT(*) ASC", nativeQuery = true)
    List<Object[]> mostrarMenorOcupacion();

    //mostrar fechas con mayores consumos
    @Query(value = "SELECT fecha, SUM(costo) " +
        "FROM consumos " +
        "GROUP BY fecha " +
        "ORDER BY SUM(costo) DESC", nativeQuery = true)
        List<Object[]> mostrarMayorConsumo();

    
    
}
