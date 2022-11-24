package com.ifpvg.tema1;

import java.io.*;
import java.io.RandomAccessFile;

public class Recupera {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fichero = new File("Departamentos.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		//int registro = Integer.parseInt(args[0]);
		//long posicion = (registro - 1) * 70;
		int dep, contador= 0, var =0, v=0;
		
		file.seek(var);
		while(file.getFilePointer() < file.length()) {
			dep= file.readInt();
			if (dep == 0) {
				if(((int) file.readChar()) != 0) {
					file.seek(var);
					v= (var/70)+1;
					System.out.println("El departamento: " + v + " FUE RECUPERADO.");
					file.writeInt(v);
 				}else {
 					v= (var/70)+1;
 					dep= (v - 1);
					System.out.println("El departamento: " + dep + " nunca existio.");
				}
			}
			
			var+=70;
			//var = file.getFilePointer() +66;
			file.seek(var);
			
		}
		

	}

}
