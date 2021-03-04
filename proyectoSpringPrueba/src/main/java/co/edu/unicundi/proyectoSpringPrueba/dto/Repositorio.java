package co.edu.unicundi.proyectoSpringPrueba.dto;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Repositorio {

	private ArrayList<Profesor> profesores = new ArrayList<>();

	public Repositorio() {
		super();
		profesores.add(new Profesor(1, "Juan José", "Rangel"));
		profesores.add(new Profesor(2, "Pepe", "Perez"));
		profesores.add(new Profesor(3, "John", "Doe"));
		profesores.add(new Profesor(4, "Jane", "Doss"));
		profesores.add(new Profesor(5, "Bill", "Gates"));
	}

	public ResponseEntity<?> getProfesores() {
		return new ResponseEntity<ArrayList<Profesor>>(profesores, HttpStatus.OK);
	}

	public ResponseEntity<?> getById(int id) {

		for (Profesor profesor : profesores) {
			if (profesor.getId() == id) {
				return new ResponseEntity<Profesor> (profesor, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object> (new Object[] { 404, "Id no Encontrado:", id }, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> save(Profesor profesor) {
		if (profesor.notEmpty() && profesor.notNull()) {
			if (!exists(profesor.getId())) {
				this.profesores.add(profesor);
				return new ResponseEntity<> (new Object[] { "Registro añadido:", profesor }, HttpStatus.OK);
			} else {
				return new ResponseEntity<> (new Object[] { "El id ya existe!", profesor }, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<> (new Object[] { 400, "Datos no validos!" }, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> saveMany(ArrayList<Profesor> profesores) {
		try {
			for (Profesor profesor : profesores) {
				if (profesor.notEmpty() && profesor.notNull()) {
					this.profesores.add(profesor);
				} else {
					return new ResponseEntity<> (new Object[] { 400, "Datos no validos!" }, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<> ("¡error!: " + e.toString(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<> (new Object[] { "realizado, elementos añadidos.", profesores }, HttpStatus.OK);
	}

	public ResponseEntity<?> editar(int id, Profesor profesor) {
		if (profesor.notEmpty() && profesor.notNull()) {
			if (exists(id)) {
				for (Profesor profesorA : profesores) {
					if (profesorA.getId() == profesor.getId() && profesor.getId() == id) {
						profesorA.setNombre(profesor.getNombre());
						profesorA.setApellido(profesor.getApellido());
						return new ResponseEntity<> (new Object[] {201, "Datos profesor actualizados", profesor }, HttpStatus.CREATED);
					}

					if (profesorA.getId() == id && id != profesor.getId() && !exists(profesor.getId())) {
						profesorA.setId(profesor.getId());
						profesorA.setNombre(profesor.getNombre());
						profesorA.setApellido(profesor.getApellido());
						return new ResponseEntity<> (new Object[] {201, "Datos profesor e Id Actualizados", profesor }, HttpStatus.CREATED);
					}
				}
			} else {
				return new ResponseEntity<> (new Object[] { 404, "El profesor no existe!" }, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<> (new Object[] { 400, "Datos no validos!" }, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<> (new Object[] { 400, "El id no está disponible!" }, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<?> eliminar(int id) {
		for (Profesor profesor : profesores) {
			if (profesor.getId() == id) {
				profesores.remove(profesor);
				return new ResponseEntity<> (new Object[] { 200, "Profesor Eliminado", id, profesor }, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<> (new Object[] { 404, "Id no Encontrado:", id }, HttpStatus.NOT_FOUND);
	}

	public boolean exists(int id) {
		for (Profesor profesor : this.profesores) {
			if (profesor.getId() == id) {
				return true;
			}
		}
		return false;
	}
}
