package co.edu.unicundi.proyectoSpringPrueba.dto;

public class Profesor {

	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	public Profesor() {
		
	}

	public Profesor(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean notNull() {
		if (id==null || nombre.equals(null) || apellido.equals(null)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean notEmpty() {
		if (id<=0 || nombre.equals("") || apellido.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
}
