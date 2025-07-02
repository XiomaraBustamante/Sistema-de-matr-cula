package clases;

public class Retiro {
	private int numRetiro;
	private int numMatri;
	private String curso;
	private String especialidad;
	private String ciclo;
	private String fecha;
	private String hora;
	private String motivo;
	
	public Retiro(int numRetiro, int numMatri, String curso, String especialidad, String ciclo, String fecha,
			String hora, String motivo) {
		this.numRetiro = numRetiro;
		this.numMatri = numMatri;
		this.curso = curso;
		this.especialidad = especialidad;
		this.ciclo = ciclo;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
	}

	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public int getNumMatri() {
		return numMatri;
	}

	public void setNumMatri(int numMatri) {
		this.numMatri = numMatri;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

	
}