package com.ifpvg.tema1;
import java.io.*;
public class Ampliacion2 {

	public static void main(String[] args) throws IOException {

		int dep[] = {20,30,10,40,100,7,58,101};
		String nombre[] = {"Direccion","Compras","Contabilidad","Ventas","Nóminas","No","Tampoco","Excede"};
		String localidad[]= {"Madrid","Puertollano","Madrid","Ciudad Real","Valdepeñas","No","Tampoco","Excede"};
		File fichero = new File ("Optimo.dat");
		char departamento[] = new char[15];
		char loc[] = new char[18];
		int idDep = 0;
		
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		StringBuffer buffer1 = null;
		StringBuffer buffer2 = null;
		
		for (int i = 0; i < dep.length; i++) {
			if (dep[i] % 10 == 0 && dep[i] < 101) {
				long posicion = (dep[i]/10-1)*70;
				file.seek(posicion);
				file.writeInt(dep[i]);
				
				buffer1 = new StringBuffer(nombre[i]);
				buffer1.setLength(15);			
				file.writeChars(buffer1.toString());
				
				buffer2 = new StringBuffer(localidad[i]);
				buffer2.setLength(18);			
				file.writeChars(buffer2.toString());				
			}
			else {
				System.out.println(dep[i]+" no es un número de departamento válido para este ejercicio");
			}
		}
		file.close();
	}

}
