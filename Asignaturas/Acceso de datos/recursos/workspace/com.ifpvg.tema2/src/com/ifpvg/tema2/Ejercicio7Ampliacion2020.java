package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio7Ampliacion2020 {
	
	public static void main(String[] args) {
		
		int totalProducto = 0;
		double precio = 0;
		int cantidad = 0;
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");
			//COMPROBAMOS QUE EL CLIENTE EXISTA Y TENGA VENTAS

				
				//OBTENEMOS NOMBRE CLIENTE
				Statement sentencia = conexion.createStatement();
				ResultSet resulId = sentencia.executeQuery("select count(id) from productos");
				
				while(resulId.next()) {
					totalProducto = resulId.getInt("count(id)");
				}
				resulId.close();
			
				
				for (int i = 1; i <= totalProducto; i++) {
					System.out.println("Producto " + i);
					ResultSet resul1 = sentencia.executeQuery("select productos.descripcion, productos.pvp from productos where id = " + i);		
					while(resul1.next()) {
						System.out.println("Descripcion: " + resul1.getString("descripcion"));
						System.out.println("P.V.P: " +resul1.getDouble("pvp"));
						precio = resul1.getDouble("pvp");
					}
					
		
					
					resul1 = sentencia.executeQuery("select count(idventa) from ventas where idproducto = " + i);		
					while(resul1.next()) {
						System.out.println("	Numero de ventas de este producto: " + resul1.getInt("count(idventa)"));
					}
					resul1.close();

					
					resul1 = sentencia.executeQuery("select count(distinct idcliente) from ventas where idproducto = " +i);		
					while(resul1.next()) {
						System.out.println("	Numero de clientes a los que se ha vendido: " + resul1.getInt("count(distinct idcliente)"));
					}
					
					resul1 = sentencia.executeQuery("select sum(cantidad) from ventas where idproducto = " + i);		
					while(resul1.next()) {
						System.out.println("	Unidades vendidas de este producto: " + resul1.getInt("sum(cantidad)"));
						cantidad = resul1.getInt("sum(cantidad)"); 
						System.out.println("	Unidades vendidas * P.V.P: " +precio*cantidad);
					}

					resul1.close();
					System.out.println();
				}
								
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
