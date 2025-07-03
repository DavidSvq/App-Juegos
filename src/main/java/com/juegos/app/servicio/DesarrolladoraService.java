/**
 * 
 */
package com.juegos.app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.juegos.app.modelo.Desarrolladora;
import com.juegos.app.repositorio.RepositorioDesarrolladora;

/**
 * 
 */
@Service
public class DesarrolladoraService {

	private RepositorioDesarrolladora repoDesarrolladora;

	/**
	 * @param repoDesarrolladora
	 */
	public DesarrolladoraService(RepositorioDesarrolladora repoDesarrolladora) {
		this.repoDesarrolladora = repoDesarrolladora;
	}
	
	public List<Desarrolladora> getAllGameDevelopmentCompanies(){
		
		return repoDesarrolladora.findAll();
	}
	
	public Desarrolladora getDevelopmentCompanyById(Long id) {
		
		return repoDesarrolladora.findById(id).orElseThrow(() -> new RuntimeException("Desarrolladora no encontrada."));
	}
	
	public Optional<Desarrolladora> getDevelopmentCompanyByName(String nombre){
		
		return repoDesarrolladora.findByNombre(nombre);
	}
	
	public List<Desarrolladora> getDevelopmentCompaniesByCountry(String pais){
		
		return repoDesarrolladora.findByPais(pais);
	}
	
	public Desarrolladora insertNewDevelopmentCompany(Desarrolladora desarrolladora) {
		
		if(desarrolladora.get_id() != null && repoDesarrolladora.existsById(desarrolladora.get_id())) {
			
			throw new RuntimeException("La desarrolladora ya existe.");
		}
		
		return repoDesarrolladora.save(desarrolladora);
	}
	
	public Desarrolladora updateDevelopmentCompany(Desarrolladora d) {
		
		if(d.get_id() == null || !repoDesarrolladora.existsById(d.get_id())) {
			throw new RuntimeException("La desarrolladora no existe.");
		}
		
		return repoDesarrolladora.save(d);
	}
	
	public void deleteDevelopmentCompanyById(Long id) {
		if(!repoDesarrolladora.existsById(id)) {
			throw new RuntimeException("Desarrolladora no encontrada.");
		}
		
		repoDesarrolladora.deleteById(id);
	}
}
