package pe.edu.upc.donacion.services;

import java.util.List;

import pe.edu.upc.donacion.models.entities.Hospital;

public interface HospitalService extends CrudService<Hospital, Integer> {
	List<Hospital> findByNombre(String nombre) throws Exception;
}
