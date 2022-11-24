package com.ifpvg.tema1;
import java.io.*;

public class EscribirFichTextoBuf {
	public static void main(String arg[]) {
		try {
			
			//si ponemos la ruta en filewriter nos podemos ahorrar declarar: File fichero= new 
			//pongo true al filewriter para que añada lineas al final sin destruir el fichero
			
			BufferedWriter fichero= new BufferedWriter (new FileWriter ("fichtexto.txt", true));
			
			for(int i=1; i<11; i++) {
				fichero.write("fila numero " + i);
				fichero.newLine();//salto de linea
			}
			fichero.close();
		}
		catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		}
		catch(IOException e) {
			System.out.println("Error de E/S");
		}
	}
}
