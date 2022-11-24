package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import org.neodatis.odb.Values;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;

public class Actividad8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("equipos.db");
		
		//en equipos.db no hay ningun jugador de españa con 15 años. con 14 me salen 2, maria y alicia
		System.out.println("Cantidad de deportistas españoles con 15 años:");
		Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class, new And().add(Where.equal("pais.nombrepais","España")).add(Where.equal("edad",15))).count("nombre"));
		while(valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();
			System.out.println(objectValues.getByIndex(0));
		}
		
		odb.close();
		
		

	}

}
