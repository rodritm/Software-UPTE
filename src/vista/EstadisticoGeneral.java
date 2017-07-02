package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Querry;

public class EstadisticoGeneral {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadisticoGeneral window = new EstadisticoGeneral();
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
	public EstadisticoGeneral() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 219);
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
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(302, 168, 98, 25);
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
		btnAtras.setBounds(37, 168, 98, 25);
		frame.getContentPane().add(btnAtras);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gestion = (String) cbGestion.getSelectedItem();
				
				String num = "";
				try {
					ResultSet rs = null;
					Querry qqq = new Querry();
					rs = qqq.EstGeneral(gestion);
					if( rs!= null){
						 for(;rs.next();){
							 num=rs.getString("Total");
				               
						 }
						 JOptionPane.showMessageDialog(null, "Estadistico general: "+num);
			        	
			        }
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "error: "+e1);
				}
				
		        
			}
		});
	}
}
