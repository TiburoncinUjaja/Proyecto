package com.restaurant.carmen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.carmen.models.Usuario;

/**
* Repositorio de datos para la entidad Usuario.
*/

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
	
	public Usuario findByEmail(String email);
	
}
