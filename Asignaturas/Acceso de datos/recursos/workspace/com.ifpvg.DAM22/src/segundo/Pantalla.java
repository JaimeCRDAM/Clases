package segundo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;




public class Pantalla extends JFrame {

	private JPanel contentPane;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 423, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEjercicio = new JButton("Ejercicio 4");
		btnEjercicio.setBounds(226, 150, 89, 23);
		panel.add(btnEjercicio);
		
		JButton btnEjemplo = new JButton("Ejemplo 2");
		btnEjemplo.setBounds(103, 150, 89, 23);
		panel.add(btnEjemplo);
		btnEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Ejercicio4 ventana = new Ejercicio4();
				ventana.setVisible(true);
			}
		});
		
		btnEjemplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Ejemplo2 ventana = new Ejemplo2();
				ventana.setVisible(true);
			}
		});
	}

}
