package pe.edu.upc.donacion.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.donacion.models.entities.FichaMedica;

public interface FichaMedicaService extends CrudService<FichaMedica, Integer> {
	@Query("FROM ficha_medica ORDER BY id ASC LIMIT 1")
	List<FichaMedica> findTopByIdOrderAsc() throws Exception;
	
	List<FichaMedica> findAllOrderDesc() throws Exception;
	List<FichaMedica> findAllOrderAsc() throws Exception;
}
