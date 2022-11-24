package com.ifpvg.tema2;
import java.sql.*;
public class Actividad12 {

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
			
			if(comprobarDep(dep) == true) {
				String sql= "{?= call departamento (?)} ";
				CallableStatement llamada= conexion.prepareCall(sql);
				llamada.registerOutParameter(1, Types.VARCHAR);
				llamada.setInt(2, dep);			
				llamada.executeUpdate();
				
				String n= llamada.getString(1);
				
				System.out.println ("Departamento: "+n);
				
				
				llamada.close();
				conexion.close();
			}
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
     		System.out.println("SQL Estado: " +e.getSQLState());
     		System.out.println("Codigo error: " + e.getErrorCode());
		}

	}

	private static boolean comprobarDep(int dept_no) throws SQLException{
		boolean compDep= false;
		
		Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True","root","");
		Statement sentencia= conexion.createStatement();
		ResultSet r= sentencia.executeQuery("SELECT dep.dept_no FROM departamentos AS dep\r\n"
				+ "LEFT JOIN empleados AS emp on emp.dept_no = dep.dept_no\r\n" + "GROUP BY dep.dept_no");
		
		while(r.next()) {
			if(r.getInt("dept_no") == dept_no) {
				compDep= true;
			}
		}
		
		if(compDep == false) {
			System.out.println("EL DEPARTAMENTO ES INEXISTENTE.");
		}
		
		r.close();
		sentencia.close();
		conexion.close();
		
		return compDep;
	}

}
