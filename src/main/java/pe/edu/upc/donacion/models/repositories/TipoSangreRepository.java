package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.TipoSangre;

@Repository
public interface TipoSangreRepository extends JpaRepository<TipoSangre, Integer> {
	List<TipoSangre> findByNombreContaining(String nombre) throws Exception;
}
