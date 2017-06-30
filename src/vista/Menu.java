package vista;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controlador.Empleados;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{

	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton Btinsc = new JButton("");
		URL url4 = Home.class.getResource("/ini/4.png");
		ImageIcon icon4 = new ImageIcon(url4);
		Btinsc.setIcon(icon4);
		Btinsc.setBorder(null);
		Btinsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha nueva = new Ficha();
				frame.dispose();
				nueva.main(null);
			}
		});
		Btinsc.setBounds(293, 38, 217, 57);
		frame.getContentPane().add(Btinsc);
		
		JButton Btreport = new JButton("");
		URL url2 = Home.class.getResource("/ini/2.png");
		ImageIcon icon2 = new ImageIcon(url2);
		Btreport.setIcon(icon2);
		Btreport.setBorder(null);
		Btreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nueva = new Reportes();
				frame.dispose();
				nueva.main(null);
			}
		});
		Btreport.setBounds(12, 146, 217, 57);		
		frame.getContentPane().add(Btreport);
		
		
		JButton btsalir = new JButton("");
		URL url6 = Home.class.getResource("/ini/6.png");
		ImageIcon icon6 = new ImageIcon(url6);
		btsalir.setIcon(icon6);
		btsalir.setBorder(null);
		btsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home nuevo = new Home();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btsalir.setBounds(700, 12, 88, 24);
		frame.getContentPane().add(btsalir);
		
		JButton btnAdministrar = new JButton("");
		URL url3 = Home.class.getResource("/ini/3.png");
		ImageIcon icon3 = new ImageIcon(url3);
		btnAdministrar.setIcon(icon4);
		btnAdministrar.setBorder(null);
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrar nuevo = new Administrar();
				frame.dispose();
				nuevo.main(null);
			}
		});
		btnAdministrar.setBounds(12, 259, 217, 57);
		frame.getContentPane().add(btnAdministrar);
		
		JButton btnInscribir = new JButton("");
		URL url1 = Home.class.getResource("/ini/1.png");
		ImageIcon icon1 = new ImageIcon(url1);
		btnInscribir.setIcon(icon1);
		btnInscribir.setBorder(null);
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscribir nuevo = new Inscribir();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnInscribir.setBounds(571, 146, 217, 57);
		frame.getContentPane().add(btnInscribir);
		
		JButton btnNewButton = new JButton("");
		URL url5 = Home.class.getResource("/ini/5.png");
		ImageIcon icon5 = new ImageIcon(url5);
		btnNewButton.setIcon(icon5);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anular nuevo = new Anular();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(571, 259, 217, 57);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		((JPanel)getContentPane()).setOpaque(false); 
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/ini/fondo.png")); 
		label.setIcon(uno); 
		getLayeredPane().add(label,JLayeredPane.FRAME_CONTENT_LAYER); 
		label.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		
		frame.getContentPane().add(label);
	}

}
