package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


public class Modificacion {

	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("equipos.db");
		
		//busco jugadores con nombre maria
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre","Maria"));
		
		Objects<Jugadores> objects = odb.getObjects(query);
		Jugadores juga = (Jugadores) objects.getFirst();
		juga.setDeporte("vóley-playa");
		odb.store(juga);
		
		//BORRAR
		//odb.delete(juga);
		
		System.out.println("Jugadores cambiando el deporte a la primera Maria: " + objects.size());
		
		int i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		odb.close();
		
		// TODO Auto-generated method stub
		/*ODB odb = ODBFactory.open("neodatis.test");
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
		query.orderByAsc("nombre,edad");
		
		Objects<Jugadores> objects = odb.getObjects(query); //obtiene todos los jugadores
		
		Jugadores j = (Jugadores) odb.getObjects(query).getFirst(); //obtiene solo el primer jugador*/
	}

}
