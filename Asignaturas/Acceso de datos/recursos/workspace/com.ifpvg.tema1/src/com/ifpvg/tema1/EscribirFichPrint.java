package com.ifpvg.tema1;
import java.io.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichPrint {
	public static void main(String arg[]) {
		try {
			PrintWriter fichero= new PrintWriter (new FileWriter ("fichtexto.txt", true));
			
			for(int i=1; i<11; i++) {
				fichero.write("fila numero " + i);
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
