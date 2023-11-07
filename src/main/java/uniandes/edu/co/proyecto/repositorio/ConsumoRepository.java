package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import oracle.net.aso.h;
import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {
    

    //mostrar todos los consumos
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> mostrarConsumos();

    //mostrar consumo por id
    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo mostrarConsumoPorId(@Param("id") Integer id);
    
    //mostrar los consumos de una reserva
    @Query(value = "SELECT * FROM consumos WHERE idReserva =:idReserva", nativeQuery = true)
    Collection<Consumo> mostrarConsumosPorReserva(@Param("idReserva") Integer idReserva);

    //insertar consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos(descripcion, costo, fecha, idReserva) VALUES (:descripcion, :costo, :fecha, :idReserva)", nativeQuery = true)
    void insertarConsumo(@Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("fecha") Date fecha, @Param("idReserva") Integer idReserva);

    //actualizar consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET descripcion = :descripcion, costo = :costo, fecha = :fecha, idReserva = :idReserva WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id")Integer id, @Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("fecha") Date fecha, @Param("idReserva") Integer idReserva );
    
    //borrar consumo 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id);   

    //CONSUMO DADO UN USUARIO Y UN RANGO DE FECHAS
    @Query( value = "SELECT h.nombre AS hotel_nombre,"
        + "c.fecha AS fecha_consumo,"
        + "c.descripcion AS descripcion_consumo,"
        + "c.costo AS costo_consumo "
        + "FROM hoteles h "
        + "JOIN ofertashabitaciones oh ON h.id = oh.hoteles_id "
        + "JOIN reservahabitaciones rh ON oh.id = rh.ofertashabitaciones_id "
        + "JOIN consumos c ON rh.id = c.reservahabitaciones_id "
        + "JOIN usuarios u ON rh.usuarios_id = u.id "
        + "WHERE u.id = :id "
        + "AND c.fecha BETWEEN :fecha1 AND :fecha2", nativeQuery = true)
    List<Object[]> mostrarConsumosFechasUsuario(@Param("id") Integer id, @Param("fecha1") Date fecha1,  @Param("fecha2") Date fecha2);
}   

