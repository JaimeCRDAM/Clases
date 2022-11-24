package Prueba;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//IMPORTS DE EXITS
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;



public class Pantalla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEquipo;
	private JTextField txtDenominacion;
	private JTextField txtEdadMedia;
	private JTextField txtProvincia;

	/**
	 * Create the frame.
	 */
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Aqui están los botones
		//para la consulta
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {			
					try {		
						consulta(txtEquipo.getText());														
					} catch (XMLDBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		btnConsultar.setBounds(313, 80, 97, 25);
		contentPane.add(btnConsultar);

		//para dar de alta
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					alta(txtEquipo.getText().toUpperCase(), txtDenominacion.getText(), txtEdadMedia.getText());
				} catch (XMLDBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
		});
		btnAlta.setBounds(72, 214, 103, 25);
		contentPane.add(btnAlta);
		
		//para dar de baja
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		btnBaja.setBounds(187, 214, 103, 25);
		contentPane.add(btnBaja);
		
		//para modificar
		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificacion();
			}
		});
		btnModificacion.setBounds(307, 214, 103, 25);
		contentPane.add(btnModificacion);
		
		
		//para limpiar
		JButton btnLimpiar = new JButton("Limpiar");
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(422, 214, 103, 25);
		contentPane.add(btnLimpiar);
		
		//Aquí los label y los textos
		
		JLabel lbl1 = new JLabel("GESTION DE EQUIPOS:");
		lbl1.setBounds(74, 47, 139, 16);
		contentPane.add(lbl1);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo:");
		lblNewLabel_1.setBounds(116, 113, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl3 = new JLabel("Denominación:");
		lbl3.setBounds(116, 84, 97, 16);
		contentPane.add(lbl3);
		
		
		JLabel lblNewLabel = new JLabel("Edad media: ");
		lblNewLabel.setBounds(116, 142, 92, 16);
		contentPane.add(lblNewLabel);
		
	
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(210, 81, 80, 22);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		txtDenominacion = new JTextField();
		txtDenominacion.setBounds(210, 110, 200, 22);
		contentPane.add(txtDenominacion);
		txtDenominacion.setColumns(10);
		
	
		txtEdadMedia = new JTextField();
		txtEdadMedia.setBounds(210, 139, 200, 22);
		contentPane.add(txtEdadMedia);
		txtEdadMedia.setColumns(10);
			
		
	}
	
	private void consulta(String txt) throws XMLDBException {
		String driver = "org.exist.xmldb.DatabaseImpl";
		Collection col = null;
		String URL = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionLiga";
		String usu = "admin";
		String pwd = "admin";
		
		
		
		try {
			Class cl = Class.forName(driver);
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);
		}catch(Exception e){
			System.out.println("Error al inicializar la BD eXist");
		}
		
		
		col = DatabaseManager.getCollection(URL,usu,pwd);
		if(col == null) {
			System.out.println("*** LA COLECCION NO EXISTE ***");
		}
		
		XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/CODEQUIPO return data($em)");
		ResourceSet resultEnt = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/DENOEQUIPO return data($em)");
		ResourceSet resultProv = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/edadMedia return data($em)");
		ResourceIterator i;
		ResourceIterator x;
		ResourceIterator y;
		
		i = resultDeno.getIterator();
		x = resultEnt.getIterator();
		y = resultProv.getIterator();
			
		if(!i.hasMoreResources() || !x.hasMoreResources() || !y.hasMoreResources()) {
			System.out.println("*** LA CONSULTA ESTA VACIA ***");
		}else {
			
			while (i.hasMoreResources()) {
				Resource r = i.nextResource();
				txtEquipo.setText((String) r.getContent());
			}
					
			while (x.hasMoreResources()) {
				Resource r = x.nextResource();
				txtDenominacion.setText((String) r.getContent());
			}
					
			while (y.hasMoreResources()) {
				Resource r = y.nextResource();
				txtEdadMedia.setText((String) r.getContent());
			}
		}
		
		col.close();
	}
	
	private void alta(String cod, String deno, String entrenador, String provincia) throws XMLDBException {
		String driver = "org.exist.xmldb.DatabaseImpl";
		Collection col = null;
		String URL = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionLiga";
		String usu = "admin";
		String pwd = "admin";
		
		
		
		try {
			Class cl = Class.forName(driver);
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);
		}catch(Exception e){
			System.out.println("Error al inicializar la BD eXist");
		}
		
		
		col = DatabaseManager.getCollection(URL,usu,pwd);
		if(col == null) {
			System.out.println("*** LA COLECCION NO EXISTE ***");
		}
		
		String query = "update insert <equipo CODEQUIPO='"+cod+"'><DENOEQUIPO>"+ deno +"</DENOEQUIPO><edadMedia>0</edadMedia></equipo> into /equipos";
		
		XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+cod+"']/DENOEQUIPO return data($em)");
	
		ResourceIterator i;
		
		i = resultDeno.getIterator();

			
		if(i.hasMoreResources()) {
			JOptionPane.showMessageDialog(null, "El equipo ya existe.");
			limpiar();
		}else {
			servicio.query(query);
			JOptionPane.showMessageDialog(null, "Insercion realizada.");
			limpiar();
		}
		
		col.close();
				
		
	}
	
	private void baja(String cod) throws XMLDBException {
		//VARIABLES
				
				String driver = "org.exist.xmldb.DatabaseImpl";
				Collection col = null;
				String URL = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionLiga";
				String usu = "admin";
				String pwd = "admin";
				
				
				//CODIGO
				try {
					Class cl = Class.forName(driver);
					Database database = (Database) cl.newInstance();
					DatabaseManager.registerDatabase(database);
				}catch(Exception e){
					System.out.println("Error al inicializar la BD eXist");
				}
				
				
				col = DatabaseManager.getCollection(URL,usu,pwd);
				if(col == null) {
					System.out.println("*** LA COLECCION NO EXISTE ***");
				}
				
				String query = "update delete /equipos/equipo[@CODEQUIPO = '"+cod+"']";
				XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+cod+"'] return data($em)");
				ResourceSet resultEnt = servicio.query("count(/jugadores/jugador[@EQUIPO= '"+cod+"'])");
	
				ResourceIterator i;
				ResourceIterator x;
				
				i = resultDeno.getIterator();
				x = resultEnt.getIterator();
				int comp = 0;	
				if(i.hasMoreResources()) {//<-- si el equipo exixte
					if(i.hasMoreResources()) {
						while (x.hasMoreResources()) {
							Resource r = x.nextResource();
							comp = Integer.parseInt(r.getContent().toString());
						}
						
						if (comp == 0) {
							servicio.query(query);
							JOptionPane.showMessageDialog(null, "Equipo borrado.");	
							limpiar();
						}else {
							JOptionPane.showMessageDialog(null, "Error, el equipo tiene jugadores.");
							limpiar();
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "No existe el equipo.");	
					limpiar();
				}
			
				col.close();
	}
	
	private void modificacion(String cod) throws XMLDBException{
		String driver = "org.exist.xmldb.DatabaseImpl";
		Collection col = null;
		String URL = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionLiga";
		String usu = "admin";
		String pwd = "admin";

	
		try {
			Class cl = Class.forName(driver);
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);
		} catch (Exception e) {
			System.out.println("Error al inicializar la BD eXist");
		}

		col = DatabaseManager.getCollection(URL, usu, pwd);
		if (col == null) {
			System.out.println("*** LA COLECCION NO EXISTE ***");
		}

		
		XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='" + cod + "'] return data($em)");
		ResourceSet resultCount = servicio.query("count(/jugadores/jugador[@EQUIPO= '" + cod + "'])");
		ResourceSet resultMedia = servicio.query("sum(/jugadores/jugador[@EQUIPO='"+cod+"']/EDAD)");
		
		ResourceIterator i;
		ResourceIterator x;
		ResourceIterator y;

		i = resultDeno.getIterator();
		x = resultCount.getIterator();
		y = resultMedia.getIterator();
		
		int comp = 0;
		int sum = 0;
		if (i.hasMoreResources()) {// <-- si el equipo exixte
			if (i.hasMoreResources()) {
				while (x.hasMoreResources()) {
					Resource r = x.nextResource();
					comp = Integer.parseInt(r.getContent().toString());
				}
				
				while (y.hasMoreResources()) {
					Resource r = y.nextResource();
					sum = Integer.parseInt(r.getContent().toString());
				}

				if (comp != 0) {
					System.out.println("sum --> " +sum);
					System.out.println("med --> " +comp);
					double media = sum/comp;
					String query = "update replace /equipos/equipo[@CODEQUIPO ='"+cod+"']/edadMedia with <edadMedia>"+media+"</edadMedia>";
					
					servicio.query(query);	
					JOptionPane.showMessageDialog(null, "Media actualizada.");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "Error, el equipo no tiene jugadores.");
					limpiar();
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "No existe el equipo.");
			limpiar();
		}

		col.close();
	}
	
	private void limpiar() {
		txtEquipo.setText("");
		txtDenominacion.setText("");
		txtEdadMedia.setText(""); 
	}
	
}
	
	

