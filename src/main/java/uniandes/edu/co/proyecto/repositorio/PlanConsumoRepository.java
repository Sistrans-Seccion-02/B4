package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer> {

     //mostrar todos los planes de consumo
     @Query(value = "SELECT * FROM planesconsumo", nativeQuery = true)
     Collection<PlanConsumo> mostrarPlanesConsumo();
 
     //mostrar planes de consumo por id
     @Query(value = "SELECT * FROM planesconsumo WHERE id = :id", nativeQuery = true)
     PlanConsumo mostrarPlanConsumoporId(@Param("id") Integer id);
 
     //insertar planes de consumo
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO planesconsumo (id, nombre, descuento) VALUES (:id, :nombre, :descuento)", nativeQuery = true)
     void insertarPlanConsumo(@Param("id") int id, @Param("nombre") String nombre, 
     @Param("descuento") Float descuento);
 
     //actualizar planes de consumo
     @Modifying
     @Transactional
     @Query(value = "UPDATE planesconsumo SET nombre = :nombre, descuento = :descuento WHERE id = :id", nativeQuery = true)
     void actualizarPlanConsumo(@Param("id") Integer id, @Param("nombre") String nombre, 
     @Param("descuento") Float descuento);
 
     //eliminar planes de consumo
     @Modifying
     @Transactional
     @Query(value = "DELETE FROM planesconsumo WHERE id = :id", nativeQuery = true)
     void eliminarPlanConsumo(@Param("id") Integer id);
}
