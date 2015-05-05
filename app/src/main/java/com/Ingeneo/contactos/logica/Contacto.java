package com.Ingeneo.contactos.logica;

import android.provider.BaseColumns;

public class Contacto {
	
	private String id;
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
	private Boolean favorito;
	
	
	
	/**
	 * Constructor vacío.
	 */
	public Contacto() {
		super();
	}
	/**
	 * @param nombre
	 * @param telefono
	 * @param email
	 * @param direccion
	 */
	public Contacto(String nombre, String telefono, String email,
			String direccion, Boolean favorito) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.favorito = favorito;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}



	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	/**
	 * @return the favorito
	 */
	public Boolean getFavorito() {
		return favorito;
	}



	/**
	 * @param favorito the favorito to set
	 */
	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
