package arreglos;

import clases.Matricula;
import clases.Curso;
import arreglos.ArregloCursos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloMatricula {

    private ArrayList<Matricula> matriculas;

    // Constructor
    public ArregloMatricula() {
        matriculas = new ArrayList<>();
        
    }

    // Adicionar
    public void adicionar(Matricula m) {
        matriculas.add(m);
    }

    // Tamaño
    public int tamano() {
        return matriculas.size();
    }

    // Obtener
    public Matricula obtener(int posi) {
        return matriculas.get(posi);
    }

    // Eliminar
    public void eliminar(Matricula m) {
        matriculas.remove(m);
        
    }
    
    
    // Buscar por número de matrícula
    public Matricula buscar(int numMatricula) {
        for (int x=0; x<tamano();x++) {
            if (obtener(x).getNumMatricula() == numMatricula)
                return obtener(x);
        }
        return null;
    }

    
    
 // GRABAR
    public void grabarMatricula() {
        try {
            PrintWriter pw;
            Matricula objM;
            Curso objC;
            ArregloCursos arregloCursos = new ArregloCursos();
            String linea;

            pw = new PrintWriter(new FileWriter("matricula.txt"));

            for (int x = 0; x < tamano(); x++) {
                objM = matriculas.get(x);
                objC = arregloCursos.buscar(objM.getCodCurso());

                int creditos = (objC != null) ? objC.getCredi() : 0;
                String tipoCurso = (objC != null) ? objC.getTipoCurso() : "SinTipo";
                String modalidad = (objC != null) ? objC.getModalidad() : "SinModalidad";
                int horas = (objC != null) ? objC.getHoras() : 0;

                linea = objM.getNumMatricula() + ";" +
                        objM.getCodAlumno() + ";" +
                        objM.getCodCurso() + ";" +
                        creditos + ";" +
                        tipoCurso + ";" +
                        modalidad + ";" +
                        horas + ";" +
                        objM.getEspecialidad() + ";" +
                        objM.getCiclo() + ";" +
                        objM.getTurno() + ";" +
                        objM.getFecha() + ";" +
                        objM.getHora() + ";" +
                        objM.getEstado();

                pw.println(linea);
            }

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }



    public void listarMatriculas() {
        String linea;
        try {
            BufferedReader br = new BufferedReader(new FileReader("matricula.txt"));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 13) {  // ✅ Asegura que haya suficientes campos
                    int numMatricula = Integer.parseInt(partes[0].trim());
                    int codAlumno = Integer.parseInt(partes[1].trim());
                    int codCurso = Integer.parseInt(partes[2].trim());
                    String fecha = partes[10].trim();  // posiciones actualizadas
                    String hora = partes[11].trim();
                    String especialidad = partes[7].trim();
                    String ciclo = partes[8].trim();
                    String turno = partes[9].trim();
                    int estado = Integer.parseInt(partes[12].trim());

                    Matricula m = new Matricula(numMatricula, codAlumno, codCurso, fecha, hora,
                                                 especialidad, ciclo, turno, estado);
                    matriculas.add(m);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();  // ✅ Nunca dejes el catch vacío
        }
    }
    
    
   
    // Verificar si un alumno ya está matriculado en un curso
    public boolean existeMatricula(int codAlumno, int codCurso) {
        for (Matricula m : matriculas) {
            if (m.getCodAlumno() == codAlumno && m.getCodCurso() == codCurso)
                return true;
        }
        return false;
    }

    // Generar código correlativo
    public int generarCodigo() {
        if (tamano() == 0) {
            return 100001; // primer número de matrícula
        } else {
            return obtener(tamano() - 1).getNumMatricula() + 1;
        }
    }

	public void vaciar() {
		matriculas.clear(); // Suponiendo que usas ArrayList<Matricula> lista;
		
		
	}

	public int obtenerUltimoCodigo() {
		if (matriculas.isEmpty()) return 100000; // o el número base
	    return matriculas.get(matriculas.size() - 1).getNumMatricula();
	}
	
	
	public void grabarMatriculaAcumulado() {
	    // 1. Leer lo que ya estaba grabado en archivo
	    listarMatriculas(); // esto carga los datos al ArrayList interno

	    // 2. Agregar nuevas (evitando duplicados)
	    for(int x=0;x<tamano();x++) {
	        Matricula nueva =obtener(x);
	        if (!existeMatricula(nueva.getCodAlumno(), nueva.getCodCurso())) {
	            adicionar(nueva);
	        }
	    }

	    // 3. Grabar todo al archivo
	    grabarMatricula();
	}
	
	public boolean existeCursoMatriculado(int codCurso) {
	    for (int i = 0; i < tamano(); i++) {
	        if (obtener(i).getCodCurso() == codCurso) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean alumnoYaMatriculado(int codAlumno) {
	    for (int i = 0; i < this.tamano(); i++) {
	        Matricula m = this.obtener(i);
	        if (m.getCodAlumno() == codAlumno && m.getEstado() == 1) {
	            return true;
	        }
	    }
	    return false;
	}
    

    

}