package com.ifpvg.tema1;
import java.io.*;

public class Actividad2 {

	public static void main(String[] args) throws IOException {
		File fichero = new File("Fichtext.txt");
		FileWriter fwr= new FileWriter(fichero, true);
		String cadena= ("Esto es una prueba con FileWriter\n");
		
		fwr.write(cadena);
		fwr.append('*');
		fwr.close();
		

	}

}
