package Elena;

import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Copia {
	final static String BDCuarentena="CUARENTENA.yap";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
        Connection conexionaccess = (Connection) DriverManager.getConnection("jdbc:ucanaccess://C://Users//LENOVO//Desktop/Recupera.accdb");
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCuarentena);
        
        Statement sta = conexionaccess.createStatement();
        ResultSet rsa = sta.executeQuery("select * from infectados");
        
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","");
		Statement st2 = conexion.createStatement();
		
		int numero;
		int edad;
		String apellidos;
		String virus;
		
        while(rsa.next()) {
        	
        	numero=(rsa.getInt("numero"));
        	apellidos=(rsa.getString("apellidos"));
        	virus=(rsa.getString("virus"));
        	edad=(rsa.getInt("edad"));
        	
        	String sql="insert into infectados values("+numero+",'"+apellidos+"','"+virus+"',"+edad+")";
        	System.out.println(sql);
        	int r2= st2.executeUpdate(sql);
        	
        	
        }
				db.close();
		        rsa.close();
		        sta.close();
		        st2.close();
		        conexionaccess.close();
		        conexion.close();
			

	}

}
