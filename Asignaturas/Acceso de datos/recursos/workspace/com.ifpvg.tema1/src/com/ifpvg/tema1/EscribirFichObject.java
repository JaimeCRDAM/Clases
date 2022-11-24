package com.ifpvg.tema1;
import java.io.*;

public class EscribirFichObject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Persona persona;
		File fichero = new File("FichPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream dataOS = new ObjectOutputStream(fichero);
		
		String nombres[]= {"Ana", "Luis Miguel", "Alicia", "pedro", "Manuel", "andres", "julio", "antonio", "MAria Jesús"};
		int edades[]= {14, 15, 13, 15, 16, 12, 16, 14, 13};
		
		for(int i=0; i<edades.length;i++) {
			persona=new Persona(nombrees[i],edades[i]);
			dataOS.WriteObject(persona);
		}
		dataOS.close();

	}

}
