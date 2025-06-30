/**
 * 
 */
package com.juegos.app.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.app.modelo.Desarrolladora;

/**
 * 
 */
public interface RepositorioDesarrolladora extends JpaRepository<Desarrolladora, Long> {
	
	Optional<Desarrolladora> findByNombre(String nombre);
	
	List<Desarrolladora> findByPais(String pais);
}
