package com.ifpvg.tema1;
import java.io.*;

public class EscribirFichData {

	public static void main(String[] args) throws IOException{
		File fichero = new File("FichData.txt");
		FileOutputStream fileout = new FileOutputStream(fichero);
		DataOutputStream dataOS= new DataOutputStream(fileout);
		
		String nombres[]= {"Ana", "Luis Miguel", "Alicia", "pedro", "Manuel", "andres", "julio", "antonio", "MAria Jesús"};
		int edades[]= {14, 15, 13, 15, 16, 12, 16, 14, 13};
		
		for (int i=0; i<edades.length; i++) {
			dataOS.writeUTF(nombres[i]); 	//si leemos fichdata.txt con el nlock de notas
											// se leen los caracteres y los numeros no poque 
			//dataOS.writeBytes(nombres[i]);  //mismo resultado que el anterior
			//dataOS.writeChars(nombres[i]);  //igual que los anteriores pero cada caracter
			dataOS.writeInt(edades[i]);
		}
		
		dataOS.close();

	}

}
