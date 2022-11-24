package com.ifpvg.tema2;

import java.sql.*;


public class Access {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Linea que carga el driver
		//Connection conexion = (Connection) DriverManager.getConnection("jdbc:odbc:EJEMPLO-ACCESS");
		Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://H:\\2 dam\\Acceso a Datos\\Tema 2\\Access\\Departamentos.accdb");
		//H:\\2 dam\\Acceso a Datos\\Tema 2\\Access\\Departamentos.accdb
		Statement sentencia = conexion.createStatement();
		
		ResultSet r = sentencia.executeQuery("select * from departamentos");
		
		while(r.next()){
			//System.out.println("Id: "+r.getString(1)+" ID: "+r.getString(2)+" Descripcion: "+r.getString(3));
			System.out.println("Id: "+r.getInt("dept_no")+" Nombre: "+r.getString("dnombre")+" Localidad: "+r.getString("loc"));
		}
		
		r.close();
		sentencia.close();
		conexion.close();

	}

}
