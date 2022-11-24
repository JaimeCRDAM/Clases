package com.ifpvg.tema1;
import java.io.*;
public class Ejercicio2 {

	public static void main(String[] args) throws IOException{
		//4,4,30,36 <---- posiciones del puntero

				File fichero = new File("Departamentos.dat");
				RandomAccessFile file = new RandomAccessFile(fichero, "rw");

				char nombre[] = new char[15];
				char localidad[] = new char[18];
				int idDep;
				int registro = Integer.parseInt(args[0]);
				long posicion = (registro - 1) * 70;
				

				
				if (posicion >= file.length()) {
					System.out.println("El departamento con ID: " + registro + " no encontrado...");
				} else {
					file.seek(posicion);
					
					//sacamos id departamento
					idDep = file.readInt();
					
					//sacamos el nombre del departamento
					for (int i = 0; i < nombre.length; i++) {
						nombre[i] = file.readChar();
					}

					//sacamos locadidad
					for (int i = 0; i < localidad.length; i++) {
						localidad[i] = file.readChar();
					}
					
					String depart = new String (nombre);
					String loc = new String (localidad);
					
					System.out.println("Datos anteriores:");
					System.out.println("Numero Departamento: " +idDep+ ", Departamento: " + depart.trim()  + ", Localidad: " + loc.trim());
					

					StringBuffer buffer1 = null;
					StringBuffer buffer2 = null;
					String dep = args[1];
					String localidad1 = args[2];
					
					//nos colocamos en la posicion
					posicion = posicion + 4;
					file.seek(posicion);
					
					
					buffer1 = new StringBuffer(dep);
					buffer1.setLength(15);			
					file.writeChars(buffer1.toString());
					

					buffer2 = new StringBuffer(localidad1);
					buffer2.setLength(18);			
					file.writeChars(buffer2.toString());	
					
					
					System.out.println("Actualización: ");
					System.out.println("Numero Departamento: " +registro+ ", Departamento: " + dep  + ", Localidad: " + localidad1);
							
				}
				file.close();

			}

		


	}


