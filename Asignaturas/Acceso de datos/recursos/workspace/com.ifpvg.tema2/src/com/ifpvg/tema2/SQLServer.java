package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServer {

	public static void main(String[] args) {
		
		//Controlamos la conexion y sus errores
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.209.155;database=ASI1","dam201","sanson");
			Statement sentencia = conexion.createStatement();
			
			ResultSet r = sentencia.executeQuery("select * from departamentos");
			
			while(r.next()){
				//System.out.println("Id: "+r.getString(1)+" ID: "+r.getString(2)+" Descripcion: "+r.getString(3));
				System.out.println("Id: "+r.getInt("dept_no")+" Nombre: "+r.getString("dnombre")+" Localidad: "+r.getString("loc"));
			}
			
			r.close();
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