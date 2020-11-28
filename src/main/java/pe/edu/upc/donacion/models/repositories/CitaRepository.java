package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	@Query("select c from Cita c where c.donante.id = ?1")
	List<Cita> findByIdDonante(Integer Id) throws Exception;
}
