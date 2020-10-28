package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.RegistroDonacion;
import pe.edu.upc.donacion.models.repositories.RegistroDonacionRepository;
import pe.edu.upc.donacion.services.RegistroDonacionService;

@Service
public class RegistroDonacionServiceImpl implements RegistroDonacionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegistroDonacionRepository registroDonacionRepository;

	@Transactional
	@Override
	public RegistroDonacion save(RegistroDonacion entity) throws Exception {
		return registroDonacionRepository.save(entity);
	}

	@Transactional
	@Override
	public RegistroDonacion update(RegistroDonacion entity) throws Exception {
		return registroDonacionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		registroDonacionRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<RegistroDonacion> findById(Integer id) throws Exception {
		return registroDonacionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<RegistroDonacion> findAll() throws Exception {
		return registroDonacionRepository.findAll();
	}
}
