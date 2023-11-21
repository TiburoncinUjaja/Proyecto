
package com.restaurant.carmen.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.models.Usuario;

/**
 * Interfaz de servicio para operaciones relacionadas con la entidad Usuario.
 */

public interface UsuarioService extends UserDetailsService{
	
	 /**
     * Guarda un nuevo usuario a partir de la información proporcionada en el DTO de registro.
     *
     * @param registroDTO El DTO que contiene la información del nuevo usuario.
     * @return El usuario guardado.
     */

    public Usuario save(UsuarioRegistroDTO registroDTO);
    
     /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return La lista de todos los usuarios.
     */
    
    public List<Usuario> listarUsuarios(); 
    
    /**
     * Elimina un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     */
    
    void eliminarUsuario(Long id);
    
    /**
     * Obtiene un usuario por su ID.
     *
     * @param id El ID del usuario a obtener.
     * @return El usuario encontrado o null si no se encuentra.
     */
    
    Usuario obtenerUsuarioPorId(Long id);
    
    /**
     * Actualiza la información de un usuario.
     *
     * @param usuario El usuario con la información actualizada.
     */

    void actualizarUsuario(Usuario usuario);
    
    /**
     * Obtiene un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    
    Usuario obtenerUsuarioPorEmail(String email);
    
    /**
     * Elimina una reserva por su ID.
     *
     * @param id El ID de la reserva a eliminar.
     */
    
    void eliminarReserva(Long id);



}