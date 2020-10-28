package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.models.repositories.UnidadSangreRepository;
import pe.edu.upc.donacion.services.UnidadSangreService;

@Service
public class UnidadSangreServiceImpl implements UnidadSangreService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UnidadSangreRepository unidadSangreRepository;

	@Transactional
	@Override
	public UnidadSangre save(UnidadSangre entity) throws Exception {
		return unidadSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public UnidadSangre update(UnidadSangre entity) throws Exception {
		return unidadSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		unidadSangreRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UnidadSangre> findById(Integer id) throws Exception {
		return unidadSangreRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UnidadSangre> findAll() throws Exception {
		return unidadSangreRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception {
		return unidadSangreRepository.findByNumeroLote(numeroLote);
	}

}
