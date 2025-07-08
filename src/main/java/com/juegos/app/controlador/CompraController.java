/**
 * 
 */
package com.juegos.app.controlador;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.app.modelo.Compra;
import com.juegos.app.modelo.Juego;
import com.juegos.app.modelo.Jugador;
import com.juegos.app.servicio.CompraService;


/**
 * 
 */
@RestController
@RequestMapping("/compra")
public class CompraController {
	
	private CompraService cService;

	/**
	 * @param cServive
	 */
	public CompraController(CompraService cService) {
		this.cService = cService;
	}
	
	@GetMapping
	public ResponseEntity<List<Compra>> getAllBuys(){
		try {
			return ResponseEntity.ok(cService.getAllBuys());
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Compra> getBuyById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(cService.getBuyById(id));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/juego")
	public ResponseEntity<List<Compra>> getByJuego(@RequestBody Juego juego) {
		try {
			return ResponseEntity.ok(cService.getByJuego(juego));
					
		}
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/jugador")
	public ResponseEntity<List<Compra>> getByJugador(@RequestBody Jugador jugador){
		try {
			return ResponseEntity.ok(cService.getByJugador(jugador));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/fCompra/{fechaCompra}")
	public ResponseEntity<List<Compra>> getByFechaCompra (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime fechaCompra){
		try {
			return ResponseEntity.ok(cService.getByFechaCompra(fechaCompra));
		}
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Compra> addBuy(@RequestBody Compra compra){
		try {
			return ResponseEntity.ok(cService.addBuy(compra));
		}
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Compra> updateBuy(@RequestBody Compra compra){
		try {
			return ResponseEntity.ok(cService.updateBuy(compra));
		}
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBuyById(@PathVariable Long id) {
		try {
			cService.deleteBuyById(id);
			return ResponseEntity.noContent().build();
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
