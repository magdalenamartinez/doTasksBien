package com.cmepps.doTasks.core.domain;

import java.util.Date;

public class Task {
	/*
	 * Entidad del Dominio -> representa un modelo de negocio dentro de
	 * la aplicacion
	 * Se utiliza en el dominio y en servicio		
	*/
	private Long id;
	
	private String nombre;
	private String duracion;
	private String prioridad;
	private String categoria;
	private Date fechaLimite;
	private boolean isCompleted;
	
	
	
	public Task(Long id, String nombre, String duracion, String prioridad,
			String categoria, Date fechaLimite, boolean isCompleted) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.fechaLimite = fechaLimite;
		this.isCompleted = isCompleted;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDuracion() {
		return duracion;
	}
	
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public String getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Date getFechaLimite() {
		return fechaLimite;
	}
	
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
}