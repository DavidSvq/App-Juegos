/**
 * <h1>Package </h1>
 * <p>Contiene las clases necesarias para mapear las tablas de la base de datos.</p>
 * <p>Está incluido en el package <code>App</code>, que es el principal.</p>
 */
package com.juegos.app.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.app.modelo.Jugador;
import com.juegos.app.servicio.JugadorService;

/**
 * 
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {
	/**
	 * 
	 */
	private final JugadorService jugadorService;

	/**
	 * @param jugadorService
	 */
	@Autowired
	public JugadorController(JugadorService jugadorService) {
		this.jugadorService = jugadorService;
	}
	 /**
	  * 
	  * @return
	  */
	@GetMapping
	public List<Jugador> obtenerTodos(){
		return jugadorService.obtenerTodos();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id){
		try {
			Jugador jugador = jugadorService.obtenerPorId(id);
			return ResponseEntity.ok(jugador);
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * 
	 * @param jugador
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Jugador> crear(@RequestBody Jugador jugador){
		Jugador nuevoJugador = jugadorService.crearJugador(jugador);
		return ResponseEntity.ok(nuevoJugador);
	}
	
	/**
	 * 
	 * @param id
	 * @param jugador
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Jugador> actualizar (@PathVariable Long id, @RequestBody Jugador jugador){
		try {
			Jugador jugadorAux = jugadorService.obtenerPorId(id);
			jugadorAux.setNombre(jugador.getNombre());
			jugadorAux.setEmail(jugador.getEmail());
			
			Jugador jugadorGuardado = jugadorService.modificarDatosJugador(jugadorAux);
			
			return ResponseEntity.ok(jugadorGuardado);
		} catch (RuntimeException e) {
			 return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable Long id){
		try {
			jugadorService.eliminarJugador(id);
			return ResponseEntity.noContent().build();
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
