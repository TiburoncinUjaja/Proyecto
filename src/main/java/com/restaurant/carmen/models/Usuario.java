package com.restaurant.carmen.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

//Crear tabla llamada usuario
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class Usuario {
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
	
	//Relacion con la lista llamada Reserva
	
	public Usuario(List<Reserva> reservas) {
		super();
		this.reservas = reservas;
	}
	public Usuario(List<Reserva> reservas, String nombre) {
		super();
		this.reservas = reservas;
		this.nombre = nombre;
	}
	public Usuario(List<Reserva> reservas, Long id, String nombre) {
		super();
		this.reservas = reservas;
		this.id = id;
		this.nombre = nombre;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	//Sleccion de ID y Datos a solicitar al usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(
					name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	
	//Relacion entre id rol
	
	private Collection<Rol> roles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
	public Usuario(Long id, String nombre, String email, String password, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public Usuario(String nombre, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public Usuario() {
		super();
	}
	
	

}
