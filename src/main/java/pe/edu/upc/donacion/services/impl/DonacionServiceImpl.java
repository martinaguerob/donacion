package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.Donacion;
import pe.edu.upc.donacion.models.repositories.DonacionRepository;
import pe.edu.upc.donacion.services.DonacionService;

@Service
public class DonacionServiceImpl implements DonacionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DonacionRepository donacionRepository;

	@Transactional
	@Override
	public Donacion save(Donacion entity) throws Exception {
		return donacionRepository.save(entity);
	}

	@Transactional
	@Override
	public Donacion update(Donacion entity) throws Exception {
		return donacionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		donacionRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Donacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return donacionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Donacion> findAll() throws Exception {
		return donacionRepository.findAll();
	}

}
