package actividadUno_MGI;

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

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtDeno;
	private JTextField txtEntrenador;
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
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//AQUI ESTAN LOS BOTONES
		
		//BOTON CONSULTAR
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {			
					try {		
						consulta(txtCod.getText());														
					} catch (XMLDBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		btnConsultar.setBounds(313, 80, 97, 25);
		contentPane.add(btnConsultar);
		
		//BOTON ALTA
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					alta(txtCod.getText().toUpperCase(), txtDeno.getText(), txtEntrenador.getText(), txtProvincia.getText());
				} catch (XMLDBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
		});
		btnAlta.setBounds(72, 214, 103, 25);
		contentPane.add(btnAlta);
		
		//BOTON BAJA
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		btnBaja.setBounds(187, 214, 103, 25);
		contentPane.add(btnBaja);
		
		//BOTON MODIFICACION
		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificacion();
			}
		});
		btnModificacion.setBounds(307, 214, 103, 25);
		contentPane.add(btnModificacion);
		
		//BOTON LIMPIAR
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(422, 214, 103, 25);
		contentPane.add(btnLimpiar);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//AQUI ESTAN LOS LABEL
		
		JLabel lbl1 = new JLabel("GESTION DE EQUIPOS:");
		lbl1.setBounds(74, 47, 139, 16);
		contentPane.add(lbl1);
		
		JLabel lblNewLabel_1 = new JLabel("Denominacion:");
		lblNewLabel_1.setBounds(116, 113, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl3 = new JLabel("Codigo:");
		lbl3.setBounds(116, 84, 97, 16);
		contentPane.add(lbl3);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setBounds(121, 108, 56, 16);
		contentPane.add(lbl2);
		
		JLabel lblNewLabel = new JLabel("Entrenador: ");
		lblNewLabel.setBounds(116, 142, 92, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia:");
		lblNewLabel_2.setBounds(116, 171, 92, 16);
		contentPane.add(lblNewLabel_2);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//AQUI ESTAN LOS TXT
		
		txtCod = new JTextField();
		txtCod.setBounds(210, 81, 80, 22);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtDeno = new JTextField();
		txtDeno.setBounds(210, 110, 200, 22);
		contentPane.add(txtDeno);
		txtDeno.setColumns(10);
		
		txtEntrenador = new JTextField();
		txtEntrenador.setBounds(210, 139, 200, 22);
		contentPane.add(txtEntrenador);
		txtEntrenador.setColumns(10);
			
		
		txtProvincia = new JTextField();
		txtProvincia.setBounds(210, 168, 200, 22);
		contentPane.add(txtProvincia);
		txtProvincia.setColumns(10);
	}
	
	private void consulta(String txt) throws XMLDBException {
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
		
		XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/DENOEQUIPO return data($em)");
		ResourceSet resultEnt = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/ENTRENADOR return data($em)");
		ResourceSet resultProv = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+txt+"']/PROVINCIA return data($em)");
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
				txtDeno.setText((String) r.getContent());
			}
					
			while (x.hasMoreResources()) {
				Resource r = x.nextResource();
				txtEntrenador.setText((String) r.getContent());
			}
					
			while (y.hasMoreResources()) {
				Resource r = y.nextResource();
				txtProvincia.setText((String) r.getContent());
			}
		}
		
		col.close();
	}
	
	private void alta(String cod, String deno, String entrenador, String provincia) throws XMLDBException {
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
		
		String query = "update insert <equipo CODEQUIPO='"+cod+"'><DENOEQUIPO>"+ deno +"</DENOEQUIPO><ENTRENADOR>"+entrenador+"</ENTRENADOR><PROVINCIA>"+provincia+"</PROVINCIA><edadMedia>0</edadMedia></equipo> into /equipos";
		
		XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		ResourceSet resultDeno = servicio.query("for $em in /equipos/equipo[@CODEQUIPO='"+cod+"']/DENOEQUIPO return data($em)");
	
		ResourceIterator i;
		
		i = resultDeno.getIterator();

			
		if(i.hasMoreResources()) {
			JOptionPane.showMessageDialog(null, "El equipo ya existe...");
			limpiar();
		}else {
			servicio.query(query);
			JOptionPane.showMessageDialog(null, "Insercion realizada...");
			limpiar();
		}
		
		col.close();
				
		
	}
	
	private void baja() {
		
	}
	
	private void modificacion() {
		
	}
	
	private void limpiar() {
		txtCod.setText("");
		txtDeno.setText("");
		txtEntrenador.setText("");
		txtEntrenador.setText("");
		txtProvincia.setText("");
	}
	
}
