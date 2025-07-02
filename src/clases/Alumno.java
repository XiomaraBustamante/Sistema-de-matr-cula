package clases;

public class Alumno {
    //  Atributos privados
	private int codAlumno;
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	private int celular;
	private String correo;
	private String direc;
	private int estado;
	
	//Constructor
	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, String correo, String direc, int estado) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.correo=correo;
		this.direc=direc;
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
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	
	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDirec() {
		return direc;
	}


	public void setDirec(String direc) {
		this.direc = direc;
	}


	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	// Método para obtener nombre del estado
	public static String obtenerNombreEstado(int estado) {
	    switch (estado) {
	        case 0: return "Registrado";
	        case 1: return "Matriculado";
	        case 2: return "Retirado";
	        default: return "Desconocido";
	    }
	}
	
	
    
	
	
	
	
	

}
