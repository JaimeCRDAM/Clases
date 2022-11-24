package segundo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ejemplo2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDenominacion;
	private JTextField txtEntrenador;
	private JTextField txtProvincia;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 frame = new Ejemplo2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejemplo2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 423, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(163, 195, 89, 23);
		panel.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(163, 229, 89, 23);
		panel.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(163, 263, 89, 23);
		panel.add(btnBorrar);
		
		JLabel lblCdigoDelEquipo = new JLabel("C\u00F3digo del Equipo:");
		lblCdigoDelEquipo.setBounds(10, 68, 96, 14);
		panel.add(lblCdigoDelEquipo);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo:");
		lblNombreEquipo.setBounds(24, 104, 78, 14);
		panel.add(lblNombreEquipo);
		
		JLabel lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setBounds(44, 135, 58, 14);
		panel.add(lblEntrenador);
		
		JLabel lblSiglaProvincia = new JLabel("Sigla Provincia:");
		lblSiglaProvincia.setBounds(24, 167, 78, 14);
		panel.add(lblSiglaProvincia);
		
		txtCodigo= new JTextField();
		txtCodigo.setBounds(139, 65, 40, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDenominacion = new JTextField();
		txtDenominacion.setBounds(139, 101, 161, 20);
		panel.add(txtDenominacion);
		txtDenominacion.setColumns(10);
		
		txtEntrenador = new JTextField();
		txtEntrenador.setBounds(139, 132, 161, 20);
		panel.add(txtEntrenador);
		txtEntrenador.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.setBounds(163, 164, 86, 20);
		panel.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
	}
	void modificar() {
		try {
			SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
			Session session = sesion.openSession();
			Transaction tx = session.beginTransaction();
			Equipo equipo = new Equipo();
			
			
			SessionFactory sesion2 = SessionFactoryUtil.getSessionFactory();
			Session session2 = sesion2.openSession();
			

			Equipo eq = (Equipo) session2.createQuery("from Equipo as e " + "where e.codequipo = ? ").setString(0, txtCodigo.getText().toUpperCase())
					.uniqueResult();
			
			if (eq!=null) {
				equipo.setCodequipo(txtCodigo.getText().toUpperCase());
				equipo.setDenoequipo(txtDenominacion.getText());
				equipo.setEntrenador(txtEntrenador.getText());
				equipo.setProvincia(txtProvincia.getText());

				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "DATOS MODIFICADOS");

				txtCodigo.setText("");
				txtDenominacion.setText("");
				txtEntrenador.setText("");
				txtProvincia.setText("");
			}

			session.update(equipo);
			tx.commit();
			session.close();

		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame,
					"ERROR AL MODIFICAR\n Campos incorrectos o IDRepetida");
		}

	}
	void insertar() {
		try {
			SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
			Session session = sesion.openSession();
			Transaction tx = session.beginTransaction();
			Equipo equipo = new Equipo();
			equipo.setCodequipo(txtCodigo.getText().toUpperCase());
			equipo.setDenoequipo(txtDenominacion.getText());
			equipo.setEntrenador(txtEntrenador.getText());
			equipo.setProvincia(txtProvincia.getText());
			;
			session.save(equipo);
			tx.commit();
			session.close();

			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "EQUIPO INSERTADO EN LA BASE DE DATOS");
		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame,
					"ERROR EN LA INSERCION \nAlguno de los campos es incorrecto\n"+
					"Puede que el Código del equipo ya exista");
		}

		txtCodigo.setText("");
		txtDenominacion.setText("");
		txtEntrenador.setText("");
		txtProvincia.setText("");
	}

	void borrar() {
		try {
			SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
			Session session = sesion.openSession();
			Transaction tx = session.beginTransaction();
			Equipo equipo = new Equipo();
			
			SessionFactory sesion2 = SessionFactoryUtil.getSessionFactory();
			Session session2 = sesion2.openSession();
			

			Equipo eq = (Equipo) session2.createQuery("from Equipo as e " + "where e.codequipo = ? ").setString(0, txtCodigo.getText().toUpperCase())
					.uniqueResult();
			
			if (eq!=null) {

				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "EQUIPO ELIMINADO");

				equipo.setCodequipo(txtCodigo.getText().toUpperCase());
				session.delete(equipo);
				tx.commit();
				session.close();
				
				txtCodigo.setText("");
				txtDenominacion.setText("");
				txtEntrenador.setText("");
				txtProvincia.setText("");
			}else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame,
						"No se encontró el equipo para eliminar");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame,
					"No se encontró el equipo para eliminar");
		}
		
	}
}
