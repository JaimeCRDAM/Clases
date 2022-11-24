package com.ifpvg.tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class CONTROLTEMA2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","");
			
			String sql = "CREATE OR REPLACE VIEW vista_notas_modulo (codigo_modulo,denominacion,num_notas,num_alumnos,media) AS" +
			" Select modulos.codigo, modulos.denominacion, count(notas.nota), count(distinct notas.alumno), avg(notas.nota)" +
			" from notas right join modulos" +
			" on notas.modulo = modulos.codigo" +
			" group by modulos.codigo";
			
			
			//LA VISTA OBTIENE LA DENOMINACION DE LOS MODULOS, PERO DEBO OBTENERLA USANDO LA FUNCION MÓDULO
			
			String sqlfuncion = "{? = call MODULO2 (?)}";
			CallableStatement llamada = conexion.prepareCall(sqlfuncion);
			
				
			//System.out.println(sql);
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			//System.out.println("Resultado ejecución: "+filas);	
			
			ResultSet resul = sentencia.executeQuery("Select * from vista_notas_modulo");
			
			int codigo_modulo = 0;
			
			while(resul.next()) {
				
				codigo_modulo = resul.getInt("codigo_modulo");
				
				llamada.registerOutParameter(1, Types.VARCHAR);
				llamada.setInt (2, codigo_modulo);
				llamada.executeUpdate();
				
				String n = llamada.getString(1);
				
				System.out.println("Denominación del módulo: " + llamada.getString(1));
				System.out.println("Número de notas asignadas a este módulo: " + resul.getInt("num_notas"));
				System.out.println("Número de alumnos con notas asignadas a este módulo: "+ resul.getInt("num_alumnos"));
				System.out.println("Media de las notas asignadas a este módulo: "+ resul.getDouble("media"));
				System.out.println(" ");
				
			}
			
			
		}catch(ClassNotFoundException cn) {
			cn.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Ha ocurrido una excepcion");
			System.out.println("Mensaje: " +e.getMessage());
			System.out.println("SQL Estado: " +e.getSQLState());
			System.out.println("Código de error: " +e.getErrorCode());
		}

	}

}
