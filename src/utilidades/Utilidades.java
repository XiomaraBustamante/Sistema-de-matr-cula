package utilidades;

public class Utilidades {
	
	//  Atributos static 
	private static String[] estadoAlumno = { "Registrado", "Matriculado", "Retirado"};
	private static String[] cicloCurso = {"Elegir ciclo", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"};
	private static String[] estadosmatricula = { "Activado", "Desactivado" };
	private static String[] tipocurso = { "Elegir tipo de curso","Teórico", "Laboratorio", "Teórico+Laboratorio"};
	private static String[] modalidad = { "Elegir modalidad","Presencial", "Virtual", "Hibrido"};
	
	public static String[] getEstadoAlumno() {
		return estadoAlumno;
	}
	public static void setEstadoAlumno(String[] estadoAlumno) {
		Utilidades.estadoAlumno = estadoAlumno;
	}
	public static String[] getCicloCurso() {
		return cicloCurso;
	}
	public static void setCicloCurso(String[] cicloCurso) {
		Utilidades.cicloCurso = cicloCurso;
	}
	public static String[] getEstadosmatricula() {
		return estadosmatricula;
	}
	public static void setEstadosmatricula(String[] estadosmatricula) {
		Utilidades.estadosmatricula = estadosmatricula;
	}
	public static String[] getTipocurso() {
		return tipocurso;
	}
	public static void setTipocurso(String[] tipocurso) {
		Utilidades.tipocurso = tipocurso;
	}
	public static String[] getModalidad() {
		return modalidad;
	}
	public static void setModalidad(String[] modalidad) {
		Utilidades.modalidad = modalidad;
	}

	
	
}
