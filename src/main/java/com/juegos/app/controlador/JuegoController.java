/**
 * 
 */
package com.juegos.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.app.modelo.Juego;
import com.juegos.app.servicio.JuegoService;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
 */
@RestController
@RequestMapping("/juego")
public class JuegoController {
	
	private JuegoService jService;

	/**
	 * @param jService
	 */
	public JuegoController(JuegoService jService) {
		this.jService = jService;
	}
	
	@GetMapping
	public ResponseEntity<List<Juego>> getAllGames(){
		try {
			return ResponseEntity.ok(jService.getAllGames());
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Juego> getGameById(@PathVariable Long id) {
		try {
			Juego juego = jService.getGameById(id);
			return ResponseEntity.ok(juego);
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Juego> getGameByTitle (@PathVariable String titulo){
		try {
			Optional<Juego> j = jService.getGameByTitle(titulo);
			if(j.isPresent()) {
				return ResponseEntity.ok(j.get());
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Juego>> getGameByGenre(@PathVariable String genero) {
		try {
			return ResponseEntity.ok(jService.getGameByGenre(genero));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/plataforma/{plataforma}")
	public ResponseEntity<List<Juego>> getGameByPlatform(@PathVariable String plataforma) {
		try {
			return ResponseEntity.ok(jService.getGameByPlatform(plataforma));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Juego> addNewGame (@RequestBody Juego j){
		try {
			return ResponseEntity.ok(jService.addNewGame(j));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Juego> updateGame(@RequestBody Juego j) {
		try {
			return ResponseEntity.ok(jService.updateGame(j));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGame (@PathVariable Long id){
		try {
			jService.deleteGameById(id);
			return ResponseEntity.noContent().build();
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
