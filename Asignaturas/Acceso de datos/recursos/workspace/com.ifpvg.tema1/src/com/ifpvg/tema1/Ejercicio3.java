package com.ifpvg.tema1;
import java.io.*;
public class Ejercicio3 {

	public static void main(String[] args) throws IOException{

		
		//4,4,30,36 <---- posiciones del puntero

		File fichero = new File("Departamentos.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		int registro = Integer.parseInt(args[0]);
		long posicion = (registro - 1) * 70;
		int dep, contador= 0, var =0;
		
		
		

		
		if (posicion >= file.length()) {
			System.out.println("El departamento con ID: " + registro + " no encontrado...");
		} else {
			file.seek(posicion);
			
			
			// Sobreescribo el dept
			file.writeInt(0);
			
			//sacamos departamento
			/*for (int i = 0; i < 15; i++) {
				file.writeChar(' ');
			}*/

			//sacamos localidad
			/*for (int i = 0; i < 18; i++) {
				file.writeChar(' ');
			}	*/
			
			System.out.println("El departamento ha sido borrado.");
			
		}
		file.seek(var);
		while(file.getFilePointer() < file.length()) {
			dep= file.readInt();
			if (dep != 0) {
				contador++;
			}
			var+=70;
			//var = file.getFilePointer() +66;
			file.seek(var);
			
		}
		System.out.println("El numero total de departamentos es: " + contador);
		file.close();
	}

}
