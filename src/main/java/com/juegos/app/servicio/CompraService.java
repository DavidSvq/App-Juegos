/**
 * 
 */
package com.juegos.app.servicio;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.juegos.app.modelo.Compra;
import com.juegos.app.modelo.Juego;
import com.juegos.app.modelo.Jugador;
import com.juegos.app.repositorio.RepositorioCompra;

/**
 * 
 */
@Service
public class CompraService {

	private RepositorioCompra rCompra;

	/**
	 * @param rCompra
	 */
	public CompraService(RepositorioCompra rCompra) {
		this.rCompra = rCompra;
	}
	
	public List<Compra> getAllBuys(){
		return rCompra.findAll();
	}
	
	public Compra getBuyById(Long id) {
		return rCompra.findById(id).orElseThrow(() -> new RuntimeException("Error, Id de compra no encontrado."));
	}
	
	public List<Compra> getByJuego(Juego juego){
		return rCompra.findByJuego(juego);
	}
	
	public List<Compra> getByJugador(Jugador jugador){
		return rCompra.findByJugador(jugador);
	}
	
	public List<Compra> getByFechaCompra (LocalDateTime fechaCompra){
		return rCompra.findByFechaCompra(fechaCompra);
	}
	
	public Compra addBuy(Compra compra){
		if(compra.getId() != null) {
			throw new RuntimeException("Error, la compra ya existe.");
		}
		return rCompra.save(compra);
	}
	
	public Compra updateBuy(Compra compra) {
		if(compra.getId() == null || !rCompra.existsById(compra.getId())) {
			throw new RuntimeException("Error, compra inexistente.");
		}
		
		return rCompra.save(compra);
	}
	
	public void deleteBuyById(Long id) {
		if(!rCompra.existsById(id)) {
			throw new RuntimeException("Error, compra inexistente");
		}
		
		rCompra.deleteById(id);
	}
}
