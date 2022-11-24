package com.ifpvg.tema1;
import java.io.File;

public class verDir {

	public static void main(String[] args) {
		System.out.println("Ficheros en el directorio actual");
		
		//File f = new File(".");
		//File f = new File("c\");
		//File f = new File("c:\\");
		File f = new File("C:\\Users\\dam201\\Desktop\\proyectos Eclipse\\com.ifpvg.tema1\\src\\com\\ifpvg\\tema1");
		
		String[] archivo = f.list();
		
		for(int x = 0;x < archivo.length;x++) {
			System.out.println(archivo[x]);
		}
	}

}
