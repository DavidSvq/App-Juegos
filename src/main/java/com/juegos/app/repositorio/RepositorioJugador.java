/**
 * <h1>Paquete Repositorio</h1>
 * <p>Contiene las interfaces que permiten acceder y operar con los datos almacenados en la base de datos. 
 * Estas interfaces extienden de {@code JpaRepository} o {@code CrudRepository}, lo que proporciona 
 * operaciones CRUD básicas de forma automática.</p>
 * <p>Este paquete forma parte de <code>com.juegos.app</code>, el paquete principal del proyecto.</p>
 * 
 * <h1>ENGLISH</h1>
 * <h1>Repository Package</h1>
 * <p>Contains the interfaces used to access and operate on the data stored in the database. 
 * These interfaces extend from {@code JpaRepository} or {@code CrudRepository}, which 
 * provide basic CRUD operations by default.</p>
 * <p>This package is part of <code>com.juegos.app</code>, the main package of the project.</p>
 */
package com.juegos.app.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.app.modelo.Jugador;

/**
 * <h1>Interfaz RepositorioJugador</h1>
 * <p>Representa la interfaz para la entidad {@link Jugador}, extendiendo de {@link JpaRepository}.</p>
 * <p>Incluye métodos CRUD básicos proporcionados por Spring Data JPA, así como un par de métodos personalizados 
 * para realizar búsquedas por nombre o por email.</p>
 * 
 * <h1>ENGLISH</h1>
 * <h1>RepositorioJugador Interface</h1>
 * <p>Represents the repository interface for the {@link Jugador} entity, extending {@link JpaRepository}.</p>
 * <p>Includes basic CRUD methods provided by Spring Data JPA, along with a couple of custom query methods 
 * for searching by name or email.</p>
 * 
 * <p><strong>Author:</strong> David</p>
 * <p><strong>Version:</strong> 1.0</p>
 * <p><strong>Since:</strong> 2025</p>
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see com.juegos.app.modelo.Jugador
 */
public interface RepositorioJugador extends JpaRepository<Jugador, Long> {
	/**
	 * <p><strong>Busca jugadores por nombre</strong></p>
	 * <p>Devuelve una lista de jugadores cuyo nombre coincide exactamente con el valor proporcionado.</p>
	 * 
	 * @param nombre el nombre del jugador a buscar.
	 * @return devuelve una lista de los jugadores que coinciden con el nombre
	 * 
	 * <h1>ENGLISH</h1>
	 * <p><strong>Finds players by name</strong></p>
	 * <p>Returns a list of players whose name exactly matches the specified value.</p>
	 *
	 * @param nombre the name of the player to search for.
	 * @return a list of players that match the given name.
	 */
	List<Jugador> findByNombre(String nombre);
	
	/**
	 * <p><strong>Busca un jugador por correo electrónico</strong></p>
	 * <p>Devuelve un {@link Optional} que puede contener un jugador si existe uno con ese correo.
	 * Utiliza esta estructura para evitar errores si no se encuentra ningún resultado.</p>
	 * 
	 * @param email dirección de correo electrónico del jugador a buscar.
	 * @return Devuelve el jugador correspondiente al email, en caso de existir.
	 * 
	 * <h1>ENGLISH</h1>
	 * <p><strong>Finds a player by email address</strong></p>
	 * <p>Returns an {@link Optional} that may contain the player if one exists with the given email.
	 * This helps avoid null values when no player is found.</p>
	 *
	 * @param email the email address of the player to search for.
	 * @return the player matching the email, if present.
	 */
	Optional<Jugador> findByEmail(String email);
}
