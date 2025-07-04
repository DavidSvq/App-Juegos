/**
 * 
 */
package com.juegos.app.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.app.modelo.Desarrolladora;
import com.juegos.app.modelo.DesarrolladoraJuego;
import com.juegos.app.modelo.Juego;

/**
 * 
 */
public interface RepositorioDesarrolladoraJuego extends JpaRepository<DesarrolladoraJuego, Long> {
	
	Optional<DesarrolladoraJuego> findByJuego(Juego juego);
	
	Optional<DesarrolladoraJuego> findByDesarrolladora(Desarrolladora desarrolladora);
}
