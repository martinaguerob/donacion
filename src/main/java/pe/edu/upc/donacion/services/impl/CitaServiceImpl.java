package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.repositories.CitaRepository;
import pe.edu.upc.donacion.services.CitaService;

@Service
public class CitaServiceImpl implements CitaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CitaRepository citaRepository;

	@Transactional
	@Override
	public Cita save(Cita entity) throws Exception {
		return citaRepository.save(entity);
	}

	@Transactional
	@Override
	public Cita update(Cita entity) throws Exception {
		return citaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		citaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cita> findById(Integer id) throws Exception {
		return citaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cita> findAll() throws Exception {
		return citaRepository.findAll();
	}

	@Override
	public List<Cita> findByIdDonante(Integer Id) throws Exception {
		return citaRepository.findByIdDonante(Id);
	}
}
