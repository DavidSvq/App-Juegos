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
	public List<Desarrolladora> getAllGameDevelopmentCompanies(){
		
		return desarrolladoraService.getAllGameDevelopmentCompanies();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Desarrolladora> getDevelopmentCompanyById(@PathVariable Long id){
		try {
			Desarrolladora desarrolladora = desarrolladoraService.getDevelopmentCompanyById(id);
			
			return ResponseEntity.ok(desarrolladora);
		}
		catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Desarrolladora> getDevelopmentCompanyByName(@PathVariable String nombre){
		
		Optional<Desarrolladora> desarrolladora = desarrolladoraService.getDevelopmentCompanyByName(nombre);
		
		return desarrolladora
				.map(ResponseEntity::ok)
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pais/{pais}")
	public List<Desarrolladora> getDevelopmentCompaniesByCountry(@PathVariable String pais){
		
		return desarrolladoraService.getDevelopmentCompaniesByCountry(pais);
	}
	
	@PostMapping
	public ResponseEntity<Desarrolladora> insertNewDevelopmentCompany(@RequestBody Desarrolladora desarrolladora){
		
		Desarrolladora newDevelopmentCompany = desarrolladoraService.insertNewDevelopmentCompany(desarrolladora);
		
		return ResponseEntity.ok(newDevelopmentCompany);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Desarrolladora> updateDevelopmentCompany(@PathVariable Long id, @RequestBody Desarrolladora d){
		try {
			Desarrolladora auxDevelopmentCompany = desarrolladoraService.getDevelopmentCompanyById(id);
			auxDevelopmentCompany.setNombre(d.getNombre());
			auxDevelopmentCompany.setPais(d.getPais());
			
			Desarrolladora newDevelopmentCompany = desarrolladoraService.insertNewDevelopmentCompany(auxDevelopmentCompany);
			
			return ResponseEntity.ok(newDevelopmentCompany);
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
