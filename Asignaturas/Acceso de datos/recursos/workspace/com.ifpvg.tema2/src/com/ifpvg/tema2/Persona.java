package com.ifpvg.tema2;

public class Persona {
	//VARIABLES
		private String nombre;
		private String ciudad;
		
		//CONSTRUCTOR
		public Persona() {
			this.nombre = null;
			this.ciudad = null;
		}

		public Persona(String nombre, String ciudad) {
			super();
			this.nombre = nombre;
			this.ciudad = ciudad;
		}

		//GETTER AND SETTER
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
}