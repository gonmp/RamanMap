package raman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArchivoTexto {
    private Scanner entrada;
    private Formatter salida;
    private int x, y;
   
    
    
	public void abrirArchivo(File file){
		try{
			entrada = new Scanner(file);
		}
		catch(FileNotFoundException fileNotFooundExceptio){
			System.out.println("Error al abrir archivo");
			System.exit(1);
		}
	}
	
	public void abrirArchivoDos(File file2){
		try{
			salida = new Formatter(file2);
		}
		catch(SecurityException securityException){
			System.err.println("No tiene acceso de escritura a este archivo");
			System.exit(1);			
		}
		catch(FileNotFoundException filesNotFoundException){
			System.out.println("Error al crear archivo");
			System.exit(1);
		}
	}
	
	public void leerDato(int cantidadEspectros, int puntosPorEspectro){
		RegistroDato registro = new RegistroDato();
		
		
		try{
                        
                        
                       
            y = puntosPorEspectro + 1;
            x = (puntosPorEspectro*cantidadEspectros) + 1;
			int matrizDos[][] = new int[x][4];
			double matriz[][] = new double[x][4];
			double matrizTres[][] = new double[y][57];
			registro.establecerX(entrada.nextInt());
			registro.establecerY(entrada.nextInt());
			registro.establecerRamanShift(entrada.nextDouble());
			registro.establecerIntensidad(entrada.nextDouble());
			int u = registro.obtenerX();
			int v = registro.obtenerY();
			matrizDos[0][0] = u;
			matrizDos[0][1] = v;
			matriz[0][0] = registro.obtenerRamanShift();
			matriz[0][1] = registro.obtenerIntesidad();
			int i = 1;
			
			while(entrada.hasNext()){
				
				registro.establecerX(entrada.nextInt());
				registro.establecerY(entrada.nextInt());
				registro.establecerRamanShift(entrada.nextDouble());
				registro.establecerIntensidad(entrada.nextDouble());
				matrizDos[i][0] = registro.obtenerX();
				matrizDos[i][1] = registro.obtenerY();
				matriz[i][0] = registro.obtenerRamanShift();
				matriz[i][1] = registro.obtenerIntesidad();
				i++;
				
				}
			matrizDos[x-1][0] = 0;
			matrizDos[x-1][1] = 0;
			i = 0;
			int j = 1;
			int h = 0;
					
			while(u == matrizDos[i][0] && v == matrizDos[i][1]){
				matrizTres[i][0] = matriz[i][0];
				i++;
				h++;
			}
			
			i = 0;
			
			for(int k = 0; k < x; k++){
				if(u == matrizDos[k][0] && v == matrizDos[k][1]){
                	matrizTres[i][j] = matriz[k][1];
                	i++;
                	
                } else {
                	j++;
                	i = 0;
                	matrizTres[i][j] = matriz[k][1];
                	u = matrizDos[k][0];
                	v = matrizDos[k][1];
                	i++;
                	
                }
               
				
				
			}
			
			
			i = 0;
			j = 0;
			
			for(int p = 0; p < h; p++){
				for(int q = 0; q <= cantidadEspectros; q++){
					if(q == 0){
						salida.format("%.3f ", matrizTres[p][q]);
					} else{
						salida.format("%.2f ", matrizTres[p][q]);
					}
					
				}
				salida.format("\r\n");
			}
		}
		catch(NoSuchElementException elementException){
			System.err.println("El archivo no esta bien formado.");
			entrada.close();
			System.exit(1);
		}
		catch(IllegalStateException elementException){
			System.err.println("Error al leer del archivo.");
			System.exit(1);
		}
	}
	public void cerrarArchivo(){
		if(entrada != null){
			entrada.close();
		}
	}
	public void cerrarArchivoDos(){
		if(salida != null){
			salida.close();
		}
	}
}
