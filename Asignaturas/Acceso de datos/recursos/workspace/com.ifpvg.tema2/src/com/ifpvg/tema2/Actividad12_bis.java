package com.ifpvg.tema2;
import java.sql.*;

public class Actividad12_bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No encuentro el class");
		}
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True","root","");
			
			int d=15;
			
			if(comprobarDep(d) == true) {
				String sql = "{? = call empleado (?)}";
				CallableStatement llamada = conexion.prepareCall(sql);
				llamada.registerOutParameter(1, Types.VARCHAR);
				llamada.setInt (2,d);
				llamada.executeUpdate();
				int n = llamada.getInt(1);
				System.out.println ("Numero de empleados: "+n);
				llamada.close();
			}
			
			conexion.close();
			
		}catch(SQLException e) {
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}
	
	public static boolean comprobarDep(int dept_no) throws SQLException {
		boolean compDep = false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet r = sentencia.executeQuery("SELECT dep.dept_no FROM departamentos AS dep\r\n"
				+ "LEFT JOIN empleados AS emp on emp.dept_no = dep.dept_no\r\n" + "GROUP BY dep.dept_no");

		while (r.next()) {
			if (r.getInt("dept_no") == dept_no) {
				compDep = true;
			}
		}

		if (compDep == false) {
			System.out.println("LA CLAVE DEPARTAMENTO NO EXISTE");
		}

		r.close();
		sentencia.close();
		conexion.close();

		return compDep;
	}

}
