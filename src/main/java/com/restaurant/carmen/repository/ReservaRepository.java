package com.restaurant.carmen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.carmen.models.Reserva;

/**
 * Repositorio de datos para la entidad Reserva.
 */

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	/**
     * Obtiene una lista de todas las reservas.
     *
     * @return La lista de todas las reservas.
     */
	
	List<Reserva> findAll();
	

}
