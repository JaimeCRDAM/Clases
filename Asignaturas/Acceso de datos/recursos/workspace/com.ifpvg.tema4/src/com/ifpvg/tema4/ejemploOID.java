package com.ifpvg.tema4;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

import clases.Jugadores;


public class ejemploOID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("neodatis.test"); //ABRIR BD
		OID oid = OIDFactory.buildObjectOID(5); //Obtener el objeto con OID 3
		
		Jugadores jug = (Jugadores) odb.getObjectFromId(oid);
		System.out.println("OID: " + oid + "\t: " + jug.getNombre() + " * " + jug.getDeporte() + " * " + jug.getCiudad() + " * " + jug.getEdad() + " * " + jug.getPais().getNombrepais());
		

	}

}
