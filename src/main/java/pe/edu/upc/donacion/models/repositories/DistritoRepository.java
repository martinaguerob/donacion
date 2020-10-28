package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
	List<Distrito> findByNombreLike(String nombre) throws Exception;
}
