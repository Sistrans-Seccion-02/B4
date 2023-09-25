package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //id
    //nombre
    //apellido
    //correo
    //rol

    //mostrar todos los usuarios
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    Collection<Usuario> mostrarUsuarios();

    //mostrar usuario por id
    @Query(value = "SELECT * FROM usuario WHERE id = :id", nativeQuery = true)
    Usuario mostrarUsuarioPorId(@Param("id") Integer id);

    //insertar usuario
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario (nombre, apellido, correo, rol) VALUES (:nombre, :apellido, :correo, :rol)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("apellido") String apellido, 
    @Param("correo") String correo, @Param("rol") String rol);
    
    //actualizar usuario
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET nombre = :nombre, apellido = :apellido, correo = :correo, rol = :rol WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id, @Param("nombre") String nombre, @Param("apellido") String apellido, 
    @Param("correo") String correo, @Param("rol") String rol);

    //eliminar usuario
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);
    
}
