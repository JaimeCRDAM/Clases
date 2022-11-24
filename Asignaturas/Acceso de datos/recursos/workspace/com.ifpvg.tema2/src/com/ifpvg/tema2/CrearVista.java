package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearVista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			System.out.println("No encuentro el class");
		}
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			/*
			CREATE VIEW totales AS
			SELECT dep.dept_no, dep.dnombre, COUNT(emp.emp_no), AVG(emp.salario) FROM departamentos AS dep
			LEFT JOIN empleados AS emp on emp.dept_no = dep.dept_no
			GROUP BY dep.dept_no, dep.dnombre
			 */
			
			String sql = 
			"CREATE OR REPLACE VIEW totales AS " +
			"SELECT dep.dept_no, dep.dnombre, COUNT(emp.emp_no), AVG(emp.salario) FROM departamentos AS dep " +
			"LEFT JOIN empleados AS emp on emp.dept_no = dep.dept_no " +
			"GROUP BY dep.dept_no, dep.dnombre";
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Resultado ejecucion:" +filas);
			conexion.close();

		} catch (SQLException e) {  
			// TODO Auto-generated catch block
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}

}