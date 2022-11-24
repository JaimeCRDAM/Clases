package com.ifpvg.tema2;

import java.sql.*;

public class ProcBajada {

	public static void main(String[] args) {
		//comprobamos las librerias
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No encuentro el class");
		}
		
		try {
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True","root","");
			int dep=10;
			double bajada=125.23;
			
			if(comprobarDep(dep) == true) {
				//esto llama al procedimiento bajada_sal 
				String sql= "{call bajada_sal (?,?)}";
				CallableStatement llamada= conexion.prepareCall(sql);
				llamada.setInt(1, dep);
				llamada.setDouble(2, bajada);
				llamada.executeUpdate();
				
				Statement sentencia= conexion.createStatement();
				ResultSet resul= sentencia.executeQuery("select * from empleados where dept_no= " + dep + ";");
				
				while(resul.next()) {
					System.out.println("Apellido: " + resul.getString("apellido") + ", Salario: " + resul.getDouble("salario") + "â, ¬");
				}
				
				resul.close();
				sentencia.close();
				llamada.close();
				
			}
			conexion.close();
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}
	
	public static boolean comprobarDep(int dept_no) throws SQLException{
		boolean compDep= false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True","root","");
		Statement sentencia= conexion.createStatement();
		ResultSet r= sentencia.executeQuery("SELECT dep.dept_no FROM departamentos AS dep\r\n"
				+ "LEFT JOIN empleados AS emp on emp.dept_no = dep.dept_no\r\n" + "GROUP BY dep.dept_no");
		
		while(r.next()) {
			if(r.getInt("dept_no") == dept_no) {
				compDep= true;
			}
		}
		
		if(compDep == false) {
			System.out.println("LA CLAVE DEL DEPARTAMENTO NO EXISTE.");
		}
		
		r.close();
		sentencia.close();
		conexion.close();
		
		return compDep;
	}

}
