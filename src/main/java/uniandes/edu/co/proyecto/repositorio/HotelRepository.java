package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    //mostrar todos los hoteles
    @Query(value = "SELECT * FROM hotel", nativeQuery = true)
    Collection<Hotel> mostrarHoteles();

    //mostrar hotel por id
    @Query(value = "SELECT * FROM hotel WHERE id = :id", nativeQuery = true)
    Hotel mostrarHotelporId(@Param("id") Integer id);

    //insertar hotel
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotel (nombre, ubicacion) VALUES (:nombre, :ubicacion)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre, 
    @Param("ubicacion") String ubicacion);

    //actualizar hotel
    @Modifying
    @Transactional
    @Query(value = "UPDATE hotel SET nombre = :nombre, ubicacion = :ubicacion WHERE id = :id", nativeQuery = true)
    void actualizarHotel(@Param("id") Integer id, @Param("nombre") String nombre, 
    @Param("ubicacion") String ubicacion);

    //eliminar hotel
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id") Integer id);
}
