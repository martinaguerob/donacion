package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.models.repositories.HospitalRepository;
import pe.edu.upc.donacion.services.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@Transactional
	@Override
	public Hospital save(Hospital entity) throws Exception {
		return hospitalRepository.save(entity);
	}

	@Transactional
	@Override
	public Hospital update(Hospital entity) throws Exception {
		return hospitalRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		hospitalRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Hospital> findById(Integer id) throws Exception {
		return hospitalRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hospital> findAll() throws Exception {
		return hospitalRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hospital> findByNombre(String nombre) throws Exception {
		return hospitalRepository.findByNombreContaining(nombre);
	}

}
