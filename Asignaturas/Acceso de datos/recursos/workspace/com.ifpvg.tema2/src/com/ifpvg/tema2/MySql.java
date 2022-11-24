package com.ifpvg.tema2;

import java.sql.*;

public class MySql {

	public static void main(String[] args) {
		// Controlar las librerias
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No encuentro el class");
		}
		
		//Controlamos la conexion y sus errores
		try {
			Connection conexion = DriverManager.getConnection(Conexiones.BBDD,Conexiones.USER,Conexiones.PWD);
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
			
			while(resul.next()) {
				//System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
				System.out.println(resul.getInt("dept_no") + " " + resul.getString("dnombre") + " " + resul.getString("loc"));
			}
			resul.close();
			sentencia.close();
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
