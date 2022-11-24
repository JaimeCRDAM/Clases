package Ejercicio5;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class ejercicio5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("Oficina.db");
		
		//Apellido de los empleados del departamento 10
		System.out.println("Lista de empleados del departamento 10:");
		Values valores = odb.getValues(new ValuesCriteriaQuery(Empleados.class,Where.equal("dept.deptNo",10)).field("empNo").field("apellido"));
		while(valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();
			System.out.println("Empleado " + objectValues.getByIndex(0) + ", " + objectValues.getByIndex(1));
		}
		
		System.out.println("---------------------------");
		
		//Numero de empleados del departamento Ventas
		System.out.println("Numero de empleados del departamento Ventas:");
		Values valores2 = odb.getValues(new ValuesCriteriaQuery(Empleados.class,Where.equal("dept.dnombre","Ventas")).field("empNo"));
		System.out.println(valores2.size());
		
		System.out.println("---------------------------");
		
		//Apellidos de los empleados cuyo director es Rey
		System.out.println("Lista de los empleados cuyo director es Rey:");
		Values valores3 = odb.getValues(new ValuesCriteriaQuery(Empleados.class,Where.equal("dir.apellido","Rey")).field("apellido"));
		while(valores3.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores3.next();
			System.out.println(objectValues.getByIndex(0));
		}
		
		System.out.println("---------------------------");
		
		//Por cada departamento el numero de empleados
		System.out.println("Departamentos y numero de empleados por departamento:");
		Values valores4 = odb.getValues(new ValuesCriteriaQuery(Empleados.class).field("dept.dnombre").count("dept.dnombre").groupBy("dept.dnombre"));
		while(valores4.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores4.next();
			System.out.println(objectValues.getByIndex(0) + " * " + objectValues.getByIndex(1));
		}
		
		odb.close();
		

	}

}
