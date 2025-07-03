/**
 * <h1>Paquete Controlador</h1>
 * <p>Contiene los métodos REST que permiten la comunicación mediante peticiones HTTP.</p>
 * <p>Está incluido en el paquete principal <code>App</code>.</p>
 * 
 * <h1>ENGLISH</h1>
 * <h1>Controller Package</h1>
 * <p>Contains the REST methods that enable communication via HTTP requests.</p>
 * <p>Included in the main package <code>App</code>.</p>
 */
package com.juegos.app.controlador;

import java.util.List;
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
 * <h1>Clase JugadorController</h1>
 * <p>Controlador REST que gestiona las operaciones HTTP relacionadas con la entidad <code>Jugador</code>.</p>
 * <p>Define los endpoints para crear, obtener, actualizar y eliminar jugadores.</p>
 * <p>Se mapea bajo la ruta base <code>/jugadores</code>.</p>
 * 
 * <h2>Anotaciones de Spring</h2>
 * <ul>
 *   <li><code>@RestController</code> indica que la clase es un controlador REST y sus métodos devuelven respuestas JSON automáticamente.</li>
 *   <li><code>@RequestMapping</code> define la ruta base para los endpoints de esta clase.</li>
 *   <li><code>@Autowired</code> permite la inyección automática de dependencias.</li>
 * </ul>
 * 
 * <h1>ENGLISH</h1>
 * <h1>JugadorController Class</h1>
 * <p>REST controller that manages HTTP operations related to the <code>Jugador</code> entity.</p>
 * <p>Defines endpoints to create, retrieve, update, and delete players.</p>
 * <p>Mapped under the base path <code>/jugadores</code>.</p>
 * 
 * <h2>Spring Annotations</h2>
 * <ul>
 *   <li><code>@RestController</code> marks the class as a REST controller where methods return JSON responses automatically.</li>
 *   <li><code>@RequestMapping</code> sets the base route for this controller’s endpoints.</li>
 *   <li><code>@Autowired</code> enables automatic dependency injection.</li>
 * </ul>
 * 
 * <p><strong>Author:</strong> David</p>
 * <p><strong>Version:</strong> 1.0</p>
 * <p><strong>Since:</strong> 2025</p>
 * 
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {
	/**
	 * <h1>Atributo jugadorService</h1>
	 * <p>Tipo: <code>JugadorService</code>. Servicio que contiene la lógica de negocio para gestionar jugadores.</p>
	 * <p>Se utiliza para invocar los métodos que interactúan con la capa de datos y realizar operaciones CRUD.</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>jugadorService Attribute</h1>
	 * <p>Type: <code>JugadorService</code>. Service that contains the business logic to manage players.</p>
	 * <p>Used to invoke methods that interact with the data layer and perform CRUD operations.</p>
	 */
	private final JugadorService jugadorService;

	/**
	 * <h1>Constructor de JugadorController</h1>
	 * <p>Inyecta el servicio <code>JugadorService</code> en el controlador para poder usar sus métodos.</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>JugadorController Constructor</h1>
	 * <p>Injects the <code>JugadorService</code> service into the controller to use its methods.</p>
	 * 
	 * @param jugadorService instancia del servicio <code>JugadorService</code> gestionada por Spring.
	 */
	public JugadorController(JugadorService jugadorService) {
		this.jugadorService = jugadorService;
	}
	 /**
	  *<h1>Obtener todos los jugadores</h1>
	 * <p>Responde a peticiones GET a la ruta base <code>/jugadores</code>.</p>
	 * <p>Recupera una lista con todos los jugadores almacenados en la base de datos.</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>Get all players</h1>
	 * <p>Handles GET requests to the base path <code>/jugadores</code>.</p>
	 * <p>Retrieves a list of all players stored in the database.</p>
	 * 
	 * @return lista de objetos <code>Jugador</code> con todos los jugadores.
	 * @return list of <code>Jugador</code> objects with all players.
	  */
	@GetMapping
	public ResponseEntity<List<Jugador>> obtenerTodos(){
		try {
			return ResponseEntity.ok(jugadorService.obtenerTodos());
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 *<h1>Obtener jugador por ID</h1>
	 * <p>Responde a peticiones GET a la ruta <code>/jugadores/{id}</code>.</p>
	 * <p>Busca un jugador según su identificador único.</p>
	 * <p>Si se encuentra, devuelve el jugador con código HTTP 200 (OK).</p>
	 * <p>Si no se encuentra, captura la excepción y devuelve HTTP 404 (Not Found).</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>Get player by ID</h1>
	 * <p>Handles GET requests to the path <code>/jugadores/{id}</code>.</p>
	 * <p>Searches for a player by their unique identifier.</p>
	 * <p>If found, returns the player with HTTP status 200 (OK).</p>
	 * <p>If not found, catches the exception and returns HTTP status 404 (Not Found).</p>
	 * 
	 * @param id identificador único del jugador a buscar.
	 * @param id unique identifier of the player to find.
	 * @return ResponseEntity con el jugador encontrado y código 200, o código 404 si no se encuentra.
	 * @return ResponseEntity with the found player and status 200, or status 404 if not found.
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
	 * <h1>Crear un nuevo jugador</h1>
	 * <p>Responde a peticiones POST a la ruta <code>/jugadores</code>.</p>
	 * <p>Recibe un objeto <code>Jugador</code> en el cuerpo de la petición para ser guardado en la base de datos.</p>
	 * <p>Devuelve el jugador creado con código HTTP 200 (OK).</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>Create a new player</h1>
	 * <p>Handles POST requests to the path <code>/jugadores</code>.</p>
	 * <p>Receives a <code>Jugador</code> object in the request body to be saved in the database.</p>
	 * <p>Returns the created player with HTTP status 200 (OK).</p>
	 * 
	 * @param jugador el jugador a crear, enviado en el cuerpo de la petición.
	 * @param jugador the player to create, sent in the request body.
	 * @return ResponseEntity con el jugador creado y código 200.
	 * @return ResponseEntity with the created player and status 200.
	 */
	@PostMapping
	public ResponseEntity<Jugador> crear(@RequestBody Jugador jugador){
		try {
			return ResponseEntity.ok(jugadorService.crearJugador(jugador));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * <h1>Actualizar un jugador existente</h1>
	 * <p>Responde a peticiones PUT a la ruta <code>/jugadores/{id}</code>.</p>
	 * <p>Actualiza los datos del jugador identificado por <code>id</code> con la información proporcionada en el cuerpo de la petición.</p>
	 * <p>Si el jugador existe, devuelve el jugador actualizado con código HTTP 200 (OK).</p>
	 * <p>Si no existe, devuelve código HTTP 404 (Not Found).</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>Update an existing player</h1>
	 * <p>Handles PUT requests to the path <code>/jugadores/{id}</code>.</p>
	 * <p>Updates the player identified by <code>id</code> with the data provided in the request body.</p>
	 * <p>If the player exists, returns the updated player with HTTP status 200 (OK).</p>
	 * <p>If the player does not exist, returns HTTP status 404 (Not Found).</p>
	 * 
	 * @param id identificador único del jugador a actualizar.
	 * @param jugador objeto con los datos para actualizar.
	 * @return ResponseEntity con el jugador actualizado y código 200, o código 404 si no se encontró el jugador.
	 * @return ResponseEntity with the updated player and status 200, or status 404 if the player was not found.
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
	 * <h1>Eliminar un jugador por ID</h1>
	 * <p>Responde a peticiones DELETE a la ruta <code>/jugadores/{id}</code>.</p>
	 * <p>Elimina el jugador identificado por el <code>id</code> especificado.</p>
	 * <p>Si la eliminación es exitosa, devuelve código HTTP 204 (No Content).</p>
	 * <p>Si no se encuentra el jugador, devuelve código HTTP 404 (Not Found).</p>
	 * 
	 * <h1>ENGLISH</h1>
	 * <h1>Delete a player by ID</h1>
	 * <p>Handles DELETE requests to the path <code>/jugadores/{id}</code>.</p>
	 * <p>Deletes the player identified by the specified <code>id</code>.</p>
	 * <p>If deletion is successful, returns HTTP status 204 (No Content).</p>
	 * <p>If the player is not found, returns HTTP status 404 (Not Found).</p>
	 * 
	 * @param id identificador único del jugador a eliminar.
	 * @return ResponseEntity sin contenido con código 204, o código 404 si el jugador no se encuentra.
	 * @return ResponseEntity with no content and status 204, or status 404 if the player is not found.
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
