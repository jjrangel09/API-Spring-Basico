package co.edu.unicundi.proyectoSpringPrueba.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.dto.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.service.services.IRepositorioService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private IRepositorioService repo;

	@GetMapping("/list")
	public ResponseEntity<?> getProfesores() {
		return repo.getProfesores();
	}

	@GetMapping("/ByID/{id}")
	public ResponseEntity<?> getProfesorById(@PathVariable int id) {
		return repo.getProfesorById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<?> guardar(@RequestBody Profesor profesor) {
		return repo.guardar(profesor);
	}

	@PostMapping("/addMany")
	public ResponseEntity<?> addProfesores(@RequestBody ArrayList<Profesor> profesores) {
		return repo.guardarVarios(profesores);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Profesor profesor) {
		return repo.editarProfesor(id, profesor);
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		return repo.eliminarProfesor(id);
	}

}
