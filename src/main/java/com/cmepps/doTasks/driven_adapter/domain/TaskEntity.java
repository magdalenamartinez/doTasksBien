package com.cmepps.doTasks.driven_adapter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmepps.doTasks.core.domain.Task;



@Entity

public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "duracion")
	private String duracion;
	
	@Column(name = "prioridad")
	private String prioridad;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_limite")
	private Date fechaLimite;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	/*
	 * Son metodos para cambiar de TaskEntity a Task
	 * y de Task a TaskEntity
	 * */
	
	//PASA TASK A TASK ENTITY	
	public TaskEntity(Long id, String nombre, String duracion, String prioridad, String categoria,
			Date fechaLimite, boolean isCompleted) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.fechaLimite = fechaLimite;
		this.isCompleted = isCompleted;
		
	}

	//Pasar de TaskEntity a Task
	public Task toTask(){
	return new Task(this.id, this.nombre, this.duracion, this.prioridad, this.categoria,
			this.fechaLimite, this.isCompleted);   
	}
	
	//Pasar de Task a TaskEntity
	public static TaskEntity fromTask(Task task)
	{
		return new TaskEntity(task.getId(), task.getNombre(), task.getDuracion(), task.getPrioridad(),
				task.getCategoria(), task.getFechaLimite(), task.isCompleted());
	}
}
