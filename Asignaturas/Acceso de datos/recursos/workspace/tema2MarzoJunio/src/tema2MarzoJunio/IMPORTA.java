package tema2MarzoJunio;
import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class IMPORTA {

	final static String BDEYD = "CUARENTENA.yap";

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEYD);
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Linea que carga el driver
		Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://C://Users//LENOVO//Desktop/Recupera.accdb");
		
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");		
		//Connection conexion = (Connection) DriverManager.getConnection("jdbc:odbc:EJEMPLO-ACCESS");
		
		Statement sentencia = conexion.createStatement();
		
		ResultSet r = sentencia.executeQuery("select * from infectados");
		int contador = 0;
		while(r.next()){
			contador ++;
			Infectado i = new Infectado();			
			i.setNumero(r.getInt("numero"));
			i.setApellidos(r.getString("apellidos"));
			i.setVirus(r.getString("virus"));
			i.setEdad(r.getInt("edad"));
//			System.out.println("Id: "+i.getNumero()+" || Apellidos: "+i.getApellidos()+" || Virus: "+i.getVirus()+"|| Edad: "+i.getEdad());
			
			db.store(i);
			
//			System.out.println("Guardado los datos del infectado id: "+i.getNumero());
//			System.out.println("Id: "+r.getInt("numero")+" || Apellidos: "+r.getString("apellidos")+" || Virus: "+r.getString("virus")+"|| Edad: "+r.getInt("edad"));
		}
		
		System.out.println(contador);
		
		Infectado infec = new Infectado();
		ObjectSet<Infectado> result = db.queryByExample(infec);
		System.out.println("DATOS DE BBDD CUARENTENA");
		System.out.println("registros "+result.size());
		while(result.hasNext()) {
			infec = result.next();
			System.out.println("Id: "+infec.getNumero()+" || Apellidos: "+infec.getApellidos()+" || Virus: "+infec.getVirus()+"|| Edad: "+infec.getEdad());
		}
		
		db.close();
		r.close();
		sentencia.close();
		conexion.close();
	}
	

}
