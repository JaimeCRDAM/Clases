package com.ifpvg.tema1;
import java.io.*;

public class EscribirFichTexto {
	public static void main(String[] args) throws IOException{
		File fichero = new File ("fichtexto.txt");
		FileWriter fic= new FileWriter(fichero);
		//para añadir al final del fichero: ...(fichero, true)
		String cadena =("\r\n Esto es una prueba con FileWriter23456\r\n otra linea");
		//\n indica nueva linea y \r indica retorno de carro. de ahi que en las cadenas que contengan \ se deba poner \\
		
		//char[] cad = cadena.toCharArray();
		
		//for(int i=0; i<cad.length;i++)
			//fic.write(cad[i]);
		
		//fic.write(cad); //esta opcion escribe directamente el array de caracteres
		
		fic.write(cadena);//esta opcion escribe directamente el string
		
		fic.append('*');
		fic.close();
	}

}
