package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Actividad8bis {

	public static void main(String[] args) {
		
				ODB odb = ODBFactory.open("equipos.db");
				
				//para cada pais visualizar el numero de jugadores que tiene
				System.out.println("Cantidad de deportistas por pais: ");
				Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("pais.nombrepais").count("nombre").groupBy("pais.nombrepais"));
				while(valores.hasNext()) {
					ObjectValues objectValues = (ObjectValues) valores.next();
					System.out.println("Jugadores de " + objectValues.getByIndex(0) + ": " + objectValues.getByIndex(1));
				}
				
				odb.close();

	}

}
