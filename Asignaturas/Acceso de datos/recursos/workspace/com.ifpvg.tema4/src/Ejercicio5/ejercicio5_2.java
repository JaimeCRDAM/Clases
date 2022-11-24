package Ejercicio5;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import clases.Jugadores;

public class ejercicio5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("Oficina.db");
		
		//Lista de empleados y sus departamentos
		System.out.println("Lista de empleados y sus departamentos:");
		Values valores = odb.getValues(new ValuesCriteriaQuery(Empleados.class).field("empNo").field("apellido").field("dir.apellido").field("dept.dnombre"));
		while(valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();
			System.out.println("Empleado " + objectValues.getByIndex(0) + ", " + objectValues.getByIndex(1) + ". Director: " + objectValues.getByIndex(2) + ". Departamento: " + objectValues.getByIndex(3));
		}
		
		odb.close();

	}

}
