package com.restaurant.carmen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.carmen.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	//Crear lista Reseva
	
	List<Reserva> findAll();
	

}
