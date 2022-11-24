import java.sql.*;
public class Oracle {

	public static void main(String[] args) {
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
		
			Connection conexion = DriverManager.getConnection("jdbc:oracle:oci:172.17.2.1:1521:PR01","ACCESO_A_DATOS","ACCESOADATOS");
			
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery ("select * from departamentos");
			
			// resul se sitúa ANTES DEL PRIMER REGISTRO. Lo recorremos para visualizar todos los registros:
			while (resul.next())
			{
				System.out.println (resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
			}
			resul.close();
			sentencia.close();
			conexion.close();
		}
		catch (ClassNotFoundException cn){cn.printStackTrace();}
		catch (SQLException e){e.printStackTrace();}
	}
}
