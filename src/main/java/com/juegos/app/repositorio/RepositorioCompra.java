/**
 * 
 */
package com.juegos.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juegos.app.modelo.Compra;
import com.juegos.app.modelo.Juego;
import com.juegos.app.modelo.Jugador;

import java.util.List;
import java.time.LocalDateTime;



/**
 * 
 */
public interface RepositorioCompra extends JpaRepository<Compra, Long> {

	List<Compra> findByJuego(Juego juego);
	
	List<Compra> findByJugador(Jugador jugador);
	
	List<Compra> findByFechaCompra(LocalDateTime fechaCompra);
}
