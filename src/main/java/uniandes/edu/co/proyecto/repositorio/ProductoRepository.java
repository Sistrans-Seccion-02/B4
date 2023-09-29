package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    //mostrar todos los productos
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> mostrarProductos();

    //mostrar productos por id
    @Query(value = "SELECT * FROM productos WHERE id = :id", nativeQuery = true)
    Producto mostrarProductoPorId(@Param("id") Integer id);

    //Insertar producto
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos(costo, descripcion) VALUES (:costo, :descripcion)" , nativeQuery = true)
    void insertarProducto(@Param("costo") Float costo, @Param("descripcion") String descripcion);
    
    //Actualizar producto
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET costo = :costo, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("costo") Float costo, @Param("descripcion") String descripcion );
    
    //Borrar producto
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);
}  
