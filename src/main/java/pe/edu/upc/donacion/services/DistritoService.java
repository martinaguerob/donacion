package pe.edu.upc.donacion.services;

import java.util.List;

import pe.edu.upc.donacion.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer> {
	List<Distrito> findByNombre(String nombre) throws Exception;
}
