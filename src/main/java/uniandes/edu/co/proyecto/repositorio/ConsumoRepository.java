package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
    void actualizarConsumo(@Param("id")Integer id, @Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("fecha") Date fecha );
    
    //borrar consumo 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id);   
}
