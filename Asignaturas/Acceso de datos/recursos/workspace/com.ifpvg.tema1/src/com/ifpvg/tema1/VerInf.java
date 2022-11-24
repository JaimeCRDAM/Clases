package com.ifpvg.tema1;

import java.io.File;

public class VerInf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println("INFORMACION SOBRE EL FICHERO:\n");
		
		File f = new File ("./src/com/ifpvg/tema1/verdir.java");
		if(f.exists()) {
			
			System.out.println("Nombre del fichero: 		"+f.getName());
			System.out.println("Ruta: 						"+f.getPath());
			System.out.println("Ruta Absoluta				"+f.getAbsolutePath());
			System.out.println("Se puede escribir:			"+f.canRead());
			System.out.println("Se puede leer				"+f.canWrite());
			System.out.println("Tamaño						"+f.length());
			System.out.println("Es un directorio			"+f.isDirectory());
			System.out.println("Es un fichero:				"+f.isFile());
			
		}else System.out.println("El fichero no existe");

	}

}
