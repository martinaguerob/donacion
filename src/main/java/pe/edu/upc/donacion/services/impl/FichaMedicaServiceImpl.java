package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.repositories.FichaMedicaRepository;
import pe.edu.upc.donacion.services.FichaMedicaService;

@Service
public class FichaMedicaServiceImpl implements FichaMedicaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FichaMedicaRepository fichaMedicaRepository;

	@Transactional
	@Override
	public FichaMedica save(FichaMedica entity) throws Exception {
		return fichaMedicaRepository.save(entity);
	}

	@Transactional
	@Override
	public FichaMedica update(FichaMedica entity) throws Exception {
		return fichaMedicaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		fichaMedicaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<FichaMedica> findById(Integer id) throws Exception {
		return fichaMedicaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<FichaMedica> findAll() throws Exception {
		return fichaMedicaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<FichaMedica> findTopByIdOrderAsc() throws Exception {
		return fichaMedicaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<FichaMedica> findAllOrderDesc() throws Exception {
		return fichaMedicaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<FichaMedica> findAllOrderAsc() throws Exception {
		return fichaMedicaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	
}
