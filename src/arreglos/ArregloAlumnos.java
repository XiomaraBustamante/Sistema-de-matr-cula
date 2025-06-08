package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import clases.Alumno;

public class ArregloAlumnos {

	private ArrayList<Alumno> alum; 
	
//  Constructor
    public ArregloAlumnos() {
    	alum = new ArrayList<Alumno>();
    	cargar();
	
}
    
 // ADICIONAR
    public void adicionar(Alumno x) {
	alum.add(x);
	grabar();
    }

    
//CARGANDO LOS DATOS DEL ALUMNO
private void cargar() {
	String linea;
	try {
	    BufferedReader br = new BufferedReader(new FileReader("alumno.txt"));
	    int codAlumno, edad, estado;
	    String nombres, apellidos, dni;
	    while ((linea = br.readLine()) != null) {
		String parte[] = linea.split(";");
		codAlumno = Integer.parseInt(parte[0].trim());
		nombres = parte[1].trim();
		apellidos = parte[2].trim();
		dni = parte[3].trim();
		edad = Integer.parseInt(parte[4].trim());
		estado = Integer.parseInt(parte[5].trim());
		adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, estado));
	    }
	    br.close();
	} catch (Exception e) {
	    System.out.println("Error de lectura alumno.txt: " + e.getMessage());
	}
	
}

private void grabar() {

	
}
    
}
    
