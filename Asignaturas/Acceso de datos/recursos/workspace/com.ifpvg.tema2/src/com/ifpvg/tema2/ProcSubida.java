package com.ifpvg.tema2;
import java.sql.*;

public class ProcSubida {

	public static void main(String[] args) {
		//controlamos las librerias
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e1) {
			System.out.println("No encuentro el class");
		}
		
		//crear la conexion y desarrollar el ejercicio.
		try {
			//Connection conexion= DriverManager.getConnection(Conexiones.BBDD, Conexiones.USER, Conexiones.PWD);
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True", "root", "");
			int dep=10;
			double subida= 125.23;
			
			if(comprobarDep(dep)== true) {
				//se llama a la funcion
				String sql= "{call subida_sal (?,?)}";
				CallableStatement llamada= conexion.prepareCall(sql);
				llamada.setInt(1, dep);
				llamada.setDouble(2, subida);
				llamada.executeUpdate();
				
				Statement sentencia= conexion.createStatement();
				ResultSet r= sentencia.executeQuery("select * from empleados where dept_no = " + dep + ";");
				
				while(r.next()) {
					System.out.println("Apellido: " + r.getString("apellido") + ", Salario: " + r.getDouble("salario")+ "â,¬");
					
				}
				
				r.close();
				sentencia.close();
				llamada.close();
			}
			
			conexion.close();
			
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}
	
	public static boolean comprobarDep(int dept_no) throws SQLException{
		boolean compDep= false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
		
		Statement sentencia= conexion.createStatement();
		ResultSet r= sentencia.executeQuery("SELECT dep.dept_no FROM departamentos AS dep\r\n" 
		+ "LEFT JOIN empleados AS emp on emp.dept_no= dep.dept_no\r\n " + "GROUP BY dep.dept_no");
		
		while(r.next()) {
			if(r.getInt("dept_no") == dept_no) {
				compDep= true;
			}
		}
		
		if(compDep == false) {
			System.out.println("LA CLAVE DEPARTAMENTO NO EXISTE");
		}
		
		r.close();
		sentencia.close();
		conexion.close();
		
		return compDep;
	}

}
