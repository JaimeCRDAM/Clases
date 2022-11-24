package com.ifpvg.tema2;
import java.sql.*;
import java.text.DecimalFormat;

public class Nomina {

	public static void main(String[] args) { 
		DecimalFormat Formato= new DecimalFormat("#.00");
		double salario=0, comision=0;
		double irpf=20;
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No encuentro el class");
		}
		
		try {
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True", "root", "");
			
			Statement sentencia= conexion.createStatement();
			ResultSet resul= sentencia.executeQuery("select apellido, salario, comision from empleados");
			
			while(resul.next()) {
				System.out.println("Apellido: " + resul.getString("apellido") + ", Salario: " + resul.getDouble("salario") + ", Comision: " 
						+ resul.getDouble("comision") + ", Nómina: " + Formato.format(sacarNomina(salario, comision, irpf)) + "â‚¬");
			}
			 
			resul.close();
			sentencia.close();
			conexion.close();
			
			
		}catch(SQLException e) {
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}
	
	public static double sacarNomina(double salario, double comision, double irpf) throws SQLException{
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True", "root", "");
		
		String sql= "{? = call nomina (?,?,?)}";
		CallableStatement llamada= conexion.prepareCall(sql);
		llamada.registerOutParameter(1, Types.DOUBLE);
		llamada.setDouble(2, salario);
		llamada.setDouble(3, comision);
		llamada.setDouble(4, irpf);
		llamada.executeUpdate();
		double n= llamada.getDouble(1);
		
		llamada.close();
		conexion.close();
		return n;
		
		
	}

}
