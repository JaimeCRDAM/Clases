package com.ifpvg.tema1;
import java.io.*;
public class Ampliacion1 {

	public static void main(String[] args) throws IOException{
		//4,4,30,36 <---- posiciones del puntero

				File fichero = new File("Departamentos.dat");
				RandomAccessFile file = new RandomAccessFile(fichero, "rw");

				char departamento[] = new char[15];
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
					
					//sacamos departamento
					for (int i = 0; i < departamento.length; i++) {
						departamento[i] = file.readChar();
					}

					//sacamos locadidad
					for (int i = 0; i < localidad.length; i++) {
						localidad[i] = file.readChar();
					}
					
					
					file.seek(posicion);
					
					// Sobreescribo el dept
					file.writeInt(0);
					
					//sacamos departamento
					for (int i = 0; i < 15; i++) {
						file.writeChar(' ');
					}

					//sacamos locadidad
					for (int i = 0; i < 18; i++) {
						file.writeChar(' ');
					}			
					String dep = new String(departamento);
					String loc = new String(localidad);
					
					System.out.println("los datos borrados son: Numero dept "
							+ ""+idDep+" departamento "+dep+" localidad "+loc);

				}
				file.close();
			}

		}
