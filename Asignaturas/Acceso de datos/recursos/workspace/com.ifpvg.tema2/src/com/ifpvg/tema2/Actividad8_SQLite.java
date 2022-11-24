package com.ifpvg.tema2;
import java.sql.*;

public class Actividad8_SQLite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//controlamos las librerias.
		try {
			Class.forName("org.sqlite.JDBC");
		}catch (ClassNotFoundException e1) {
			System.out.println("No se ha encontrado el class.");
		}
		
		try {
			//creamos la conexion y desarollamos el ejercicio.
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:c:/sqlite/ejemplo.db",Conexiones.USER,Conexiones.PWD);
			
			//OBTENER METADATOS DE UNA BASE DE DATOS.
			DatabaseMetaData dbmd= conexion.getMetaData();
			
			String nombre= dbmd.getDatabaseProductName();
			String driver= dbmd.getDriverName();
			String url= dbmd.getURL();
			String usuario= dbmd.getUserName();
			
			System.out.println("Informacion de la base de datos.");
			System.out.println("********************************");
			System.out.println("Nombre--> " + nombre);
			System.out.println("Driver--> " + driver);
			System.out.println("URL--> " + url);
			System.out.println("Usuario--> " + usuario);
			System.out.println("*********************************");
			
			System.out.println();
			System.out.println();
			System.out.println("Informacion de las tablas: ");
			System.out.println("#####################################");
			
			ResultSet resul= null;
			resul= dbmd.getTables(null, "ejemplo", null, null);
			
			while(resul.next()) {
				String catalogo= resul.getString("TABLE_CAT");
				String esquema = resul.getString("TABLE_SCHEM");
				String tabla= resul.getString("TABLE_NAME");
				String tipo= resul.getString("TABLE_TYPE");
				
				System.out.println("Tipo --> "+tipo);
				System.out.println("Catalogo --> "+catalogo);
				System.out.println("Esquema --> "+esquema);
				System.out.println("Nombre --> "+tabla);
				System.out.println("##############################################");
				
			}	
			System.out.println();
			System.out.println();
				
			///////////////////////////////////////////////////////////
			//OBTENER DATOS DE LAS COLUMNAS DE UNA TABLA
				
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS");
				
			ResultSet columnas= null;
			columnas= dbmd.getColumns(null, "ejemplo", "departamentos", null);
			while(columnas.next()) {
				String nomCol= columnas.getString("COLUMN_NAME");
				String tipCol= columnas.getString("TYPE_NAME");
				String tamCol= columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
					
				System.out.println("COLUMNAS: " +nomCol+ ", Tipo: " +tipCol+ ", TamaÃ±o: " +tamCol+ ", Es nula??: " +nula);
					
					
			}
			
			System.out.println();
			System.out.println();
			
			/////////////////////////////////////////////////////////////
			//OBTENER PRIMARY KEYS DE UNA TABLA
			System.out.println("Primary keys de departamentos");
			ResultSet pk= dbmd.getPrimaryKeys(null, "ejemplo", "departamentos");
			String pkDep="", separador="";
			
			while(pk.next()) {
				pkDep= pkDep + separador + pk.getString("COLUMN_NAME");
				separador="+";
			}
			System.out.println("Clave primaria: " + pkDep);
			
			System.out.println();
			System.out.println();
			
			/////////////////////////////////////////////////////////////
			//OBTENER FOREIGN KEYS DE UNA TABLA
			
			System.out.println("Foreign keys tablas");
			
			ResultSet fk= dbmd.getExportedKeys(null, "ejemplo", "departamentos");
			
			while(fk.next()) {
				String fk_name = fk.getString("FKCOLUMN_NAME");
				String pk_name = fk.getString("PKCOLUMN_NAME");
				String pk_tableName = fk.getString("PKTABLE_NAME");
				String fk_tableName = fk.getString("FKTABLE_NAME");
				
				System.out.println("Tabla PK: " +pk_tableName+ ", Clave Primaria: " +pk_name);
				System.out.println("Tabla FK: " +fk_tableName+ ", Clave Primaria: " +fk_name);
			}
			
			System.out.println();
			System.out.println();
			
			////////////////////////////////////////////////////
			//OBTENER PROCEDIMIENTOS DDE UNA TABLA
			System.out.println("Obtener procedimientos de una BBDD");
			
			ResultSet proc = dbmd.getProcedures(null, "ejemplo", null);
			while(proc.next()) {
				String proc_name= proc.getString("PROCEDURE_NAME");
				String proc_type= proc.getString("PROCEDURE_TYPE");
				System.out.println("Nombre procedimiento: " + proc_name+ ", Tipo: " + proc_type);
			}
			
			System.out.println();
			System.out.println();
			////////////////////////////////////////////////////////
			////// OBTENER METADATOS DE UNA TABLA 
			
			System.out.println("Obtener metadatos de una tabla");
			
			Statement sentencia= conexion.createStatement();
			ResultSet rs= sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
			ResultSetMetaData rsmd= rs.getMetaData();
			int nColumnas= rsmd.getColumnCount();
			String nula;
			System.out.println("Número de columnas recuperadas: " + nColumnas);
			
			for(int i=0; i<=nColumnas; i++) {
				System.out.println("Columna --> " +i+ ": ");
				System.out.println("Nombre --> " + rsmd.getColumnName(i));
				System.out.println("Tipo --> " + rsmd.getColumnType(i));
				
				if (rsmd.isNullable(i) == 0) {
					nula="NO";
				}else {
					nula="SI";
				}
				
				System.out.println("Puede ser nula --> " +nula);
				System.out.println("Maximo ancho de la columna --> " + rsmd.getColumnDisplaySize(i));
				
			}
			
			conexion.close();
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("HA OCURRIDO UN ERROR");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Codigo error: " + e.getErrorCode());
		}

	}

}
