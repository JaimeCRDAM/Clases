package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad6 {

	public static void main(String[] args) {
		
		//CONTROLAMOS LAS LIBRERIAS
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("No encuentro el class");
		}
				
		//CONTROLAMOS LA CONEXION Y DESARROLLO DE EJERCICIO.
		
		try {
			//creamos la conexion
			Connection conexion= DriverManager.getConnection(Conexiones.BBDD, Conexiones.USER, Conexiones.PWD);
			
			///////////////////////////////////////////////////////////////////////////////////////////////////
			//empleados del depto 10 (PARTE 1 DEL EJ)
			System.out.println("Empleados que pertenecen al departamento 10 -->");
			Statement sentenciaUno = conexion.createStatement();
			ResultSet resulUno =  sentenciaUno.executeQuery("select apellido, oficio, salario from empleados where dept_no = 10");
			
			while(resulUno.next()) {
				System.out.println(resulUno.getString("apellido") + " " + resulUno.getString("oficio") + " " + resulUno.getDouble("salario"));
			}
			
			resulUno.close();
			sentenciaUno.close();
			System.out.println("");
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Empleado con el maximo salario (PARTE 2 DEL EJ)
			System.out.println("Empleado con maximo salario -->");
			Statement sentenciaDos = conexion.createStatement();
			ResultSet resulDos = sentenciaDos.executeQuery("select apellido, salario from empleados where salario = (select max(salario) from empleados)");
			
			while(resulDos.next()) {
				System.out.println(resulDos.getString("apellido") + " " + resulUno.getString("oficio") + " " + resulUno.getDouble("salario"));
			}
			
			resulDos.close();
			sentenciaDos.close();
			
			//////////////////////////////////////////////////////////////
			//CERRAMOS LA CONEXION
			conexion.close();
			
		} catch (SQLException e) {
			//CONTROLAMOS LOS ERRORES CON SUS MENSAJES
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}
		
	}

}
