package com.ifpvg.tema1;
import java.io.*;
import java.io.FileReader;

public class LeerFichTexto20 {

	public static void main(String[] args) throws IOException {
		
		File fichero= new File("Prueba.txt");		
		FileReader fic= new FileReader (fichero);
		char b[]= new char[20];
		
		while((fic.read(b)) != - 1) {
			System.out.println(b);
		}
		fic.close();

	}

}