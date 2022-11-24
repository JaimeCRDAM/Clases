package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Not;
import org.neodatis.odb.core.query.criteria.ICriterion;

public class Actividad6bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Paises p1 = new Paises(33,"Francia");
		Paises p2 = new Paises(34,"España");

		Jugadores j1 = new Jugadores("Pedro","voleibol","Madrid",14,p2);
		Jugadores j2 = new Jugadores("Fran","tenis","Guadalajara",14,p1);
		Jugadores j3 = new Jugadores("David","baloncesto","Madrid",15,p1);
		Jugadores j4 = new Jugadores("Santiago","tenis","Guadalajara",15,p2);
		Jugadores j5 = new Jugadores("Javier","tenis","Daimiel",14,p2);
		
		ODB odb = ODBFactory.open("equiposbis.db");
		odb.store(p1);
		odb.store(p2);
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		odb.store(j5);
		
		//Recuperar todos los objetos
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		System.out.println(objects.size() + " Jugadores:");
		
		int i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		odb.close();

	}

}
