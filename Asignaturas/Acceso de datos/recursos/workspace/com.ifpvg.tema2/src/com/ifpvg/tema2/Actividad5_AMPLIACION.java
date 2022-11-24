package com.ifpvg.tema2;

import java.util.Calendar;
import java.util.Date;

import com.db4o.Db4oEmbedded;

public class Actividad5_AMPLIACION {

	final static String BDEmpleado= "empleadoDep.yap";
	
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpleado);
		int cont=0;
		
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
		int intArray[]= {0, 0, 0, 0};
		
		System.out.println(" ");
		
		//MOSTRAR LOS EMPLEADOS
		Empleado emp1= new Empleado();
		ObjectSet <Empleado> result= db.queryByExample(emp1);
		if(result.size() == 0) {
			System.out.println("No hay registros de empleados.");
		}else {
			System.out.println("Numero de registros: " + result.size());
		}
		
		while(result.hasNext()) {
			Empleado emp2 = result.next();
			System.out.println("Numero " + emp1.getNumero() + ", Apellidos: " + emp1.getApellidos() + ", Oficio: "
					+ emp1.getOficio() + ", Dir: " + emp1.getDir() + ", Fecha: " + emp1.getFecha() + ", Salario: "
					+ emp1.getSalario() + ", Comision: " + emp1.getComision() + ", Dpto: " + emp1.getDpto());
			intArray [cont]= emp1.getNumero();
			cont++;
		}
		
		//ELIMINA LOS EMPLEADOS CON IGUAL NUMERO
		
		for(int i=0; i<intArray.length; i++) {
			ObjectSet <Empleado> resultakill= db.queryByExample(new Empleado(intArray[i], null, null, 0, null, (float) 0, (float) 0, (byte) 20));
			if(resultakill.size() == 0) {
				System.out.println("No hay registros que eliminar.");
			}else {
				System.out.println("Numero de registros a borrar: " + resultakill.size());
				while(resultakill.hasNext() && resultakill.size() > 1 ) {
				Empleado existe = (Empleado) resultakill.next();
				db.delete(existe);	
				}
			}
		}
		
		System.out.println(" ");
		
		//MUESTRA LOS EMPLEADOS DESPUES DE BORRAR.
		
		Empleado em = new Empleado();
		ObjectSet<Empleado> result = db.queryByExample(em);
		if (result.size() == 0) {
			System.out.println("No existen registros de empleados.");
		} else {
			System.out.println("Numero de registros: " + result.size());
		}
		while (result.hasNext()) {
			Empleado emp3 = result.next();
			System.out.println("Numero " + emp3.getNumero() + ", Apellidos: " + emp3.getApellidos() + ", Oficio: "
					+ emp3.getOficio() + ", Dir: " + emp3.getDir() + ", Fecha: " + emp3.getFecha() + ", Salario: "
					+ emp3.getSalario() + ", Comision: " + emp3.getComision() + ", Dpto: " + emp3.getDpto());
		}

		//SE HARIA EL MISMO PASO PARA LOS DEPARTAMENTOS.
		
		db.close();

	}

}
