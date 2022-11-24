package Elena;

import java.sql.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;



public class Importa {
	final static String BDCuarentena="CUARENTENA.yap";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conexion = (Connection) DriverManager.getConnection("jdbc:odbc:Access");*/
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCuarentena);
		//hace la conexion
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
        Connection conexion = (Connection) DriverManager.getConnection("jdbc:ucanaccess://C://Users//LENOVO//Desktop/Recupera.accdb");
        
        
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("select * from infectados");
        
        while(rs.next()) {
        	//System.out.println("Id: "+rs.getInt("numero")+"  Apellidos: "+rs.getString("apellidos")+"  Virus: "+rs.getString("virus")+"|| Edad: "+rs.getInt("edad"));
        	
        	Infectado i= new Infectado();
        	i.setNumero(rs.getInt("numero"));
        	i.setApellidos(rs.getString("apellidos"));
        	i.setVirus(rs.getString("virus"));
        	i.setEdad(rs.getInt("edad"));
        	db.store(i);
        }
		
        Infectado i2 = new Infectado();
        ObjectSet<Infectado> resultado = db.queryByExample(i2);
        System.out.println("Imprimiendo los datos de la base de datos Infectado:");
        while(resultado.hasNext()) {
        	i2=resultado.next();
        	System.out.println("Id: "+i2.getNumero()+"  Apellidos: "+i2.getApellidos()+"  Virus: "+i2.getVirus()+"|| Edad: "+i2.getEdad());
        }
        
        db.close();
        rs.close();
        st.close();
        conexion.close();
	}

}
