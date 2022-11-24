package com.ifpvg.tema2;

public class Departamento {
	private byte dpto;
	private String dnombre;
	private String loc;
	
	
	
	public Departamento() {
		this.dpto = 0;
		this.dnombre = null;
		this.loc = null;
	}

	public Departamento(byte dpto, String dnombre, String loc) {
		this.dpto = dpto;
		this.dnombre = dnombre;
		this.loc = loc;
	}

	public byte getDpto() {
		return dpto;
	}

	public void setDpto(byte dpto) {
		this.dpto = dpto;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
