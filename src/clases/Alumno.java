package clases;

public class Alumno {
    //  Atributos privados
	private int codAlumno;
	private String nombres;
	private String apellidos;
	private String Dni;
	private int edad;
	private int estado;
	
	//Constructor
	public Alumno(int codAlumno, String nombres, String apellidos, String Dni, int edad, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.Dni = Dni;
		this.edad = edad;
		this.estado = estado;
	}
	
	
    //Métodos de acceso público: set/get
	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
