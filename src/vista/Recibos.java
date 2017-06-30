package vista;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Recibos {

	private JFrame frame;
	private JTextField tfRuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recibos window = new Recibos();
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
	public Recibos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JComboBox cbGestion = new JComboBox();
		cbGestion.setBounds(176, 32, 224, 24);
		frame.getContentPane().add(cbGestion);
		
		JComboBox cbCurso = new JComboBox();
		cbCurso.setBounds(176, 75, 224, 24);
		frame.getContentPane().add(cbCurso);
		
		JComboBox cbParalelo = new JComboBox();
		cbParalelo.setBounds(176, 116, 224, 24);
		frame.getContentPane().add(cbParalelo);
		
		tfRuta = new JTextField();
		tfRuta.setBounds(22, 168, 255, 19);
		frame.getContentPane().add(tfRuta);
		tfRuta.setEditable(false);
		tfRuta.setColumns(10);
		
		JButton btnCarpeta = new JButton("CARPETA");
		btnCarpeta.setBounds(302, 165, 98, 25);
		frame.getContentPane().add(btnCarpeta);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gestion = (String) cbGestion.getSelectedItem();
				String curso = (String) cbCurso.getSelectedItem();
				String paralelo = (String) cbParalelo.getSelectedItem();
			}
		});
		btnOk.setBounds(302, 199, 98, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblGestion = new JLabel("GESTION:");
		lblGestion.setBounds(80, 32, 55, 15);
		frame.getContentPane().add(lblGestion);
		
		JLabel lblCurso = new JLabel("CURSO:");
		lblCurso.setBounds(80, 75, 55, 15);
		frame.getContentPane().add(lblCurso);
		
		JLabel lblParalelo = new JLabel("PARALELO: ");
		lblParalelo.setBounds(80, 121, 78, 15);
		frame.getContentPane().add(lblParalelo);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nuevo1 = new Reportes();
				nuevo1.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(22, 199, 98, 25);
		frame.getContentPane().add(btnAtras);
	}
}