package pe.edu.upc.donacion.services;

import java.util.Optional;

import pe.edu.upc.donacion.models.entities.UnidadSangre;

public interface UnidadSangreService extends CrudService<UnidadSangre, Integer> {
	Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception;
}
