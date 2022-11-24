package clases;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;


public class Consulta2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ODB odb = ODBFactory.open("equipos.db");
		
		//select SUM(edad) from jugadores
		//tres formas
		Values val = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
		ObjectValues ov = val.nextValues();
		BigDecimal value = (BigDecimal) ov.getByAlias("edad");
		System.out.println("Suma de edad con el nombre del atributo: " + value);
		
		Values valdos = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
		ov = valdos.nextValues();
		value = (BigDecimal) ov.getByIndex(0);
		System.out.println("Suma de edad con el indice: " + value);
		
		Values valtres = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad","suma_edad"));
		ov = valtres.nextValues();
		value = (BigDecimal) ov.getByAlias("suma_edad");
		System.out.println("Suma de edad con el Alias: " + value);
		
		
		//select COUNT(nombre) from jugadores
		Values val2 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).count("nombre"));
		ObjectValues ov2 = val2.nextValues();
		BigInteger value2 = (BigInteger) ov2.getByAlias("nombre");
		System.out.println("Numero de jugadores : " + value2);
		
		
		//select avg(edad) from jugadores
		Values val3 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).avg("edad"));
		ObjectValues ov3 = val3.nextValues();
		BigDecimal value3 = (BigDecimal) ov3.getByAlias("edad");
		System.out.println("Edad media : " + value3.floatValue());
		
		
		//Sacamos la edad media
		//como ya tenemos la suma de todas las edades y la cantidad de jugadores, los dividimos
		System.out.println("Edad media sin decimales: " + value.longValue()/value2.intValue());
		
		float em = value.intValue()/value2.floatValue();
		System.out.println("Edad media con decimales: " + em);
		
		
		//edad maxima y minima
		//mejor hacerlas en dos consultas separadas
		//select max(edad) edad_max, min(edad) edad_min from jugadores
		Values val4max = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).max("edad","edad_max"));
		Values val4min = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad","edad_min"));
		
		ObjectValues ov4max = val4max.nextValues();
		ObjectValues ov4min = val4min.nextValues();
		
		BigDecimal value4max = (BigDecimal) ov4max.getByAlias("edad_max");
		BigDecimal value4min = (BigDecimal) ov4min.getByAlias("edad_min");
		
		System.out.println("Edad maxima: " + value4max);
		System.out.println("Edad minima: " + value4min);
		
		
		//Select ciudad, count(nombre) from jugadores group by ciudad
		//field coge un campo sin aplicarle nada
		System.out.println("Numero de jugadores por ciudad:");
		Values groupby = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("ciudad").count("nombre").groupBy("ciudad"));
		while(groupby.hasNext()) {
			ObjectValues objetos = (ObjectValues) groupby.next();
			System.out.println(objetos.getByIndex(0) + ": " + objetos.getByIndex(1));
		}
	}

}
