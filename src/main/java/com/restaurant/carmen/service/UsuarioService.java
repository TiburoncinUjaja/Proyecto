
package com.restaurant.carmen.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.models.Usuario;

public interface UsuarioService extends UserDetailsService{

    public Usuario save(UsuarioRegistroDTO registroDTO);
    
    public List<Usuario> listarUsuarios(); 
    
    void eliminarUsuario(Long id);
    
    Usuario obtenerUsuarioPorId(Long id);

    void actualizarUsuario(Usuario usuario);
    
    Usuario obtenerUsuarioPorEmail(String email);
    
    void eliminarReserva(Long id);



}