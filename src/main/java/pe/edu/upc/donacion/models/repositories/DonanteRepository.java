package pe.edu.upc.donacion.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.Donante;

@Repository
public interface DonanteRepository extends JpaRepository<Donante, Integer> {
	
	List<Donante> findByNombresApellidosContaining(String nombresApellidos) throws Exception;
	
	Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
