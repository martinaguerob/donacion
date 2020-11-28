package pe.edu.upc.donacion.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.donacion.models.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}