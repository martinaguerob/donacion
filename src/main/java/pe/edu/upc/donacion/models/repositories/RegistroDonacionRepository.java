package pe.edu.upc.donacion.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.donacion.models.entities.RegistroDonacion;

@Repository
public interface RegistroDonacionRepository extends JpaRepository<RegistroDonacion,Integer> {

}
