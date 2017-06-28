package vista;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Reportes {

	private JFrame frame;
	private String [] botonescont = {"Recibos", "Recibos Anulados", "Cancelar"};
	private String [] botonesesta = {"Generales", "Genero", "Cursos ", "Edad", "Cancelar"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes window = new Reportes();
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
	public Reportes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nuevo = new Menu();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(296, 252, 133, 37);
		frame.getContentPane().add(btnAtras);
		
		JLabel label = new JLabel("");
		ImageIcon icon = new ImageIcon("images/logopeque.jpg");
		label.setIcon(icon);
		label.setBounds(10, 11, 219, 278);
		frame.getContentPane().add(label);
		
		JButton btnContables = new JButton("Contables");
		btnContables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int variable = JOptionPane.showOptionDialog (null, " Seleccione el reporte contable", "Reportes Contables",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonescont, botonescont[0]);
				switch (variable) {
				case 0:
					Recibos nuevo1 = new Recibos();
					nuevo1.main(null);
					frame.dispose();
					break;

				case 1:
					Anulados nuevo2 = new Anulados();
					nuevo2.main(null);
					frame.dispose();
					break;
				case 2:
					variable = 0 ;
					break;
			}
			}
		});
		btnContables.setBounds(296, 40, 133, 37);
		frame.getContentPane().add(btnContables);
		
		JButton btnEstadisiticos = new JButton("Estadisiticos");
		btnEstadisiticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int variable = JOptionPane.showOptionDialog (null, " Seleccione el reporte Estadistico", "Reportes Estadisticos",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonesesta, botonesesta[0]);
			}
		});
		btnEstadisiticos.setBounds(296, 88, 133, 37);
		frame.getContentPane().add(btnEstadisiticos);
		
		JButton btnAcademicos = new JButton("Academicos");
		btnAcademicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcademicos.setBounds(296, 136, 133, 37);
		frame.getContentPane().add(btnAcademicos);
	}

}
