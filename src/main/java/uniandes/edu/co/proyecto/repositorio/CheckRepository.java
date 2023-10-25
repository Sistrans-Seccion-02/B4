package uniandes.edu.co.proyecto.repositorio;
import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Check;

public interface CheckRepository extends JpaRepository<Check, Integer> {

    //id 
    //llegada:bool para saber si es llegada o salida
    //fecha
    //idReserva
    //idUsuario

    //mostrar todos los checks sin importar si son de llegada o salida
    @Query(value = "SELECT * FROM \"Check\"", nativeQuery = true)
    Collection<Check> mostrarChecks();

    //mostrar todos los checks que sean de llegada
    @Query(value = "SELECT * FROM \"Check\" WHERE llegada = true", nativeQuery = true)
    Collection<Check> mostrarChecksLlegada();

    //mostrar todos los checks que sean de salida
    @Query(value = "SELECT * FROM \"Check\" WHERE llegada = false", nativeQuery = true)
    Collection<Check> mostrarChecksSalida();

    //mostrar el check por id
    @Query(value = "SELECT * FROM \"Check\" WHERE id = :id", nativeQuery = true)
    Check mostrarCheckPorId(@Param("id") Integer id);

    //mostrar los checks de un usuario
    @Query(value = "SELECT * FROM \"Check\" WHERE idUsuario = :idUsuario", nativeQuery = true)
    Collection<Check> mostrarChecksPorUsuario(@Param("idUsuario") Integer idUsuario);

    //insertar check
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"Check\" (id,llegada, fecha, reservahabitaciones_id, usuarios_id) VALUES (hoteles_sequence.nextval,:llegada, :fecha, :idReserva, :idUsuario)", nativeQuery = true)
    void insertarCheck(@Param("llegada") Boolean llegada, @Param("fecha") Date fecha, 
    @Param("idReserva") Integer idReserva, @Param("idUsuario") Integer idUsuario);

    //actualizar check
    @Modifying
    @Transactional
    @Query(value = "UPDATE \"Check\" SET llegada = :llegada, fecha = :fecha, idReserva = :idReserva, idUsuario = :idUsuario WHERE id = :id", nativeQuery = true)
    void actualizarCheck(@Param("id") Integer id, @Param("llegada") Boolean llegada, @Param("fecha") Date fecha,
    @Param("idReserva") Integer idReserva, @Param("idUsuario") Integer idUsuario);

    //eliminar check
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM \"Check\" WHERE id = :id", nativeQuery = true)
    void eliminarCheck(@Param("id") Integer id);

  

    
}
