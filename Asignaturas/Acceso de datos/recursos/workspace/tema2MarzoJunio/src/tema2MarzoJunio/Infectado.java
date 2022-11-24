package tema2MarzoJunio;

public class Infectado {
	private int numero;
	private String apellidos;
	private String virus;
	private int edad;
	
	public Infectado() {
		this.numero = 0;
		this.apellidos = null;
		this.virus = null;
		this.edad = 0;
	}

	public Infectado(int numero, String apellidos, String virus, byte edad) {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
