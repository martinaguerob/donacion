package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.models.repositories.TipoSangreRepository;
import pe.edu.upc.donacion.services.TipoSangreService;

@Service
public class TipoSangreServiceImpl implements TipoSangreService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoSangreRepository tipoSangreRepository;

	@Transactional
	@Override
	public TipoSangre save(TipoSangre entity) throws Exception {
		return tipoSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoSangre update(TipoSangre entity) throws Exception {
		return tipoSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tipoSangreRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<TipoSangre> findById(Integer id) throws Exception {
		return tipoSangreRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoSangre> findAll() throws Exception {
		return tipoSangreRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoSangre> findByNombre(String nombre) throws Exception {
		return tipoSangreRepository.findByNombreContaining(nombre);
	}

}
