package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Retiro;



public class ArregloRetiro {
	
	private ArrayList<Retiro> reti;
	
	// Constructor
    public ArregloRetiro() {
        reti = new ArrayList<>();
        
    }
    
 // Adicionar
    public void adicionar(Retiro r) {
        reti.add(r);
    }

    // Tamaño
    public int tamano() {
        return reti.size();
    }

    // Obtener
    public Retiro obtener(int posi) {
        return reti.get(posi);
    }

    // Eliminar
    public void eliminar(Retiro m) {
        reti.remove(m);
        
    }
    
    
    // Buscar por número de retiro
    public Retiro buscar(int numRetiro) {
        for (int x=0; x<tamano();x++) {
            if (obtener(x).getNumRetiro() == numRetiro)
                return obtener(x);
        }
        return null;
    }
    
    
    // Generar código correlativo
    public int generarCodigo() {
        if (tamano() == 0) {
            return 200001; // primer número de matrícula
        } else {
            return obtener(tamano() - 1).getNumRetiro() + 1;
        }
    }
    
    
    public void grabarRetiro() {
        try {
            PrintWriter pw;
            Retiro objR;
            String linea;

            pw = new PrintWriter(new FileWriter("retiro.txt"));
            for (int x = 0; x < tamano(); x++) {
                objR = reti.get(x);
                linea = objR.getNumRetiro() + ";" + 
                        objR.getNumMatri() + ";" + 
                        objR.getEspecialidad() + ";" +
                        objR.getCurso() + ";" +
                        objR.getCiclo()+ ";" +
                        objR.getMotivo() + ";" +
                        objR.getFecha() + ";" +
                        objR.getHora();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    //metodo para listar los datos de las personas
  public void listarRetiro() { 
  	
  	try {
  		BufferedReader br;
  		reti.clear(); 
  		String misretiros[];
  		
  		String linea;
  		
  		int numReti,numMatri;
  		String espe, curso, ciclo, motivo, fecha, hora;
  		
  		 br = new BufferedReader(new FileReader("retiro.txt"));
  		
  		while ((linea = br.readLine()) != null) {
  			misretiros=linea.split(";");
  			
  			
  			numReti = Integer.parseInt(misretiros[0].trim());
  			numMatri = Integer.parseInt(misretiros[1].trim());
  			espe = misretiros[2].trim();
  			curso = misretiros[3].trim();
  			ciclo = misretiros[4].trim();
  			motivo=misretiros[5].trim();
  			fecha=misretiros[6].trim();
  			hora=misretiros[7].trim();
  			reti.add(new Retiro(numReti, numMatri, curso, espe, ciclo, fecha, hora, motivo));
  		}
  		br.close();
  	} catch (Exception e) {
  		
  	}
  	
  	
  	
  	
  }

public int obtenerUltimoCodigo() {
	if (reti.isEmpty()) return 200000; // o el número base
    return reti.get(reti.size() - 1).getNumRetiro();
}
  		
    
    
    
    
    

}


