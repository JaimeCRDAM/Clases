package com.ifpvg.tema1;
import java.io.*;

public class Cesar3 {

	public static void main(String[] args) throws IOException{
		try {
			
			File fichero= new File(args[0]);
			FileReader filec= new FileReader(fichero);
			
			File escritura= new File(args[1]);
			FileWriter files= new FileWriter(escritura);
			
			int numCaracter;
			
			while((numCaracter = filec.read()) != -1) {
				if(numCaracter > 64 && numCaracter < 91 || numCaracter > 96 && numCaracter < 123) {
					numCaracter += 3;
					files.write(numCaracter);
				}else {
					if(numCaracter >87 && numCaracter < 91 || numCaracter >119 && numCaracter <123) {
						numCaracter -=23;
						files.write(numCaracter);
					}else {
						files.write(numCaracter);
					}
				}
				
			}
			filec.close();
			files.close();
			
			
			
		}catch(FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
			
		}catch (IOException ioe) {
			System.out.println("Error de E/S");
			
		}

	}

}
