package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrar {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrar window = new Administrar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Administrar() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUsuarios = new JButton("USUARIOS ");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarUsuario nuevo = new AdministrarUsuario();
				nuevo.main(null);
				frame.dispose();
				
			}
		});
		btnUsuarios.setBounds(147, 40, 124, 38);
		frame.getContentPane().add(btnUsuarios);
		
		JButton btnDocentes = new JButton("DOCENTES");
		btnDocentes.setBounds(147, 90, 124, 38);
		frame.getContentPane().add(btnDocentes);
		
		JButton btnMaterias = new JButton("MATERIAS");
		btnMaterias.setBounds(147, 140, 124, 38);
		frame.getContentPane().add(btnMaterias);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nuevo = new Menu();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(147, 251, 124, 25);
		frame.getContentPane().add(btnAtras);
	}
}
