/**
 * <h1>Paquete Servicio</h>
 */
package com.juegos.app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.app.modelo.Jugador;
import com.juegos.app.repositorio.RepositorioJugador;

/**
 * 
 */
@Service
public class JugadorService {
	/**
	 * 
	 */
	private final RepositorioJugador repositorioJugador;
	
	/**
	 * 
	 * @param repositorioJugador
	 */
	@Autowired
	public JugadorService(RepositorioJugador repositorioJugador) {
		this.repositorioJugador = repositorioJugador;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Jugador> obtenerTodos(){
		return repositorioJugador.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Jugador obtenerPorId(Long id) {
		return repositorioJugador.findById(id).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public List<Jugador> obtenerPorNombre(String nombre) {
		return repositorioJugador.findByNombre(nombre);
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public Optional<Jugador> obtenerPorEmail(String email) {
		return repositorioJugador.findByEmail(email);
	}
	
	/**
	 * 
	 * @param jugador
	 * @return
	 */
	public Jugador crearJugador(Jugador jugador) {
		if(jugador.getId() != null && repositorioJugador.existsById(jugador.getId())) {
			throw new RuntimeException("El jugador ya existe");
		}
		return repositorioJugador.save(jugador);
	}
	
	/**
	 * 
	 * @param jugador
	 * @return
	 */
	public Jugador modificarDatosJugador(Jugador jugador) {
		if(jugador.getId() == null || !repositorioJugador.existsById(jugador.getId())) {
			throw new RuntimeException("El estudiante no existe");
		}
		return repositorioJugador.save(jugador);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void eliminarJugador(Long id) {
		if(!repositorioJugador.existsById(id)) {
			throw new RuntimeException("Jugador no encontrado");
		}
		repositorioJugador.deleteById(id);
	}
}
