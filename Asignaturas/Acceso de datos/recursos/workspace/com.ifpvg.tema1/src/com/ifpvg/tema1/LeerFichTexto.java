package com.ifpvg.tema1;
import java.io.*;
import java.io.FileReader;

public class LeerFichTexto {

	public static void main(String[] args) throws IOException {
		//File fichero= new File("C:\Users\LENOVO\Documents\Curso 2� Elena\Acceso a datos\Tema 1\Workspace\com.ifpvg.tema1\NUEVODIR");
		File fichero= new File("Prueba.txt");
		//File fichero= new File ("Fichtexto.txt");	
		FileReader fic= new FileReader (fichero);
		int i; 
		i=fic.read();
		
		while(i != -1) {
			System.out.println((char) i);
			//System.out.println(i);
			i=fic.read();
		}
		fic.close();

	}

}
