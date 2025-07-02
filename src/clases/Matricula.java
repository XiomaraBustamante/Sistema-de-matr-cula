package clases;


public class Matricula {

    // Atributos privados
    private int numMatricula;
    private int codAlumno;
    private int codCurso;
    private String fecha;
    private String hora;
    private String especialidad;
    private String ciclo;
    private String turno;
    private int estado; // 1 = matriculado, 0 = no matriculado

    // Constructor completo
    public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora,
            String especialidad, String ciclo, String turno, int estado) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		this.especialidad = especialidad;
		this.ciclo = ciclo;
		this.turno = turno;
		this.estado = estado;
}

    // Métodos de acceso (get/set)
    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    // Método para obtener estado en formato String
    public String getEstadoTexto() {
        return (estado == 1) ? "Matriculado" : "No matriculado";
    }

   
   
}