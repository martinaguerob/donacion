package pe.edu.upc.donacion.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.UnidadSangre;

@Repository
public interface UnidadSangreRepository extends JpaRepository<UnidadSangre, Integer> {
	Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception;
}
