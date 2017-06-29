package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Anular {

	private JFrame frame;
	private JTextField tfRuta;
	private JTextField tfNumero;
	private JTextField tfGestion;
	private JTextField tfCurso;
	private JTextField tfParalelo;
	private JTextField tfMonto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anular window = new Anular();
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
	public Anular() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 421, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		tfRuta = new JTextField();
		tfRuta.setBounds(22, 184, 255, 19);
		frame.getContentPane().add(tfRuta);
		tfRuta.setEditable(false);
		tfRuta.setColumns(10);
		
		JButton btnCarpeta = new JButton("CARPETA");
		btnCarpeta.setBounds(302, 181, 98, 25);
		frame.getContentPane().add(btnCarpeta);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(302, 218, 98, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblGestion = new JLabel("GESTION:");
		lblGestion.setBounds(80, 75, 55, 15);
		frame.getContentPane().add(lblGestion);
		
		JLabel lblCurso = new JLabel("CURSO:");
		lblCurso.setBounds(80, 102, 55, 15);
		frame.getContentPane().add(lblCurso);
		
		JLabel lblParalelo = new JLabel("PARALELO: ");
		lblParalelo.setBounds(81, 129, 78, 15);
		frame.getContentPane().add(lblParalelo);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nuevo1 = new Menu();
				nuevo1.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(22, 218, 98, 25);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setBounds(80, 46, 55, 15);
		frame.getContentPane().add(lblNumero);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(149, 44, 251, 19);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);
		
		tfGestion = new JTextField();
		tfGestion.setColumns(10);
		tfGestion.setBounds(149, 73, 251, 19);
		tfGestion.setEditable(false);
		frame.getContentPane().add(tfGestion);
		
		tfCurso = new JTextField();
		tfCurso.setColumns(10);
		tfCurso.setBounds(149, 100, 251, 19);
		tfCurso.setEditable(false);
		frame.getContentPane().add(tfCurso);
		
		tfParalelo = new JTextField();
		tfParalelo.setColumns(10);
		tfParalelo.setBounds(170, 127, 65, 19);
		tfParalelo.setEditable(false);
		frame.getContentPane().add(tfParalelo);
		
		JLabel lblMonto = new JLabel("MONTO:     bs.");
		lblMonto.setBounds(80, 157, 79, 15);
		frame.getContentPane().add(lblMonto);
		
		tfMonto = new JTextField();
		tfMonto.setEditable(false);
		tfMonto.setColumns(10);
		tfMonto.setBounds(170, 153, 65, 19);
		frame.getContentPane().add(tfMonto);
	}

}
