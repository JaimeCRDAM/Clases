package Practica_Tema2;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.mysql.jdbc.Connection;

public class Importa {
	final static String BDCuarentena="CUARENTENA.YAP";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conexion= (Connection) DriverManager.getConnection("jdbc:odbc:Access");
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCuarentena);
	}
}
