
import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class COPIA {


	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Linea que carga el driver
		Connection conexionAc = DriverManager.getConnection("jdbc:ucanaccess://C://Users//LENOVO//Desktop/Recupera.accdb");
		Statement sentencia = conexionAc.createStatement();

		Class.forName("com.mysql.jdbc.Driver"); //Linea que carga el driver
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","");				
		Statement sentencia2 = conexion.createStatement();
		
		ResultSet r = sentencia.executeQuery("select * from infectados");
		
		
		while(r.next()){
			String sql="insert into infectados values("+r.getInt("numero")+",'"+r.getString("apellidos")+"','"+r.getString("virus")+"',"+r.getInt("edad")+")";
			System.out.println(sql);
			int r2 = sentencia2.executeUpdate(sql);
		}
				
		r.close();
		sentencia.close();
		conexion.close();
		sentencia2.close();
		conexionAc.close();
	}
	

}
