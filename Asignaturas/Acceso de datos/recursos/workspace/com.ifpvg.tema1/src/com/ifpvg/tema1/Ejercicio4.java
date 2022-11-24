package com.ifpvg.tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader ficheroR = new BufferedReader(new FileReader(args[0]));
			BufferedWriter ficheroW =  new BufferedWriter(new FileWriter(args[1]));
			
			String linea;
			
			while((linea=ficheroR.readLine())!=null) {
				ficheroW.write(linea);
				ficheroW.newLine();
				
			}
			ficheroW.close();
			ficheroR.close();
		}catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		}catch (IOException ioe) {
			System.out.println("Error de E/S");
		}

	}

}

/* file lectura= new=file(args[0]);
 * FileREader ficlec= new FileREader(lectura);
 * 
 * dile escritura = new file(args[1];
 * filewriter ficesc= new filewriter(Escritura);
 * 
 * int i;
 * 
 * while((i=ficlec.read()) != -1){
 * 
 *ficesc.write((char) i);
 *
 *ficlec.close();
 *ficesc.close();
 */
 * 
