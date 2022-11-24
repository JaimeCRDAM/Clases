package com.ifpvg.tema1;
import java.io.Serializable;

public class Persona1 implements Serializable{

	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	private int edad;
}
