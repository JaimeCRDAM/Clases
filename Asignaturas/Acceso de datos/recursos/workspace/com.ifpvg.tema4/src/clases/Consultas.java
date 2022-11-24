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


public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("equipos.db");
		
		ICriterion criterio = Where.equal("edad", 14);
		CriteriaQuery query = new CriteriaQuery(Jugadores.class,criterio);
		Objects<Jugadores> objects = odb.getObjects(query);
		
		System.out.println("Jugadores de 14 años: " + objects.size());
		
		int i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		//-----------------------
		
		criterio = Where.like("nombre", "M%");
		query = new CriteriaQuery(Jugadores.class,criterio);
		objects = odb.getObjects(query);
		
		System.out.println("Jugadores cuyo nombre empieza por M: " + objects.size());
		
		i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		
		//-----------------------
		//gt es greater than
		
		criterio = Where.gt("edad", 14);
		query = new CriteriaQuery(Jugadores.class,criterio);
		objects = odb.getObjects(query);
		
		System.out.println("Jugadores mayores de 14 años: " + objects.size());
		
		i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		//-----------------------
		
		criterio = new And().add(Where.equal("ciudad", "Madrid")).add(Where.equal("edad", 15));
		query = new CriteriaQuery(Jugadores.class,criterio);
		objects = odb.getObjects(query);
		
		System.out.println("Jugadores de Madrid y con 15 años: " + objects.size());
		
		i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		//-----------------------
		//ge es mayor o igual (greater equal)
		
		criterio = new Or().add(Where.equal("ciudad", "Madrid")).add(Where.ge("edad", 15));
		query = new CriteriaQuery(Jugadores.class,criterio);
		objects = odb.getObjects(query);
		
		System.out.println("Jugadores de Madrid o con 15 años o mas: " + objects.size());
		
		i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		//-----------------------
		
		criterio = Where.not(Where.like("nombre", "M%"));
		query = new CriteriaQuery(Jugadores.class,criterio);
		objects = odb.getObjects(query);
		
		System.out.println("Jugadores cuyo nombre no comienza por M: " + objects.size());
		
		i = 1;
		//visualizar los objetos
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		}
		
		odb.close();
		
	}

}
