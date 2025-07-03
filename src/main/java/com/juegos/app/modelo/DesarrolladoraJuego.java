/**
 * 
 */
package com.juegos.app.modelo;

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
	
	

}
