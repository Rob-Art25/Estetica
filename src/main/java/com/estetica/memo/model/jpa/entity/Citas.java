package com.estetica.memo.model.jpa.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "citas")
public class Citas implements Serializable
{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private Long id;
	
	@NotEmpty
	private String nombre;
	private String appaterno;
	private String apmaterno;
	private String correo;	
		
	@DateTimeFormat(pattern="dd-mm-yyyy")
	@Column(name = "fecha_registro")	
	private Date fechaRegistro;
	
	
	
	public Citas() 
	{
		
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getAppaterno() {
		return appaterno;
	}



	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}



	public String getApmaterno() {
		return apmaterno;
	}



	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	@Override
	public String toString() {
		return "Citas [id=" + id + ", fechaRegistro=" + fechaRegistro + "]";
	}



	private static final long serialVersionUID = -8210968022954417028L;
}
