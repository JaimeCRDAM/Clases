package com.ifpvg.tema2;

import java.sql.*;

public class Ddl {

	public static void main(String[] args) {
		//Controlamos las librerias
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e1) {
			System.out.println("No encuentro el class.");
		}
		
		try {
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","");
			//objeto DatabaseMetaData y su metodo getMetaData para obtener informacion de una base de datos.
			DatabaseMetaData dbmd= conexion.getMetaData();
			//para obtener datos
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url =  dbmd.getURL();
			String usuario = dbmd.getUserName();
			
			System.out.println("Informacion de la base de datos: ");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Nombre--> " + nombre);
			System.out.println("Driver--> " + driver);
			System.out.println("URL--> "+ url);
			System.out.println("Usuario--> " + usuario);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println();
			System.out.println();
			System.out.println("Informacion de las tablas.");
			System.out.println("############################################");
			ResultSet resul = null;
			resul = dbmd.getTables(null, "ejemplo", null, null);
			
			while(resul.next()) {
				String catalogo= resul.getString("TABLE_CAT");
				String esquema= resul.getString("TABLE_SCHEM");
				String tabla= resul.getString("TABLE_NAME");
				String tipo= resul.getString("TABLE_TYPE");
				
				System.out.println("Tipo --> "+tipo);
				System.out.println("Catalogo --> "+catalogo);
				System.out.println("Esquema --> "+esquema);
				System.out.println("Nombre --> "+tabla);
				System.out.println("##############################################");
			}
			
			conexion.close();
			
		}catch(SQLException e) {
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}

}
