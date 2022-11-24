package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


public class Actividad7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ODB odb = ODBFactory.open("equipos.db");
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
		query.orderByAsc("nombre,edad");
		
		Objects<Jugadores> objects = odb.getObjects(query); //obtiene todos los jugadores
		
		//Jugadores j = (Jugadores) odb.getObjects(query).getFirst(); //obtiene solo el primer jugador
	
		int i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
	
	}

}
