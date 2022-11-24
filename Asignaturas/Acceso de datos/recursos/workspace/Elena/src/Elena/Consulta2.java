package Elena;
import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class Consulta2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","");	
		
		String sql = "{? = call APELLIDO (?)}";
		CallableStatement llamada = (CallableStatement) conexion.prepareCall(sql);
		llamada.registerOutParameter(1, Types.VARCHAR);
		llamada.setString(2, "1");
		llamada.executeUpdate();
		
		String apellido = "";
		apellido = llamada.getString(1);
		System.out.println(apellido);

		llamada.close();
		conexion.close();
	}
	

}



