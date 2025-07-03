package com.juegos.app.controlador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.juegos.app.modelo.Jugador;
import com.juegos.app.servicio.JugadorService;

@ExtendWith(MockitoExtension.class)
class JugadorControllerTest {

	@Mock
	private JugadorService jS;
	
	@InjectMocks
	private JugadorController jC;
	
	private List<Jugador> jugadores;
	//private ResponseEntity<List<Jugador>> resultado;
	
	@BeforeEach
	void setUp() throws Exception {
		//resultado = new ArrayList<>();
		jugadores =List.of(
				new Jugador("David", "dav@hot.and"),
				new Jugador("Maria", "maria@hot.es")
					);
	}

	@Test
	final void testObtenerTodos_deberiaDevolverDosJugadores() {
		
		when(jS.obtenerTodos()).thenReturn(jugadores);
		
		ResponseEntity<List<Jugador>> respuesta = jC.obtenerTodos();
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
		assertEquals(jugadores, respuesta.getBody());
		
		verify(jS, times(1)).obtenerTodos();
	}

	@Test
	final void testObtenerTodos_deberiaDevolverListaVacia() {
		
		when(jS.obtenerTodos()).thenReturn(Collections.emptyList());
		
		ResponseEntity<List<Jugador>> respuesta = jC.obtenerTodos();
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
		verify(jS, times(1)).obtenerTodos();
	}
	
	@Test
	final void testObtenerTodos_deberiaLanzarExcepcionCuandoServiceFalla() {
		
		when (jS.obtenerTodos()).thenThrow(new RuntimeException("Error en el Servicio"));
		
		ResponseEntity<List<Jugador>> respuesta = jC.obtenerTodos();
		
		assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
		assertNull(respuesta.getBody());
		
		
		verify(jS, times(1)).obtenerTodos();
	}
	
	@Test
	final void testObtenerPorId_deberiaDevolverElJugadorDelIdCorrespondiente() {
		
		Long id = 1L;
		Jugador ju = new Jugador("David", "dav@hot.and");
		
		when(jS.obtenerPorId(id)).thenReturn(ju);
		
		ResponseEntity<Jugador> respuesta = jC.obtenerPorId(id);
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
		assertEquals(ju, respuesta.getBody());
		
		verify(jS, times(1)).obtenerPorId(id);
	}

	@Test
	final void testObtenerPorId_deberiaDevolverMensajeError() {
		Long id = 1L;
		
		when(jS.obtenerPorId(id)).thenThrow(new RuntimeException("Jugador no existe"));
		
		ResponseEntity<Jugador> respuesta = jC.obtenerPorId(id);
		
		assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
		assertNull(respuesta.getBody());
		
		verify(jS, times(1)).obtenerPorId(id);
	}
	
	@Test
	final void testCrear_deberiaDevolverUnMensajeOkYNuevoJugadorCreado() {
		
		Jugador ju = new Jugador("Lola", "olaLola@ola.hola");
		
		when(jS.crearJugador(ju)).thenReturn(ju);
		
		ResponseEntity<Jugador> respuesta = jC.crear(ju);
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(ju, respuesta.getBody());
		
		verify(jS, times(1)).crearJugador(ju);
	}

	@Test
	final void testCrear_deberiaLanzarNotFoundAlNoInsertarAlJugadorCorrectamente() {
		
		Jugador ju = new Jugador("Lola", "olaLola@ola.hola");
		
		when(jS.crearJugador(ju)).thenThrow(new RuntimeException("Jugador no insertado"));
		
		ResponseEntity<Jugador> respuesta = jC.crear(ju);
		assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
		assertNull(respuesta.getBody());
		
		verify(jS, times(1)).crearJugador(ju);
	}
	
	@Test
	final void testActualizar_nombreDeberiaDevolverMensajeOkYJugadorActualizado() {
		Long id = 2L;
		Jugador ju = new Jugador("Maria", "maria@hot.es");
		
		when(jS.obtenerPorId(id)).thenReturn(ju);
		
		ju.setNombre("Juana");
		
		when(jS.modificarDatosJugador(ju)).thenReturn(ju);
		
		ResponseEntity<Jugador> respuesta = jC.actualizar(id, ju);
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(ju, respuesta.getBody());
		
		verify(jS, times(1)).modificarDatosJugador(ju);
	}
	
	@Test
	final void testActualizar_emailDeberiaDevolverMensajeOkYJugadorActualizado() {
		Long id = 2L;
		Jugador ju = new Jugador("Maria", "maria@hot.es");
		
		when(jS.obtenerPorId(id)).thenReturn(ju);
		
		ju.setEmail("jAna@hot.es");
		
		when(jS.modificarDatosJugador(ju)).thenReturn(ju);
		
		ResponseEntity<Jugador> respuesta = jC.actualizar(id, ju);
		
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(ju, respuesta.getBody());
		
		verify(jS, times(1)).modificarDatosJugador(ju);
	}

	@Test
	final void testActualizar_deberiaMostrarMensajeErrorNoFount() {
		Long id = 2L;
		Jugador ju = new Jugador("Maria", "maria@hot.es");
		
		when(jS.obtenerPorId(id)).thenReturn(ju);
		
		ju.setEmail("jAna@hot.es");
		
		when(jS.modificarDatosJugador(ju)).thenThrow(new RuntimeException());
		
		ResponseEntity<Jugador> respuesta = jC.actualizar(id, ju);
		
		assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
		assertNull(respuesta.getBody());
		
		verify(jS,times(1)).modificarDatosJugador(ju);
	}
	@Test
	final void testEliminar_deberiaDevolverMensajeDeEliminacionCorrecta() {
		Long id = 3L;
		
		doNothing().when(jS).eliminarJugador(id);
		
		ResponseEntity<Void> respuesta = jC.eliminar(id);
		
		assertEquals(HttpStatus.NO_CONTENT, respuesta.getStatusCode());
		
		verify(jS, times(1)).eliminarJugador(id);
	}

	@Test
	final void testEliminar_deberiaDevolverNotFoundSiNoExisteJugador() {
		Long id = 4L;
		
		doThrow(new RuntimeException()).when(jS).eliminarJugador(id);
		
		ResponseEntity<Void> respuesta = jC.eliminar(id);
		
		assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
		
		verify(jS, times(1)).eliminarJugador(id);
		
	}
}
