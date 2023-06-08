package com.app.microserviciosexamenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.commonsexamenes.models.Asignatura;
import com.app.commonsexamenes.models.Examen;
import com.app.commonsmicroservicios.services.CommonServiceImpl;
import com.app.microserviciosexamenes.repository.AsignaturaRepository;
import com.app.microserviciosexamenes.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignaturaRepository.findAll();
	}

}
