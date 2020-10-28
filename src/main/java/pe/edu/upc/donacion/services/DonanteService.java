package pe.edu.upc.donacion.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.donacion.models.entities.Donante;

public interface DonanteService extends CrudService<Donante, Integer> {
	List<Donante> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
