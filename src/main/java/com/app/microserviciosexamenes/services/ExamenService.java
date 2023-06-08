package com.app.microserviciosexamenes.services;

import java.util.List;

import com.app.commonsexamenes.models.Asignatura;
import com.app.commonsexamenes.models.Examen;
import com.app.commonsmicroservicios.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
