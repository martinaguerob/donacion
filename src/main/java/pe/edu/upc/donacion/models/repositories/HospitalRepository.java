package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	List<Hospital> findByNombreContaining(String nombre) throws Exception;
}
