/**
 * 
 */
package com.juegos.app.modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="desarroladores_juegos")
public class DesarrolladoraJuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;
	
	@ManyToOne
	@JoinColumn(name="id_desarrolladora")
	private Desarrolladora desarrolladora;

	/**
	 * 
	 */
	public DesarrolladoraJuego() {
	}

	/**
	 * @param juego
	 * @param desarrolladora
	 */
	public DesarrolladoraJuego(Juego juego, Desarrolladora desarrolladora) {
		this.juego = juego;
		this.desarrolladora = desarrolladora;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @return the desarrolladora
	 */
	public Desarrolladora getDesarrolladora() {
		return desarrolladora;
	}

	/**
	 * @param desarrolladora the desarrolladora to set
	 */
	public void setDesarrolladora(Desarrolladora desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DesarrolladoraJuego [id=" + id + ", juego=" + juego + ", desarrolladora=" + desarrolladora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(desarrolladora, juego);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DesarrolladoraJuego other = (DesarrolladoraJuego) obj;
		return Objects.equals(desarrolladora, other.desarrolladora) && Objects.equals(juego, other.juego);
	}
	
	

}
