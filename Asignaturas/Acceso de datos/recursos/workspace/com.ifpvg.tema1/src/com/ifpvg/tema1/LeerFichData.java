package com.ifpvg.tema1;

import java.io.*;

public class LeerFichData {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fichero = new File("FichData.txt");
		FileInputStream filein = new FileInputStream(fichero);
		DataInputStream dataIS= new DataInputStream(filein);
		
		String n;
		int e;
		
		try {
			while(true) {
				n=dataIS.readUTF(); //lee una cadena escrita con wrtieUFT 
				
				
				
				e=dataIS.readInt();
				
				System.out.println("Nombre: " + n + ", edad: " + e + ", más tres: " + (e+3));
			}
		}catch(EOFException eo) {}
		
		dataIS.close();

	}

}
