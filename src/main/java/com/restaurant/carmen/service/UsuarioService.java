
package com.restaurant.carmen.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.models.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	//Llamar a guardar para guardar en usuario

    public Usuario save(UsuarioRegistroDTO registroDTO);
    
    //Enlistar usuarios
    
    public List<Usuario> listarUsuarios(); 
    
    //Eliminar usuarios
    
    void eliminarUsuario(Long id);
    
    //Buscar usuario por Id
    
    Usuario obtenerUsuarioPorId(Long id);
    
    //Editar usuarios

    void actualizarUsuario(Usuario usuario);
    
    //obtener usuario por email
    
    Usuario obtenerUsuarioPorEmail(String email);
    
    //Eliminar dato en reserva
    
    void eliminarReserva(Long id);



}