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

public class Consultasbis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("equiposbis.db");
		
		//where edad = 14 and (ciudad like 'Madrid' or ciudad like 'Guadalajara')
		
		ICriterion criterioOR = new Or().add(Where.equal("ciudad", "Madrid")).add(Where.equal("ciudad", "Guadalajara"));
		ICriterion criterio = new And().add(criterioOR).add(Where.equal("edad",14));
		
		//ICriterion criterio = new And().add(Where.equal("edad", 14))
		//		.add(new Or().add(Where.equal("ciudad", "Madrid")).add(Where.equal("ciudad", "Guadalajara")));
		CriteriaQuery query = new CriteriaQuery(Jugadores.class,criterio);
		Objects<Jugadores> objects = odb.getObjects(query);
		
		System.out.println("Jugadores con 14 años y de Madrid o Guadalajara: " + objects.size());
		
		int i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}

	}

}
