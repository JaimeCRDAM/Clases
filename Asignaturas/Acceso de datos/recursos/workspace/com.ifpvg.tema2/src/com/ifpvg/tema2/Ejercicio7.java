package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio7 {
	
	public static boolean comprobarIdCliente(int idCliente) throws SQLException {
		boolean compId = false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet r = sentencia.executeQuery("SELECT id from clientes");

		while (r.next()) {
			if (r.getInt("id") == idCliente) {
				compId = true;
			}
		}

		if (compId == false) {
			System.out.println("EL ID DEL CLIENTE NO EXISTE");
		}

		r.close();
		sentencia.close();
		conexion.close();

		return compId;
	}
	
	public static boolean comprobarIdVenta(int idCliente) throws SQLException {
		boolean compId = false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet r = sentencia.executeQuery("SELECT idcliente from ventas");

		while (r.next()) {
			if (r.getInt("idcliente") == idCliente) {
				compId = true;
			}
		}

		if (compId == false) {
			System.out.println("EL CLIENTE NO TIENE VENTAS");
		}

		r.close();
		sentencia.close();
		conexion.close();

		return compId;
	}

	public static void main(String[] args) {
		double acumulaVenta = 0;
		int cont = 0;
		int idCliente = 103;
		
		

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");
			//COMPROBAMOS QUE EL CLIENTE EXISTA Y TENGA VENTAS
			if(comprobarIdCliente(idCliente) == true && comprobarIdVenta(idCliente) == true) {	
				
				//OBTENEMOS NOMBRE CLIENTE
				Statement sentenciaNombre = conexion.createStatement();
				ResultSet resulNombre = sentenciaNombre.executeQuery("select nombre from clientes where id = " +idCliente);
				
				while(resulNombre.next()) {
					System.out.println("Ventas del cliente: " +resulNombre.getString("nombre"));
				}
				resulNombre.close();
				sentenciaNombre.close();
				
				//OBTENEMOS LISTA DE LO COMPRADO
				Statement sentencia = conexion.createStatement();
				ResultSet resul = sentencia.executeQuery("SELECT ventas.idventa, productos.descripcion, productos.pvp, ventas.cantidad from ventas \n"
						+ "join productos on ventas.idproducto = productos.id\n"
						+ "where ventas.idcliente = " + idCliente);
		
				while(resul.next()) {
					System.out.println("Venta: "+resul.getInt("idventa"));
					System.out.println("     Producto: " +resul.getString("descripcion") + " -- PVP: " +resul.getDouble("pvp"));
					System.out.println("     Cantidad: " +resul.getInt("cantidad"));
					System.out.println("     Importe: " +resul.getInt("cantidad") * resul.getDouble("pvp"));
					acumulaVenta = acumulaVenta + resul.getInt("cantidad") * resul.getDouble("pvp");
					cont++;
				}
				resul.close();
				sentencia.close();
								
				System.out.println();
				System.out.println("Numero total de ventas: " +cont);
				System.out.println("Importe total: " +acumulaVenta);
			}
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

