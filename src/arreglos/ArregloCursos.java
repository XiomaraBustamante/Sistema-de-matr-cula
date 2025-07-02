package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import clases.Curso;

public class ArregloCursos {
	private ArrayList<Curso> cursos;

//  Constructor
	public ArregloCursos() {
		cursos = new ArrayList<Curso>();
		listarCursos();
	}




	// TAMAÑO
	public int tamano() {
		return cursos.size();
	}

	// OBTENER
	public Curso obtener(int posi) {
		return cursos.get(posi);
	}
	
	
	// ADICIONAR
		public void adicionar(Curso c) {
			cursos.add(c);
		}
		
		

	// ELIMINAR
	public void eliminar(Curso a) {
		cursos.remove(a);
	}
	
	
	

	/** FIN OPERACIONES BÁSICAS **/

	// Buscar el Curso por su codigo
	public Curso buscar(int codCurso) {
		for (int x=0;x<tamano();x++) {
			if (obtener(x).getCodCurso() == codCurso)
				return obtener(x);
		}
		return null;
	}
	

	//Guardar
		public void grabarCurso() {
			try {
				 
				PrintWriter pw;
				
				Curso objC;
				
				String linea;
				
				
				pw = new PrintWriter(new FileWriter("Curso.txt"));
				for (int x=0; x<tamano();x++) {
					objC=cursos.get(x);
					 linea = objC.getCodCurso() + ";" + 
							 objC.getAsignatura() + ";" + 
							 objC.getCiclo() + ";" +
							 objC.getCredi() + ";"  +
							 objC.getTipoCurso() + ";" + 
							 objC.getModalidad()+ ";" + 
							 objC.getHoras() ;
					 
					 
					pw.println(linea);
				}
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	private void listarCursos() {
		cursos.clear();
		 try {
			 
			 BufferedReader br;
				String miscursos[];
				String linea;
				
				int codCurso,ciclo,creditos,horas;
				String asigna,tipoCurso,modali;
				
				
				 br = new BufferedReader(new FileReader("Curso.txt"));

				while ((linea = br.readLine()) != null) {
					miscursos= linea.split(";");
				    codCurso = Integer.parseInt(miscursos[0].trim());
				    asigna=miscursos[1].trim();
				    ciclo=Integer.parseInt(miscursos[2].trim());
				    creditos=Integer.parseInt(miscursos[3].trim());
				    tipoCurso=miscursos[4].trim();
				    modali=miscursos[5].trim();
				    horas=Integer.parseInt(miscursos[6].trim());
				    cursos.add(new Curso(codCurso, asigna, ciclo, creditos, tipoCurso, modali, horas));
				}
				
				br.close();
			
		} catch (Exception e) {
			
		}
		
	}
	
	
	public void ordenarPorCodigo() {
	    cursos.sort((a, b) -> Integer.compare(a.getCodCurso(), b.getCodCurso()));
	}
	
	
	public Curso buscarPorAsignatura(String asignatura) {
	    for (int i = 0; i < cursos.size(); i++) {
	        Curso c = cursos.get(i);
	        if (c.getAsignatura().equalsIgnoreCase(asignatura)) {
	            return c;
	        }
	    }
	    return null;
	}
	
	
		
		

}