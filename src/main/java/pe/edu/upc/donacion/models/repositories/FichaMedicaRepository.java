package pe.edu.upc.donacion.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.FichaMedica;

@Repository
public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Integer> {
	
}
