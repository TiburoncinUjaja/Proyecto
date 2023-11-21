package com.restaurant.carmen.dto;

/**
 * DTO (Data Transfer Object) para la información de registro de usuario.
 */

public class UsuarioRegistroDTO {
	
	//Datos a pedir al usuarios

	private Long id;

	private String nombre;
	private String email;
	private String password;
	
    // Getter y Setter para el campo ID


	public Long getId() {
		return id;
	}
	
    // Getters y Setters para los demás campos

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
	
    // Constructores


	public UsuarioRegistroDTO(Long id, String nombre, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public UsuarioRegistroDTO() {
		super();
	}

}
