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
import com.juegos.app.servicio.DesarrolladoraService;

/**
 * 
 */

@RestController
@RequestMapping("/desarrolladoras")
public class DesarrolladoraController {

	private DesarrolladoraService desarrolladoraService;

	/**
	 * @param desarolladoraService
	 */
	public DesarrolladoraController(DesarrolladoraService desarolladoraService) {
		super();
		this.desarrolladoraService = desarolladoraService;
	}
	
	@GetMapping
	public ResponseEntity<List<Desarrolladora>> getAllGameDevelopmentCompanies(){
		try {
			return ResponseEntity.ok(desarrolladoraService.getAllGameDevelopmentCompanies());
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Desarrolladora> getDevelopmentCompanyById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(desarrolladoraService.getDevelopmentCompanyById(id));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Optional<Desarrolladora>> getDevelopmentCompanyByName(@PathVariable String nombre){
		try {
			return ResponseEntity.ok(desarrolladoraService.getDevelopmentCompanyByName(nombre));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/pais/{pais}")
	public ResponseEntity<List<Desarrolladora>> getDevelopmentCompaniesByCountry(@PathVariable String pais){
		try {
			return ResponseEntity.ok(desarrolladoraService.getDevelopmentCompaniesByCountry(pais));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Desarrolladora> insertNewDevelopmentCompany(@RequestBody Desarrolladora desarrolladora){
		try {
			return ResponseEntity.ok(desarrolladoraService.insertNewDevelopmentCompany(desarrolladora));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Desarrolladora> updateDevelopmentCompany(@RequestBody Desarrolladora d){
		try {
			return ResponseEntity.ok(desarrolladoraService.insertNewDevelopmentCompany(d));
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDevelopmentCompany (@PathVariable Long id){
		try {
			desarrolladoraService.deleteDevelopmentCompanyById(id);
			return ResponseEntity.noContent().build();
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
