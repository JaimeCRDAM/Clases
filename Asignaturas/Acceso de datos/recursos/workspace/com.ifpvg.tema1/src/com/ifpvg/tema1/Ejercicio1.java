package com.ifpvg.tema1;

import java.io.*;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException{
		int dep[]= {20,30,10,40};
		String nombre[] = {"Direcci�n", "Compras", "Contabilidad", "Ventas"};
		String localidad[]= {"Madrid", "Puertollano", "Madrid", "Ciudad Real"};
		File fichero= new File ("Departamentos.dat");
		
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		StringBuffer buffer1 =  null;
		StringBuffer buffer2 = null;
		
		for(int i=0; i<dep.length; i++) {
			long posicion = (dep[i]-1)*70;
			file.seek(posicion);
			file.writeInt(dep[i]);
			System.out.println(posicion);
			System.out.println(dep[i]);
			
			buffer1 =  new StringBuffer(nombre[i]);
			buffer1.setLength(15);
			file.writeChars(buffer1.toString());
			
			buffer2 = new StringBuffer(localidad[i]);
			buffer2.setLength(18);
			file.writeChars(buffer2.toString());
		}
		file.close();
		
		
	}
}
