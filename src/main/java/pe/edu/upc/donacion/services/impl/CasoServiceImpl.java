package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.Caso;
import pe.edu.upc.donacion.models.repositories.CasoRepository;
import pe.edu.upc.donacion.services.CasoService;

@Service
public class CasoServiceImpl implements CasoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private CasoRepository casoRepository;
	
	@Transactional
	@Override
	public Caso save(Caso entity) throws Exception {
		return casoRepository.save(entity);
	}

	@Transactional
	@Override
	public Caso update(Caso entity) throws Exception {
		return casoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		casoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Caso> findById(Integer id) throws Exception {
		return casoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Caso> findAll() throws Exception {
		return casoRepository.findAll();
	}
	
}
