package com.ifpvg.tema1;

import java.io.File;

public class Actividad1 {

	public static void main(String[] args) {
		File f = new File(args[0]);
		System.out.println("Ficheros en el directorio actual");
		
		String[] archivo = f.list();
		
		for(int i=0;i<archivo.length;i++) {
			System.out.println(archivo[i]);
		}

	}

}
