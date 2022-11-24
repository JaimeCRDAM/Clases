package com.ifpvg.tema1;
import java.io.*;

public class LeerFichObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona;
		File fichero = new File("FichPersona.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectIntputStream dataIS =  new ObjectInputStream(filein);
		
		try {
			while(true) {
				persona=(Persona) dataIS.readObject();
				System.out.println("nombre: " + persona.getNombre()+ ", edad más tres: " + (persona.getEdad()+3));
			}
		}catch(EOFException eo) {}
		dataIS.close();
		

	}

}
