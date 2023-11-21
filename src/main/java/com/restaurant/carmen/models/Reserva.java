package com.restaurant.carmen.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

//Crear tabla llamada "reserva"
@Entity
@Table(name = "reserva")
public class Reserva {
	
	// Datos que tendra la tabla reserva
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    private int cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    //Getters and Setters and Constructors

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reserva(Long id, LocalDate fecha, LocalTime hora, int cantidadPersonas, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadPersonas = cantidadPersonas;
		this.usuario = usuario;
	}

	public Reserva(Long id) {
		super();
		this.id = id;
	}

	public Reserva(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Reserva(Long id, LocalDate fecha, LocalTime hora, int cantidadPersonas) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadPersonas = cantidadPersonas;
	}

	public Reserva(LocalDate fecha, LocalTime hora, int cantidadPersonas, Usuario usuario) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadPersonas = cantidadPersonas;
		this.usuario = usuario;
	}

	public Reserva() {
		super();
	}
	
    
    

}
