package com.ifpvg.tema2;

import com.db4o.Db4oEmbedded;

public class Main {
		final static String BDPer = "DBPersonas.yap";

		public static void main(String[] args) {

			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
			Persona p1 = new Persona("Juan", "Guadalajara");
			Persona p2 = new Persona("Makario", "Ciudad Real");
			Persona p3 = new Persona("Carlos", "Toledo");
			Persona p4 = new Persona("Pedro", "Guadalajara");

			db.store(p1);
			db.store(p2);
			db.store(p3);
			db.store(p4);

			Persona per = new Persona(null, null);
			ObjectSet<Persona> result = db.queryByExample(per);
			if (result.size() == 0) {
				System.out.println("No existen registros personas");
			} else {
				System.out.println("Número registros: " + result.size());
			}

			while (result.hasNext()) {
				Persona p = result.next();
				System.out.println("NOMBRE: " + p.getNombre() + " CIUDAD: " + p.getCiudad());
			}

			// modificar datos
			System.out.println();
			System.out.println("modificamos la ciudad de juan(guadalajara) por toledo");
			ObjectSet<Persona> resulta = db.queryByExample(new Persona("Juan", null));

			if (resulta.size() == 0) {
				System.out.println("No existen juan");
			} else {
				Persona existe = (Persona) resulta.next();
				existe.setCiudad("Toldedo");
				db.store(existe);
				resulta = db.queryByExample(new Persona("Juan", null));
				existe = (Persona) resulta.next();
				System.out.println("Nombre: " + existe.getNombre() + " Nueva ciudad: " + existe.getCiudad());

			}
			
			System.out.println();
			System.out.println("Borramos los datos de pedro");
			// Borro los datos de Juan
			ObjectSet<Persona> resultaKill = db.queryByExample(new Persona("Pedro", null));
			if (resultaKill.size() == 0) {
				System.out.println("no hay Pedros");
			} else {
				System.out.println("Registros a borrar: " + resultaKill.size());
				while (resultaKill.hasNext()) {
					Persona existe = (Persona) resultaKill.next();
					db.delete(existe);
				}
			}
			
			
			
			db.close();
		}

	}


