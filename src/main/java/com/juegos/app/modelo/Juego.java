/**
 * 
 */
package com.juegos.app.modelo;

import java.time.LocalDate;
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
@Table(name = "juegos")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String genero;
	private String plataforma;
	private LocalDate fechaLanzamiento;
	private double calificacion;
	private String descripcion;
	/**
	 * 
	 */
	public Juego() {

	}
	/**
	 * @param titulo
	 * @param genero
	 * @param plataforma
	 * @param fechaLanzamiento
	 * @param calificacion
	 * @param descripcion
	 */
	public Juego(String titulo, String genero, String plataforma, LocalDate fechaLanzamiento, double calificacion,
			String descripcion) {
		this.titulo = titulo;
		this.genero = genero;
		this.plataforma = plataforma;
		this.fechaLanzamiento = fechaLanzamiento;
		this.calificacion = calificacion;
		this.descripcion = descripcion;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}
	/**
	 * @param plataforma the plataforma to set
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	/**
	 * @return the fechaLanzamiento
	 */
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	/**
	 * @param fechaLanzamiento the fechaLanzamiento to set
	 */
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	/**
	 * @return the calificacion
	 */
	public double getCalificacion() {
		return calificacion;
	}
	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Juego [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", plataforma=" + plataforma
				+ ", fechaLanzamiento=" + fechaLanzamiento + ", calificacion=" + calificacion + ", descripcion="
				+ descripcion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(genero, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(titulo, other.titulo);
	}
	
	
	
}
