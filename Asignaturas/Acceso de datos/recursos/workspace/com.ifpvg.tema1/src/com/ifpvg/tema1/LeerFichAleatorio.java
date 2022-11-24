package com.ifpvg.tema1;
import java.io.*;
public class LeerFichAleatorio {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fichero=new File("Aleatorio.dat");
		///declara el fichero e acceso aleatorio
		RandomAccessFile file= new RandomAccessFile(fichero, "r");
		
		int id, dep, posicion;
		double salario;
		char apellido[]= new char[10], aux;
		posicion=0; //para situarnos al principio
		
		for(;;) { //recorro el fichero
			file.seek(posicion); //nos  posicionamos en posicion
			id= file.readInt(); //obtengo el id de empleado
			for(int i=0; i<apellido.length; i++) {
				aux= file.readChar(); //recorro uno a uno los caracteres del apellido
				apellido[i] = aux; //los voy guardando en el array
				
			}
			String apellidos= new String(apellido); //convierto a string el array
			dep=file.readInt(); //obtengo el dpto
			salario= file.readDouble(); //obtengo el salario
			
			System.out.println("ID: " + id + ", Apellido: " + apellidos + ", Departamento: " + dep + ", Salario: " + salario);
			posicion=posicion+36; //me posiciono para el siguiente empleado
								  //cada empleado ocupa 36 bytes (4+20+4+8)
			//si he recorrido todos los bytes salgo del for
			if(file.getFilePointer()==file.length())break;
		}
		
		file.close();
	}

}
