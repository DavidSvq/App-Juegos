/**
 * 
 */
package com.juegos.app.servicio;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.juegos.app.modelo.Juego;
import com.juegos.app.repositorio.RepositorioJuego;

/**
 * 
 */
@Service
public class JuegoService {

	private final RepositorioJuego repoJuego;

	/**
	 * @param repoJuego
	 */
	public JuegoService(RepositorioJuego repoJuego) {
		this.repoJuego = repoJuego;
	}
	
	public List<Juego> getAllGames (){
		return repoJuego.findAll();
	}
	
	public Juego getGameById(Long id) {
		return repoJuego.findById(id).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
	}
	
	public Optional<Juego> getGameByTitle (String titulo){
		return repoJuego.findByTitulo(titulo);
	}
	
	public List<Juego> getGameByGenre (String genero){
		return repoJuego.findByGenero(genero);
	}
	
	public List<Juego> getGameByPlatform(String plataforma){
		return repoJuego.findByPlataforma(plataforma);
	}
	
	public Juego addNewGame (Juego j) {
		if(j.getId() != null) {
			throw new RuntimeException("El juego ya existe.");
		}
		return repoJuego.save(j);
	}
	
	public Juego updateGame(Juego j) {
		if(j.getId() == null || !repoJuego.existsById(j.getId())) {
			throw new RuntimeException("El juego no existe.");
		}
		return repoJuego.save(j);
	}
	
	public void deleteGameById(Long id){
		if(!repoJuego.existsById(id)) {
			throw new RuntimeException("Error, el juego no existe.");
		}
		repoJuego.deleteById(id);
	}
}
