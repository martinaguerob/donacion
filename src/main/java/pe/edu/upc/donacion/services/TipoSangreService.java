package pe.edu.upc.donacion.services;

import java.util.List;

import pe.edu.upc.donacion.models.entities.TipoSangre;

public interface TipoSangreService extends CrudService<TipoSangre, Integer> {
	List<TipoSangre> findByNombre(String nombre) throws Exception;
}
