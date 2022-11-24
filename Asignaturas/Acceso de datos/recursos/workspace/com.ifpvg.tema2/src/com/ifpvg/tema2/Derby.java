package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Derby {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("No encuentro el class");
				}
				
				//Controlamos la conexion y sus errores
				try {
					Connection conexion = DriverManager.getConnection("jdbc:derby:C:/db-derby-10.8.2.2-bin/bin/ejemplo",Conexiones.USER,Conexiones.PWD);
					conexion.close();			
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("HA OCURRIDO UN ERROR");
					System.out.println("Mensaje: " +e.getMessage());
					System.out.println("SQL Estado: " +e.getSQLState());
					System.out.println("Codigo error: " + e.getErrorCode());
				}
	}

}

