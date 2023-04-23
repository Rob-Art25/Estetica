package com.estetica.memo.model.jpa.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*Serializable proceso de convertir un objeto, todos sus valores en una secuencia de bytes
 * para almacenarlo o transmitirlo a memoria, a una base de datos, enviarlo por 
 * http
 */
//table->name es el nombre de la tabla en nuestra bd

@Entity
@Table(name = "usuarios")
public class User implements Serializable
{	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@NotEmpty
	private String nombre;
	private String appaterno;
	private String apmaterno;
	
	@Column(nullable = false)
	private String correo;
	private Integer telefono;
	
	public User() 
	{
		
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", appaterno=" + appaterno + ", apmaterno=" + apmaterno
				+ ", correo=" + correo + ", telefono=" + telefono + "]";
	}



	private static final long serialVersionUID = -1818553987492828085L;	
	
}
