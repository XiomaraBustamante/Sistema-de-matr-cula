package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Alumno;

public class ArregloAlumnos {

private ArrayList<Alumno> alum; 
	
//  Constructor
    public ArregloAlumnos() {
    	alum = new ArrayList<Alumno>();
    	listarAlumnos();
	
}
    

    
 // TAMAÑO
    public int tamano() {
		return alum.size();
	}
    
 // OBTENER
    public Alumno obtener(int posi) {
	return alum.get(posi);
    }
    
 // ADICIONAR
    public void adicionar(Alumno a) {
	alum.add(a);
	
    }
    
 // ELIMINAR
    public void eliminar(Alumno a) {
	alum.remove(a);
    }
    

    /** FIN OPERACIONES BÁSICAS **/
    
 
 // Buscar el alumno por su codigo
    public Alumno buscar(int codAlumno) {
    for (int x=0;x<tamano();x++) {
        if (obtener(x).getCodAlumno() == codAlumno)
    	return obtener(x);
    }
    return null;
    }

    
////Metodo que permite registrar datos
//a un archivo de texto
public void grabarAlumnos() {
	try {
		
		PrintWriter pw;
		
		Alumno objA;
		
		String linea;
		
	 pw =new PrintWriter(new FileWriter("alumno.txt"));
	 
	 for(int x=0;x<tamano();x++) {
		 
		 objA=alum.get(x);
		 
		 linea=objA.getCodAlumno()+";"+
		       objA.getNombres()+";"+
			objA.getApellidos()+";"+
		    objA.getDni()+";"+
			objA.getEdad()+";"+
		    objA.getCelular()+";"+
			objA.getCorreo()+";"+
		    objA.getDirec()+";"+
			objA.getEstado();
		    
          pw.println(linea);
		 
			
			
		}
	 
		pw.close();
	} catch (Exception e) {
		
	}
}

    
  //metodo para listar los datos de las personas
public void listarAlumnos() {
	alum.clear(); 
	
	try {
		BufferedReader br;
		
		String misdatos[];
		
		String linea;
		
		int codAlumno, edad, celular, estado;
		String nombres, apellidos, dni, correo, direccion;
		
		 br = new BufferedReader(new FileReader("alumno.txt"));
		
		while ((linea = br.readLine()) != null) {
			misdatos=linea.split(";");
			
			
			codAlumno = Integer.parseInt(misdatos[0].trim());
			nombres = misdatos[1].trim();
			apellidos = misdatos[2].trim();
			dni = misdatos[3].trim();
			edad = Integer.parseInt(misdatos[4].trim());
			celular = Integer.parseInt(misdatos[5].trim());
			correo = misdatos[6].trim();
			direccion = misdatos[7].trim();
			estado = Integer.parseInt(misdatos[8].trim());
			alum.add(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, correo, direccion, estado));
		}
		br.close();
	} catch (Exception e) {
		
	}
}



//validar si hay similares dnis
public boolean existeDni(String dni) {
    for (int x = 0; x < tamano(); x++) {
        if (alum.get(x).getDni().equalsIgnoreCase(dni)) {
            return true;
        }
    }
    return false;
}

//Validar si ya existe un celular registrado
public boolean existeCelular(int celular) {
 for (int x = 0; x < tamano(); x++) {
     if (alum.get(x).getCelular() == celular) {
         return true;
     }
 }
 return false;
}

//Validar si ya existe un correo registrado
public boolean existeCorreo(String correo) {
 for (int x = 0; x < tamano(); x++) {
     if (alum.get(x).getCorreo().equalsIgnoreCase(correo)) {
         return true;
     }
 }
 return false;
}


//Para MODIFICAR (evita comparar con el mismo alumno)
public boolean existeCorreoEnOtro(String correo, int codigoAlumno) {
 for (int i = 0; i < tamano(); i++) {
     Alumno a = obtener(i);
     if (a.getCodAlumno() != codigoAlumno &&
         a.getCorreo().equalsIgnoreCase(correo)) {
         return true;
     }
 }
 return false;
}

public boolean existeCelularEnOtro(int celular, int codigoAlumno) {
 for (int i = 0; i < tamano(); i++) {
     Alumno a = obtener(i);
     if (a.getCodAlumno() != codigoAlumno &&
         a.getCelular() == celular) {
         return true;
     }
 }
 return false;
}



//OPERACIONES PÚBLICAS COMPLEMENTARIAS
public int codigoCorrelativo() {
if (tamano() == 0)
    return 202110001;// retorna el numero en que empieza la tabla
else
    return obtener(tamano() - 1).getCodAlumno() + 1;
}


//cambiar
public void cambiarEstadoAlumno(int codAlumno, int nuevoEstado) {
    Alumno a = buscar(codAlumno);
    if (a != null) {
        a.setEstado(nuevoEstado);
        grabarAlumnos();
    }
}


    
}
    
