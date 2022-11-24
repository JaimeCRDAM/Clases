package com.ifpvg.tema1;
import java.io.*;

public class LeerFichTextoBuf {
	public static void main (String args[]) {
		try {
			//si ponemos la ruta en filereader nos podemos ahorrar declarar: File fichero1=new File("....")
			File fichero1= new File ("Prueba.txt");
			//File fichero1= new FIle("Fictexto.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(fichero1));
			String linea;
			
			while((linea=fichero.readLine())!=null)
				System.out.println(linea);
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
