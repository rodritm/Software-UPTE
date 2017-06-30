package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Querry;

public class AcademicoGeneral {


	private JFrame frame;
	private JTextField tfRuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcademicoGeneral window = new AcademicoGeneral();
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
	public AcademicoGeneral() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 421, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JComboBox cbGestion = new JComboBox();
		cbGestion.setBounds(176, 32, 224, 24);
		frame.getContentPane().add(cbGestion);
		try{
			Querry q = new Querry();
			ResultSet rs = q.Gestiones();
			while(rs.next()) {
				cbGestion.addItem(rs.getString("gestion"));
			}
		}catch(Exception e) {
		}
		
		tfRuta = new JTextField();
		tfRuta.setBounds(12, 84, 255, 19);
		frame.getContentPane().add(tfRuta);
		tfRuta.setEditable(false);
		tfRuta.setColumns(10);
		
		JButton btnCarpeta = new JButton("CARPETA");
		btnCarpeta.setBounds(302, 81, 98, 25);
		frame.getContentPane().add(btnCarpeta);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(302, 118, 98, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblGestion = new JLabel("GESTION:");
		lblGestion.setBounds(80, 32, 55, 15);
		frame.getContentPane().add(lblGestion);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nuevo1 = new Reportes();
				nuevo1.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(12, 118, 98, 25);
		frame.getContentPane().add(btnAtras);
	}

}
