package co.edu.unicundi.proyectoSpringPrueba.service.services;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import co.edu.unicundi.proyectoSpringPrueba.dto.Profesor;

public interface IRepositorioService {

	ResponseEntity<?> getProfesores();

	ResponseEntity<?> getProfesorById(int id);

	ResponseEntity<?> guardar(Profesor profesor);

	ResponseEntity<?> guardarVarios(ArrayList<Profesor> profesores);

	ResponseEntity<?> editarProfesor(int id, Profesor profesor);

	ResponseEntity<?> eliminarProfesor(int id);
	
}
