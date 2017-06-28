package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Academicos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Academicos window = new Academicos();
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
	public Academicos() {
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
		
		JButton btnGeneral = new JButton("GENERAL");
		btnGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcademicoGeneral nueva = new AcademicoGeneral();
				frame.dispose();
				nueva.main(null);
			}
		});
		btnGeneral.setBounds(164, 43, 98, 40);
		frame.getContentPane().add(btnGeneral);
		
		JButton btnCursos = new JButton("CURSOS");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcademicoCursos nueva = new AcademicoCursos();
				frame.dispose();
				nueva.main(null);
			}
		});
		btnCursos.setBounds(164, 95, 98, 40);
		frame.getContentPane().add(btnCursos);
		
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nuevo = new Reportes();
				frame.dispose();
				nuevo.main(null);
			}
		});
		btnSalir.setBounds(164, 239, 98, 31);
		frame.getContentPane().add(btnSalir);
	}
}
