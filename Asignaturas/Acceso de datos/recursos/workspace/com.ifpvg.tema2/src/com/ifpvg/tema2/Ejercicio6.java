package com.ifpvg.tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;




public class Ejercicio6 {
	
	public static boolean comprobarStock(int idProducto, int cantidad ) throws SQLException{
		boolean comp = true;	
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");
		
		Statement sentencia = conexion.createStatement();
		ResultSet resul = sentencia.executeQuery("select stockactual, stockminimo from productos where id = " +idProducto);
		
		while(resul.next()) {
			int stockAct = resul.getInt("stockactual");
			int stockMin = resul.getInt("stockminimo");
			int stockActualizado = 0;

			if((stockAct -  cantidad )<= 0) {
				System.out.println("NO SE PUEDE VENDER PORQUE NO HAY STOCK SUFICIENTE, STOCK ACTUAL --> " +resul.getInt("stockactual"));
				comp = false;
			}else {
				if((stockAct - cantidad) <= stockMin) {
					stockActualizado = stockAct - cantidad;
					String sql = ("UPDATE productos SET stockactual = " +stockActualizado+" WHERE id = " + idProducto);
					Statement sentencia1 = conexion.createStatement();
					int filas = sentencia1.executeUpdate(sql);
					System.out.println("Filas afectadas: " + filas);
					
					System.out.println("ATENCION A SOBRAPASADO EL STOCK MINIMO, CANTIDAD RESTANTE --> " +stockActualizado);
				}else {
					{
						stockActualizado = stockAct - cantidad;
						String sql = ("UPDATE productos SET stockactual = " +stockActualizado+" WHERE id = " + idProducto);
						Statement sentencia1 = conexion.createStatement();
						int filas = sentencia1.executeUpdate(sql);
						System.out.println("Filas afectadas: " + filas);
						sentencia1.close();
					}
				}
			}
		}
		resul.close();
		sentencia.close();
		
		conexion.close();
		return comp;
	}
	
	public static boolean comprobarValor(int cantidad) {
		boolean comp = true;
			if(cantidad <= 0) {
				System.out.println("La cantidad a vender no puede ser 0");
				comp = false;
			}
			
		return comp;
		
	}
	
	public static int autoIncrement() throws SQLException {
		int idVenta = 0;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet r = sentencia.executeQuery("SELECT MAX(idventa) FROM ventas");

		while (r.next()) {
			 idVenta = r.getInt("MAX(idVenta)");		 		
		}
		
		idVenta ++;
		r.close();
		sentencia.close();
		conexion.close();

		return idVenta;
	}
	
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
	
	public static boolean comprobarIdProducto(int idProducto) throws SQLException {
		boolean compId = false;
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet r = sentencia.executeQuery("SELECT id from productos");

		while (r.next()) {
			if (r.getInt("id") == idProducto) {
				compId = true;
			}
		}

		if (compId == false) {
			System.out.println("EL ID DEL PRODUCTO NO EXISTE");
		}

		r.close();
		sentencia.close();
		conexion.close();

		return compId;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2", "root", "");
			Statement sentenciaInsert = conexion.createStatement();

			//VARIABLES

			int idCliente = 103;
			int idProducto = 1;
			int cantidad = 1;
			java.util.Date fechaJAVA = new Date();
			java.sql.Date fechaSQL = new java.sql.Date(fechaJAVA.getTime());
			
			
			//FUNCIONES COMPROBANTES

			boolean compIdCliente = comprobarIdCliente(idCliente);
			boolean compIdProducto = comprobarIdProducto(idProducto);
			boolean compCantidad = comprobarValor(cantidad);

			
			if (compIdCliente == true && compIdProducto == true && compCantidad == true && comprobarStock(idProducto, cantidad)) {
				String sql = "INSERT INTO ventas (idventa, fechaventa, idcliente, idproducto, cantidad) VALUES ('" + autoIncrement() + "','" + fechaSQL + "','" + idCliente + "','" + idProducto + "','" + cantidad +"')";
				
				System.out.println(sql);
				
				int filas = sentenciaInsert.executeUpdate(sql);
				System.out.println("Filas afectadas: " + filas);
				sentenciaInsert.close();

			} else {
				System.out.println("DATOS NO ENVIADOS");
			}
			
			
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (e.getErrorCode() == 1062) {
				System.out.println("Clave primaria repetida");
				System.out.println("DATOS NO ENVIADOS");
			}
		}
		
	

	}

}

