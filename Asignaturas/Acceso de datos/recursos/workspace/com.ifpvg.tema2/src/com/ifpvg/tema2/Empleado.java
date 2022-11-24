package com.ifpvg.tema2;

import java.util.*;

public class Empleado {
	private int numero;
	private String apellidos;
	private String oficio;
	private int dir;
	private Date fecha;
	private float salario;
	private float comision;
	private byte dpto;
	
	public Empleado() {
		
	}

	public Empleado(int numero, String apellidos, String oficio, int dir, Date fecha, float salario, float comision,
			byte dpto) {
		super();
		this.numero = numero;
		this.apellidos = apellidos;
		this.oficio = oficio;
		this.dir = dir;
		this.fecha = fecha;
		this.salario = salario;
		this.comision = comision;
		this.dpto = dpto;
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

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public byte getDpto() {
		return dpto;
	}

	public void setDpto(byte dpto) {
		this.dpto = dpto;
	}
}
