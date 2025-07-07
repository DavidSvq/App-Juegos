/**
 * 
 */
package com.juegos.app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.juegos.app.modelo.Desarrolladora;
import com.juegos.app.modelo.DesarrolladoraJuego;
import com.juegos.app.modelo.Juego;
import com.juegos.app.repositorio.RepositorioDesarrolladoraJuego;

/**
 * 
 */
@Service
public class DesarrolladoraJuegoService {

	private RepositorioDesarrolladoraJuego rDesaJuego;

	/**
	 * @param rDesaJuego
	 */
	public DesarrolladoraJuegoService(RepositorioDesarrolladoraJuego rDesaJuego) {
		this.rDesaJuego = rDesaJuego;
	}
	
	public List<DesarrolladoraJuego> getAllGameDeveloper(){
		return rDesaJuego.findAll(); 
	}
	
	public DesarrolladoraJuego getGameDeveloperById(Long id){
		return rDesaJuego.findById(id).orElseThrow(() -> new RuntimeException("Error al buscar por Id."));
	}
	
	public Optional<DesarrolladoraJuego> getGameDeveloperByJuego(Juego juego){
		return rDesaJuego.findByJuego(juego);
	}
	
	public Optional<DesarrolladoraJuego> getGameDeveloperByDesarrolladora(Desarrolladora desarrolladora){
		return rDesaJuego.findByDesarrolladora(desarrolladora);
	}
	
	public DesarrolladoraJuego insertNewGameDeveloper(DesarrolladoraJuego dJuego) {
		if(dJuego.getId() != null) {
			throw new RuntimeException("Error al insertar desarrolladora juego");
		}
		return rDesaJuego.save(dJuego);
	}
	
	public DesarrolladoraJuego updateGameDeveloper(DesarrolladoraJuego dJuego) {
		if(dJuego.getId() == null || !rDesaJuego.existsById(dJuego.getId())) {
			throw new RuntimeException("Error al actualizar desarrolladora juego.");
		}
		
		return rDesaJuego.save(dJuego);
	}
	
	public void deleteGameDeveloper(Long id) {
		if(!rDesaJuego.existsById(id)) {
			throw new RuntimeException("Error usuario a eliminar no encontrado.");
		}
		
		rDesaJuego.deleteById(id);
	}
}
