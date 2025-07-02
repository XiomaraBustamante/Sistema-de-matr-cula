package clases;

public class Curso {
	private int codCurso;
	private String asignatura;
	private int ciclo;
	private int credi;
	private String tipoCurso;
	private String modalidad;
	private int horas;
	
	
	
	public Curso(int codCurso, String asignatura, int ciclo, int credi, String tipoCurso, String modalidad, int horas) {
		super();
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.credi = credi;
		this.tipoCurso = tipoCurso;
		this.modalidad = modalidad;
		this.horas = horas;
	}
	
	



	public int getCodCurso() {
		return codCurso;
	}





	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}





	public String getAsignatura() {
		return asignatura;
	}





	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}





	public int getCiclo() {
		return ciclo;
	}





	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}





	public int getCredi() {
		return credi;
	}





	public void setCredi(int credi) {
		this.credi = credi;
	}





	public String getTipoCurso() {
		return tipoCurso;
	}





	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}





	public String getModalidad() {
		return modalidad;
	}





	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}





	public int getHoras() {
		return horas;
	}





	public void setHoras(int horas) {
		this.horas = horas;
	}




}


