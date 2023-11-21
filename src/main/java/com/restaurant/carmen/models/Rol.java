package com.restaurant.carmen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

//Crear tabla llamada rol.
@Entity
@Table(name = "rol")
public class Rol {
	
	//Datos que tendra la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	public Long getId() {
		return id;
	}
	
	//Getters and Setters and Constructors
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Rol() {
		super();
	}
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	

}
