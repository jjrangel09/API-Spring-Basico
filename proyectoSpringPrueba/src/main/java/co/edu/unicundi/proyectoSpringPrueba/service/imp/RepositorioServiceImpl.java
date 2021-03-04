package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import co.edu.unicundi.proyectoSpringPrueba.dto.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.dto.Repositorio;
import co.edu.unicundi.proyectoSpringPrueba.service.services.IRepositorioService;

@Component
public class RepositorioServiceImpl implements IRepositorioService{

	Repositorio repo = new Repositorio();

	@Override
	public ResponseEntity<?> getProfesores() {
		return repo.getProfesores();
	}

	@Override
	public ResponseEntity<?> getProfesorById(int id) {
		return repo.getById(id);
	}

	@Override
	public ResponseEntity<?> guardar(Profesor profesor) {
		return repo.save(profesor);
	}

	@Override
	public ResponseEntity<?> guardarVarios(ArrayList<Profesor> profesores) {
		return repo.saveMany(profesores);
	}

	@Override
	public ResponseEntity<?> editarProfesor(int id, Profesor profesor) {
		return repo.editar(id, profesor);
	}

	@Override
	public ResponseEntity<?> eliminarProfesor(int id) {
		return repo.eliminar(id);
	}
	
	

}
