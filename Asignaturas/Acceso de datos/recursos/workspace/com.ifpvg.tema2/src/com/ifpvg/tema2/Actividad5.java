package com.ifpvg.tema2;

import java.util.Calendar;
import java.util.Date;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class Actividad5 {
	final static String BDEmpleado="EMPLEDEP.YAP";

	public static void main(String[] args) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpleado);
		
		//CREO LOS EMPLEADOS
		Date fecha = new Date();
		fecha.setYear(1990);
	    fecha.setMonth(Calendar.DECEMBER);
	    fecha.setDate(17);
		Empleado e1 = new Empleado(7369, "SANCHEZ", "EMPLEADO", 7902, fecha, (float) 1040, (float) 0, (byte) 20);
		// lo añado a la base de datos
		db.store(e1);		
		
		Date fecha2 = new Date();
		fecha.setYear(1990);
		fecha.setMonth(Calendar.FEBRUARY);
		fecha.setDate(20);
		Empleado e2 = new Empleado(7499, "ARROYO", "VENDEDOR", 7698, fecha, (float) 1500, (float) 390, (byte) 20);
		// lo añado a la base de datos
		db.store(e2);
		
		Date fecha3 = new Date();
		fecha.setYear(1991);
		fecha.setMonth(Calendar.FEBRUARY);
		fecha.setDate(22);
		Empleado e3 = new Empleado(7521, "SALA", "VENDEDOR", 7698, fecha, (float) 1625, (float) 650, (byte) 30);
		// lo añado a la base de datos
		db.store(e2);
		
		//CREO LOS DEPARTAMENTOS
		Departamento d1= new Departamento((byte) 10, "CONTABILIDAD", "SEVILLA");
		Departamento d2= new Departamento((byte) 20, "INVESTIGACION", "MADRID");
		Departamento d3= new Departamento((byte) 30, "VENTAS", "BARCELONA");
		Departamento d4= new Departamento((byte) 40, "PRODUCCION", "BILBAO");
		
		//los añadimos a la base de datos
		db.store(d1);
		db.store(d2);
		db.store(d3);
		db.store(d4);
		
		System.out.println(" ");
		
		//MOSTRAR TODOS LOS EMPLEADOS
		Empleado em= new Empleado();
		ObjectSet<Empleado> result =db.queryByExample(em);
		if(result.size() == 0) {
			System.out.println("No existen registros de empleados");
		}else {
			System.out.println("Numero de registros: " + result.size());
		}
		
		while(result.hasNext()) {
			Empleado emp1= result.next();
			System.out.println("Numero: " + emp1.getNumero() + ", Apellidos: " + emp1.getApellidos() + ", Oficio: " 
					+ emp1.getOficio() + ", Dir: " + emp1.getDir() + ", Fecha: " + emp1.getFecha() + ", Salario: " 
					+emp1.getSalario() + ", Comision: " + emp1.getComision() + ", Dpto: " + emp1.getDpto());
		}
		
		System.out.println(" ");
		
		
		//MOSTRAR LOS DEPARTAMENTOS
		Departamento dep= new Departamento();
		ObjectSet <Empleado> resulta = db.queryByExample(dep);
		if(resulta.size() == 0) {
			System.out.println("No existen registros de departamentos.");
		}else {
			System.out.println("Numero de registros: " + resulta.size());
		}
		
		while(resulta.hasNext()) {
			Departamento dep1= resulta.next();
			System.out.println("Dpto " + dep1.getDpto() + ", Nombre departamento: " + dep1.getDnombre() + ", Loc: "
					+ dep1.getLoc());
		}
		
		System.out.println(" ");
		
		
		//MOSTRAR DEPARTAMENTO NUM 20
		Departamento dep1  = new Departamento((byte) 20, null, null);
		ObjectSet<Departamento> resulte = db.queryByExample(dep1);
		if(resulte.size() == 0) {
			System.out.println("No existen registros del departamento 20.");
		}
		while(resulte.hasNext()) {
			Departamento dep2= resulte.next();
			System.out.println("Dpto: " + dep2.getDpto() + ", Nombre Departamento: " + dep2.getDnombre() + ", Localidad: " 
					+ dep2.getLoc());
		}
		
		//MOSTRAR LOS EMPLEADOS QUE HAY EN EL DEPTO 20
		Empleado em1= new Empleado(0, null, null, 0, null, (float) 0, (float) 0, (byte) 20);
		ObjectSet<Empleado> results= db.queryByExample(em1);
		if(results.size() == 0) {
			System.out.println("No hay registros de empleados en el departamento 20");
		}
		while(results.hasNext()) {
			Empleado emp2= results.next();
			System.out.println("Numero " + emp2.getNumero() + ", Apellidos: " + emp2.getApellidos() + ", Oficio: "
					+ emp2.getOficio() + ", Dir: " + emp2.getDir() + ", Fecha: " + emp2.getFecha() + ", Salario: "
					+ emp2.getSalario() + ", Comision: " + emp2.getComision() + ", Dpto: " + emp2.getDpto());
		}
		
		db.close();
		
	}

}
