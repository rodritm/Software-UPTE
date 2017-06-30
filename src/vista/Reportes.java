package vista;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Reportes extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	
	private String [] botonescont = {"Recibos", "Recibos Anulados", "Cancelar"};
	private String [] botonesesta = {"Generales", "Genero", "Cursos ", "Edad", "Cancelar"};
	private String [] botonesacad = {"Generales", "Cursos ", "Cancelar"};

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
		frame.setBounds(100, 100, 623, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JButton btnAtras = new JButton("");
		URL url1 = Home.class.getResource("/rep/4.png");
		ImageIcon icon1 = new ImageIcon(url1);
		btnAtras.setIcon(icon1);
		btnAtras.setBorder(null);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nuevo = new Menu();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(371, 257, 217, 57);
		frame.getContentPane().add(btnAtras);		
		
		JButton btnContables = new JButton("");
		URL url2 = Home.class.getResource("/rep/1.png");
		ImageIcon icon2 = new ImageIcon(url2);
		btnContables.setIcon(icon2);
		btnContables.setBorder(null);
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
		btnContables.setBounds(371, 56, 217, 57);
		frame.getContentPane().add(btnContables);
		
		JButton btnEstadisiticos = new JButton("");
		URL url3 = Home.class.getResource("/rep/2.png");
		ImageIcon icon3 = new ImageIcon(url3);
		btnEstadisiticos.setIcon(icon3);
		btnEstadisiticos.setBorder(null);
		btnEstadisiticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int variable = JOptionPane.showOptionDialog (null, " Seleccione el reporte Estadistico", "Reportes Estadisticos",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonesesta, botonesesta[0]);
				switch (variable) {
				case 0:
					EstadisticoGeneral nuevo0 = new EstadisticoGeneral();
					nuevo0.main(null);
					frame.dispose();
					break;

				case 1:
					EstadisticoGenero nuevo1 = new EstadisticoGenero();
					nuevo1.main(null);
					frame.dispose();
					break;
				case 2:
					EstadisticoCurso nuevo2 = new EstadisticoCurso();
					nuevo2.main(null);
					frame.dispose();
					break;
				case 3:
					EstadisticoEdad nuevo3 = new EstadisticoEdad();
					nuevo3.main(null);
					frame.dispose();
					break;
				case 4:
					variable = 0 ;
					break;
				}
			}
		});
		btnEstadisiticos.setBounds(371, 123, 217, 57);
		frame.getContentPane().add(btnEstadisiticos);
		
		JButton btnAcademicos = new JButton("");
		URL urla = Home.class.getResource("/rep/3.png");
		ImageIcon icona = new ImageIcon(urla);
		btnAcademicos.setIcon(icona);
		btnAcademicos.setBorder(null);
		btnAcademicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int variable = JOptionPane.showOptionDialog (null, " Seleccione el reporte Academico", "Reportes Estadisticos",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonesacad, botonesacad[0]);
				switch (variable) {
				case 0:
					AcademicoGeneral nuevo0 = new AcademicoGeneral();
					nuevo0.main(null);
					frame.dispose();
					break;

				case 1:
					AcademicoCursos nuevo2 = new AcademicoCursos();
					nuevo2.main(null);
					frame.dispose();
					break;
				case 2:
					variable = 0 ;
					break;
				}
			}
		});
		btnAcademicos.setBounds(371, 190, 217, 57);
		frame.getContentPane().add(btnAcademicos);
		
		
		JLabel label = new JLabel("");
		((JPanel)getContentPane()).setOpaque(false); 
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/rep/fondo.png")); 
		label.setIcon(uno); 
		getLayeredPane().add(label,JLayeredPane.FRAME_CONTENT_LAYER); 
		label.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		
		frame.getContentPane().add(label);
	}

}
