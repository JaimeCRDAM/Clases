package com.ifpvg.tema2;

public class Infectado {
	private int numero;
	private String apellidos;
	private String virus;
	private byte edad;
	
	public Infectado() {
		this.numero=0;
		this.apellidos=null;
		this.virus= null;
		this.edad=0;
	}

	public Infectado(int numero, String apellidos, String virus, byte edad) {
		super();
		this.numero = numero;
		this.apellidos = apellidos;
		this.virus = virus;
		this.edad = edad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getVirus() {
		return virus;
	}

	public void setVirus(String virus) {
		this.virus = virus;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}
	
	
}
