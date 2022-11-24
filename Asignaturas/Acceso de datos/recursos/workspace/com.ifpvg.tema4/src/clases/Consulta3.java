package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import org.neodatis.odb.Values;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;

public class Consulta3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ODB odb = ODBFactory.open("equipos.db");
		
		Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("nombre").field("edad").field("pais.nombrepais"));
		while (valores.hasNext()) {
			ObjectValues objetos = (ObjectValues) valores.next();
			System.out.println("Nombre: " + objetos.getByAlias("nombre")+ " - Edad: " + objetos.getByIndex(1) + " - Pais: " + objetos.getByIndex(2));
		}
		
		System.out.println("Nombre y ciudad de deportistas españoles:");
		Values valores1 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class,Where.equal("pais.nombrepais","España")).field("nombre").field("ciudad"));
		while (valores1.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores1.next();
			System.out.println(objectValues.getByAlias("nombre") + " * " + objectValues.getByAlias("ciudad"));
		}
		
		System.out.println("Nombre y ciudad de deportistas españoles con 14 años:");
		Values valores2 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class, new And().add(Where.equal("pais.nombrepais","España")).add(Where.equal("edad",14))).field("nombre").field("ciudad"));
		while(valores2.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores2.next();
			System.out.println(objectValues.getByAlias("nombre") + " * " + objectValues.getByAlias("ciudad"));
		}
		
		odb.close();
		
	}

}
