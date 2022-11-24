package clases;

import java.io.Serializable;

public class Paises implements Serializable{

		
		
	private static final long serialVersionUID = 1L;
		private int id;
		private String nombrepais;
		
		public Paises() {}
		
		public Paises(int id, String nombrepais) {
			this.id = id;
			this.nombrepais = nombrepais;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombrepais() {
			return nombrepais;
		}

		public void setNombrepais(String nombrepais) {
			this.nombrepais = nombrepais;
		};
		
		
			
			
		


}
