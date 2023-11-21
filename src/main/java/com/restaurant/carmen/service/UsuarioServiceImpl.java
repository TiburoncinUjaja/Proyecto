package com.restaurant.carmen.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.models.Rol;
import com.restaurant.carmen.models.Usuario;
import com.restaurant.carmen.repository.ReservaRepository;
import com.restaurant.carmen.repository.UsuarioRepository;

/**
 * Implementación de la interfaz UsuarioService que proporciona operaciones relacionadas con la entidad Usuario.
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    private BCryptPasswordEncoder passwordEncoder;
    
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ReservaRepository reservaRepository;
    
    //Constructor

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    //Constructor
    
    @Autowired
    public UsuarioServiceImpl(BCryptPasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }
    
    // Crear rol "usuario" y guardarlo

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepository.save(usuario);
    }
    
    //Buscar usuario por email

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }
    
    // Mapear roles a autoridades de seguridad

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
    
    // Obtener todos los usuarios

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
    // Eliminar usuario por ID

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
    // Obtener usuario por ID

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
    // Actualizar información de usuario

	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
    // Obtener usuario por email

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
	}
	
    // Eliminar reserva por ID

	@Override
	public void eliminarReserva(Long id) {
		reservaRepository.deleteById(id);		
	}
    
	
   
}
