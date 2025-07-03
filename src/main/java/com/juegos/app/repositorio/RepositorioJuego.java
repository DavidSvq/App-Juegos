/**
 * 
 */
package com.juegos.app.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.app.modelo.Juego;

/**
 * 
 */
public interface RepositorioJuego extends JpaRepository<Juego, Long> {

	Optional<Juego> findByTitulo(String titulo);
	
	List<Juego> findByGenero(String genero);
	
	List<Juego> findByPlataforma(String plataforma);
}
