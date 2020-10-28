package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.repositories.DonanteRepository;
import pe.edu.upc.donacion.services.DonanteService;

@Service
public class DonanteServiceImpl implements DonanteService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DonanteRepository donanteRepository;

	@Transactional
	@Override
	public Donante save(Donante entity) throws Exception {
		return donanteRepository.save(entity);
	}

	@Transactional
	@Override
	public Donante update(Donante entity) throws Exception {
		return donanteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		donanteRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Donante> findById(Integer id) throws Exception {
		return donanteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Donante> findAll() throws Exception {
		return donanteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Donante> findByNombresApellidos(String nombresApellidos) throws Exception {
		return donanteRepository.findByNombresApellidosContaining(nombresApellidos);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return donanteRepository.findByNumeroDocumento(numeroDocumento);
	}
}
