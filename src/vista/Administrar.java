package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Administrar extends JFrame{

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
		frame.setBounds(100, 100, 633, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUsuarios = new JButton("");
		URL url1 = Home.class.getResource("/adm/1.png");
		ImageIcon icon1 = new ImageIcon(url1);
		btnUsuarios.setIcon(icon1);
		btnUsuarios.setBorder(null);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarUsuario nuevo = new AdministrarUsuario();
				nuevo.main(null);
				frame.dispose();
				
			}
		});
		btnUsuarios.setBounds(367, 73, 217, 57);
		frame.getContentPane().add(btnUsuarios);
		
		JButton btnDocentes = new JButton("");
		btnDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarDocente nuevo = new AdministrarDocente();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnDocentes.setBounds(367, 140, 217, 57);
		URL url2 = Home.class.getResource("/adm/2.png");
		ImageIcon icon2 = new ImageIcon(url2);
		btnDocentes.setIcon(icon2);
		btnDocentes.setBorder(null);
		frame.getContentPane().add(btnDocentes);
		
		JButton btnMaterias = new JButton("");
		URL url3 = Home.class.getResource("/adm/3.png");
		ImageIcon icon3 = new ImageIcon(url3);
		btnMaterias.setIcon(icon3);
		btnMaterias.setBorder(null);
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarMateria nuevo = new AdministrarMateria();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnMaterias.setBounds(367, 207, 217, 57);
		frame.getContentPane().add(btnMaterias);
		
		JButton btnAtras = new JButton("");
		URL url4 = Home.class.getResource("/adm/4.png");
		ImageIcon icon4 = new ImageIcon(url4);
		btnAtras.setIcon(icon4);
		btnAtras.setBorder(null);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnAtras.setBounds(367, 274, 217, 57);
		frame.getContentPane().add(btnAtras);
		
		JLabel label = new JLabel("");
		((JPanel)getContentPane()).setOpaque(false); 
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/adm/fondo.png")); 
		label.setIcon(uno); 
		getLayeredPane().add(label,JLayeredPane.FRAME_CONTENT_LAYER); 
		label.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		
		frame.getContentPane().add(label);
	}	
}
