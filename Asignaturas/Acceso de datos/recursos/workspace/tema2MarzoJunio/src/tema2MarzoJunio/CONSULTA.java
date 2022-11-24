package tema2MarzoJunio;
import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class CONSULTA {


	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver"); //Linea que carga el driver
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","");				
		Statement sentencia = conexion.createStatement();
		
/*		
		String sql = "CREATE OR REPLACE VIEW cantidadInfectados (virus, numeroInfectados) AS SELECT  virus, COUNT(*) FROM infectados GROUP BY virus";
		
		int filas = sentencia.executeUpdate(sql);
*/	
		
		
		String sql2 = "Select * from cantidadInfectados";
		ResultSet resul = sentencia.executeQuery(sql2);

		while (resul.next()) {
			System.out.println("Nombre del virus: "+resul.getString("virus")+" || Cantidad de infectados: "+resul.getInt("numeroInfectados"));
		}
		
		sentencia.close();
		conexion.close();
		resul.close();
		
	}
	

}
