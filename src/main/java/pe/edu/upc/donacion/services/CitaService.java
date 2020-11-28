package pe.edu.upc.donacion.services;

import java.util.List;

import pe.edu.upc.donacion.models.entities.Cita;

public interface CitaService extends CrudService<Cita, Integer> {
	List<Cita> findByIdDonante(Integer Id) throws Exception;
}
