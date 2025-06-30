/**
 * 
 */
package com.juegos.app.modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "desarrolladoras")
public class Desarrolladora {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 
	 */
	private String nombre;
	
	/**
	 * 
	 */
	private String pais;
	/**
	 * 
	 */
	public Desarrolladora() {
	
	}
	/**
	 * @param nombre
	 * @param pais
	 */
	public Desarrolladora(String nombre, String pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
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
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the _id
	 */
	public Long get_id() {
		return id;
	}
	@Override
	public String toString() {
		return "Desarrolladora [ID: " + id + " #Nombre: " + nombre + " #País=" + pais + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, pais);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desarrolladora other = (Desarrolladora) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(pais, other.pais);
	}
	
	
	

}
