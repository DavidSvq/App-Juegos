package com.juegos.app.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juegos.app.modelo.Jugador;
import com.juegos.app.repositorio.RepositorioJugador;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {
	
	@Mock
	private RepositorioJugador repoJugadorMock;
	
	@InjectMocks
	private JugadorService service;
	
	private Jugador ju;
	private List<Jugador> jugadores = new ArrayList<>();
	private List<Jugador> listaVaciaJugadores;
	private List<Jugador> resultado;
	
	private Jugador crearJugadorConId(String nombre, String email, Long id) throws Exception {
	    Jugador j = new Jugador(nombre, email);
	    Field idField = Jugador.class.getDeclaredField("id");
	    idField.setAccessible(true);
	    idField.set(j, id);
	    return j;
	}
	
	@BeforeEach
	void setUp() {
		ju = new Jugador();
		listaVaciaJugadores = new ArrayList<>();
		resultado = new ArrayList<>();
		jugadores =List.of(
			new Jugador("David", "dav@hot.and"),
			new Jugador("Maria", "maria@hot.es")
				);
	}

	@Test
	final void testObtenerTodos_deberiaDevolverDosJugadores() {
		
		when(repoJugadorMock.findAll()).thenReturn(jugadores);
		
		resultado = service.obtenerTodos();
		
		assertEquals(2, resultado.size());
	}
	
	@Test
	final void testObtenerTodos_deberiaDevolverListaVaciaSiNoHayJugadores() {
		when(repoJugadorMock.findAll()).thenReturn(listaVaciaJugadores);
		
		resultado = service.obtenerTodos();
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	final void testObtenerTodos_deberiaContenerJugadorDavid() {

		when(repoJugadorMock.findAll()).thenReturn(jugadores);
		
		resultado = service.obtenerTodos();
		
		boolean encontrado = false;
		
		for (Jugador j : resultado) {
			if("David".equals(j.getNombre())) {
				encontrado = true;
			}
		}
		
		assertTrue(encontrado);
	}
	
	@Test
	final void testObtenerTodos_deberiaLanzarExcepcionCuandoRepoFalla() {
		
		when(repoJugadorMock.findAll()).thenThrow(new RuntimeException("Error de acceso a datos"));
		
		assertThrows(RuntimeException.class, ()-> service.obtenerTodos());
	}
	
	@Test
	final void testObtenerPorId_deberiaDevolverElJudadorDelIdIndicado() {
		
		when(repoJugadorMock.findById(1L)).thenReturn(Optional.of(jugadores.get(0)));
		
		ju = service.obtenerPorId(1L);
		
		assertEquals("David", ju.getNombre());
		assertEquals("dav@hot.and", ju.getEmail());
		
	}
	
	@Test
	final void testObtenerPorId_deberiaLanzarExcepcionCuandoRepoFalla() {
		
		when(repoJugadorMock.findById(1L)).thenThrow(new RuntimeException("Error de acceso al Id"));
		
		assertThrows(RuntimeException.class, () -> service.obtenerPorId(1L));
		
	}

	@Test
	final void testObtenerPorNombre_deberiaDevolverElJugadorDavid() {
		
		List<Jugador> jugadoresDavid = new ArrayList<>();
		
		for (Jugador j : jugadores) {
			if ("David".equals(j.getNombre())) {
				jugadoresDavid.add(j);
			}
		}

		when(repoJugadorMock.findByNombre("David")).thenReturn(jugadoresDavid);
		
		resultado = service.obtenerPorNombre("David");
		
		assertEquals(jugadoresDavid, resultado);
	}
	
	@Test
	final void testObtenerPorNombre_deberiaDevolverListaVaciaSiNoHayJugadorLLamadoLuis() {
		
		when(repoJugadorMock.findByNombre("Luis")).thenReturn(listaVaciaJugadores);
		
		resultado = service.obtenerPorNombre("Luis");
		
		assertTrue(resultado.isEmpty());
		
	}
	
	@Test
	final void testObtenerPorNombre_deberiaLanzarExcepcionCuandoRepoFalla() {
		
	    when(repoJugadorMock.findByNombre("David"))
	        .thenThrow(new RuntimeException("Error de acceso a datos"));
	    
	    assertThrows(RuntimeException.class, () -> service.obtenerPorNombre("David"));
	}
	
	@Test
	final void testObtenerPorEmail_deberiaDevolverElJugadorDavid() {
		
		when(repoJugadorMock.findByEmail("dav@hot.and")).thenReturn(Optional.of(jugadores.get(0)));
		
		Optional<Jugador> resultado = service.obtenerPorEmail("dav@hot.and");
		
		assertTrue(resultado.isPresent());
		
		assertEquals("dav@hot.and", resultado.get().getEmail());
	}
	
	@Test
	final void testObtenerPorEmail_deberiaDevolverUnOptionalVacio() {
		
		when(repoJugadorMock.findByEmail("dv@hot.and")).thenReturn(Optional.empty());
		
		Optional<Jugador> resultado = service.obtenerPorEmail("dv@hot.and");
		
		assertFalse(resultado.isPresent());
		
	}

	@Test
	final void testCrearJugador_deberiaDevolverLaJugadoraLolaTrasSuInsercion() {
		Jugador j = new Jugador("Lola", "olaLola@ola.hola");
		
		when(repoJugadorMock.save(j)).thenReturn(j);
		
		ju = service.crearJugador(j);
		
		assertEquals(j, ju);
		verify(repoJugadorMock).save(j);
	}
	
	@Test
	final void testCrearJugador_deberiaLanzarLaExcepcionPorJugadorYaExiste() throws Exception {
		
		/*Jugador j = new Jugador("David", "dav@hot.and");
		
		Field idField = Jugador.class.getDeclaredField("id");
	    idField.setAccessible(true);
	    idField.set(j, 1L);*/
		Jugador j = crearJugadorConId("David", "dav@hot.and", 1L);

	    when(repoJugadorMock.existsById(1L)).thenReturn(true);

	    assertThrows(RuntimeException.class, () -> service.crearJugador(j));
	}

	@Test
	final void testModificarDatosJugador_deberiaDevolverLaJugadoraConElNombreActualizado() throws Exception {
		
		/*Jugador jModificado = new Jugador(jugadores.get(1).getNombre(),jugadores.get(1).getEmail());
		
		Field idField = Jugador.class.getDeclaredField("id");
		
		idField.setAccessible(true);
		
		idField.set(jModificado, 2L);*/
		
		Jugador jModificado = crearJugadorConId(jugadores.get(1).getNombre(), jugadores.get(1).getEmail(), 2L);
		
		jModificado.setNombre("Juana");
		
		when(repoJugadorMock.existsById(2L)).thenReturn(true);
		when(repoJugadorMock.save(any(Jugador.class))).thenReturn(jModificado);
		
		ju = service.modificarDatosJugador(jModificado);

		assertEquals("Juana", ju.getNombre());
		
	}

	
	@Test
	final void testModificarDatosJugador_deberiaDevolverLaJugadoraConElEmailActualizado() throws Exception {
		
		/*Jugador jModificado = new Jugador(jugadores.get(1).getNombre(),jugadores.get(1).getEmail());
		
		Field idField = Jugador.class.getDeclaredField("id");
		
		idField.setAccessible(true);
		
		idField.set(jModificado, 2L);*/
		Jugador jModificado = crearJugadorConId(jugadores.get(1).getNombre(), jugadores.get(1).getEmail(), 2L);
		
		jModificado.setEmail("prue@ba.es");
		
		when(repoJugadorMock.existsById(2L)).thenReturn(true);
		when(repoJugadorMock.save(any(Jugador.class))).thenReturn(jModificado);
		
		ju= service.modificarDatosJugador(jModificado);
		
		assertEquals("prue@ba.es", ju.getEmail());
		
	}
	
	@Test
	final void testModificarDatosJugador_deberiaLanzarExcepcionPorIdNull() {
		
		Jugador jModificado = new Jugador(jugadores.get(1).getNombre(),jugadores.get(1).getEmail());
		
		assertThrows(RuntimeException.class, ()-> service.modificarDatosJugador(jModificado));
	}

	@Test
	void testModificarDatosJugador_deberiaLanzarExcepcionPorIdNoExistente() throws Exception {
	    /*Jugador jugadorConId = new Jugador("Juana", "juana@email.com");

	    Field idField = Jugador.class.getDeclaredField("id");
	    idField.setAccessible(true);
	    idField.set(jugadorConId, 42L);*/
		Jugador jugadorConId = crearJugadorConId("Juana", "juana@email.com", 42L);

	    when(repoJugadorMock.existsById(42L)).thenReturn(false);

	    assertThrows(RuntimeException.class, () -> service.modificarDatosJugador(jugadorConId));
	}

	@Test
	final void testEliminarJugador_deberiaEliminarCuandoExiste() {
		Long id = 1L;
		
		when(repoJugadorMock.existsById(id)).thenReturn(true);
		
		doNothing().when(repoJugadorMock).deleteById(id);
		
		service.eliminarJugador(id);
		
		verify(repoJugadorMock).deleteById(id);
	}
	
	@Test
	final void testEliminarJugador_deberiaLanzarExcepcionCuandoNoExiste() {
		Long id = 1L;
		
		when(repoJugadorMock.existsById(id)).thenReturn(false);
		
		assertThrows(RuntimeException.class, () -> service.eliminarJugador(id));

		verify(repoJugadorMock).existsById(id);
		verify(repoJugadorMock, never()).deleteById(id);
	}

}
