package com.ifpvg.tema2;

import java.text.DecimalFormat;
import java.sql.*;

public class Iva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat formato = new DecimalFormat("#.00");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No encuentro el class");
		}
		
		try {
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/ejemplo? noAccessToProcedureBodies =True","root","");
			
			double precio=14.87;
			double iva=15.5;
			
			String sql= "{? = call iva (?,?)}";
			CallableStatement llamada= conexion.prepareCall(sql);
			llamada.registerOutParameter(1, Types.DOUBLE);
			llamada.setDouble(2, precio);
			llamada.setDouble(3, iva);
			llamada.executeUpdate();
			
			double n= llamada.getDouble(1);
			System.out.println("Precio: " + formato.format(precio) + "â,¬, precio con iva: " + formato.format(n));
			
			llamada.close();
			conexion.close();
			
			
			
		}catch(SQLException e) {
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}

}
