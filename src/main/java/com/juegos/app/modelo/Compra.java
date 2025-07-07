/**
 * 
 */
package com.juegos.app.modelo;

import java.time.LocalDateTime;
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
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;
	
	
	private LocalDateTime fechaCompra;


	/**
	 * 
	 */
	public Compra() {
	}


	/**
	 * @param jugador
	 * @param juego
	 * @param fechaCompra
	 */
	public Compra(Jugador jugador, Juego juego, LocalDateTime fechaCompra) {
		this.jugador = jugador;
		this.juego = juego;
		this.fechaCompra = fechaCompra;
	}


	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}


	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
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
	 * @return the fechaCompra
	 */
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}


	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Compra [id=" + id + ", jugador=" + jugador + ", juego=" + juego + ", fechaCompra=" + fechaCompra + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(juego, jugador);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(juego, other.juego) && Objects.equals(jugador, other.jugador);
	}
	
	
	
	
}
