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

import com.juegos.app.modelo.Desarrolladora;
import com.juegos.app.modelo.DesarrolladoraJuego;
import com.juegos.app.modelo.Juego;
import com.juegos.app.servicio.DesarrolladoraJuegoService;

/**
 * 
 */
@RestController
@RequestMapping("/desarrolladorJuego")
public class DesarrolladoraJuegoController {

	private DesarrolladoraJuegoService dJService;

	/**
	 * @param dJService
	 */
	public DesarrolladoraJuegoController(DesarrolladoraJuegoService dJService) {
		this.dJService = dJService;
	}
	
	@GetMapping
	public ResponseEntity<List<DesarrolladoraJuego>> getAllGameDeveloper(){
		try {
			
			return ResponseEntity.ok(dJService.getAllGameDeveloper());
		}
		catch (RuntimeException e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<DesarrolladoraJuego> getGameDeveloperById(@PathVariable Long id){
		try {
			
			return ResponseEntity.ok(dJService.getGameDeveloperById(id));
		}
		catch (RuntimeException e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/juego/{juego}")
	public ResponseEntity<Optional<DesarrolladoraJuego>> getGameDeveloperByJuego(@RequestBody Juego juego){
		try {
			return ResponseEntity.ok(dJService.getGameDeveloperByJuego(juego));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/desarrolladora/{desarrolladora}")
	public ResponseEntity<Optional<DesarrolladoraJuego>> getGameDeveloperByDesarrolladora(@RequestBody Desarrolladora desarrolladora){
		try {
			return ResponseEntity.ok(dJService.getGameDeveloperByDesarrolladora(desarrolladora));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<DesarrolladoraJuego> insertNewGameDeveloper(@RequestBody DesarrolladoraJuego dJuego) {
		try {
			return ResponseEntity.ok(dJService.insertNewGameDeveloper(dJuego));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<DesarrolladoraJuego> updateGameDeveloper(@RequestBody DesarrolladoraJuego dJuego) {
		try {
			return ResponseEntity.ok(dJService.updateGameDeveloper(dJuego));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGameDeveloper(@PathVariable Long id) {
		try {
			dJService.deleteGameDeveloper(id);
			return ResponseEntity.noContent().build();
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
