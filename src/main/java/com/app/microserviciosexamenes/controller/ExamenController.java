package com.app.microserviciosexamenes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.commonsexamenes.models.Examen;
import com.app.commonsmicroservicios.controllers.CommonController;
import com.app.microserviciosexamenes.services.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen, BindingResult result, @PathVariable Long id) {
		
		if(result.hasErrors()) {
			return validar(result);
		}
		
		Optional<Examen> o = service.findbyId(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examendb = o.get();
		examendb.setNombre(examen.getNombre());

		// List<Pregunta> eliminadas = new ArrayList<>();
		// examendb.getPreguntas().forEach(p->{
		// if(!examen.getPreguntas().contains(p)) {
		// eliminadas.add(p);
		// }
		// });

		// eliminadas.forEach(p->{
		// examendb.removePregunta(p);
		// });
		// eliminadas.forEach(examendb::removePregunta);

		examendb.getPreguntas()
			.stream()
			.filter(p -> !examen.getPreguntas().contains(p))
			.forEach(examendb::removePregunta);

		examendb.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examendb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> editar(@PathVariable("term") String term) {
		return ResponseEntity.ok(service.findByNombre(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.ok(service.findAllAsignaturas());
	}
	
	
	
	
	
	
	
	
}
