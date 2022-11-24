package com.ifpvg.tema2;
import java.sql.*;
public class SQLite {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("No encuentro el class");
				}
				
				//Controlamos la conexion y sus errores
				try {
					Connection conexion = DriverManager.getConnection("jdbc:sqlite:c:/sqlite/ejemplo.db",Conexiones.USER,Conexiones.PWD);

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
