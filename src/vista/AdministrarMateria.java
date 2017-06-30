package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Querry;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AdministrarMateria {

	private JFrame frame;
	private JTextField tfSigla;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JLabel lblParalelo;
	private JTextField tfParalelo;
	private JLabel lblDocente;
	private JComboBox cbDocente;
	private JLabel lblHora;
	private JTextField tfHora;
	private JTextField tfMin;
	private JLabel label;
	private JLabel lblAula;
	private JTextField tfAula;
	private JButton btnCancelar;
	private JButton btnOk;
	private JLabel lblMonto;
	private JTextField textField;
	private JLabel lblTiempo;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarMateria window = new AdministrarMateria();
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
	public AdministrarMateria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setBounds(100, 100, 450, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSiglaDeLa = new JLabel("Sigla de la materia:");
		lblSiglaDeLa.setBounds(12, 12, 108, 15);
		frame.getContentPane().add(lblSiglaDeLa);
		
		tfSigla = new JTextField();
		tfSigla.setBounds(128, 10, 63, 19);
		frame.getContentPane().add(tfSigla);
		tfSigla.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 39, 55, 15);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(71, 37, 367, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		lblParalelo = new JLabel("Paralelo:");
		lblParalelo.setBounds(12, 66, 55, 15);
		frame.getContentPane().add(lblParalelo);
		
		tfParalelo = new JTextField();
		tfParalelo.setBounds(71, 62, 55, 19);
		frame.getContentPane().add(tfParalelo);
		tfParalelo.setColumns(10);
		
		lblDocente = new JLabel("Docente:");
		lblDocente.setBounds(12, 93, 55, 15);
		frame.getContentPane().add(lblDocente);
		
		cbDocente = new JComboBox();
		cbDocente.setBounds(71, 88, 367, 24);
		frame.getContentPane().add(cbDocente);
		try{
			Querry q = new Querry();
			ResultSet rs = q.Docentes();
			while(rs.next()) {
				cbDocente.addItem(rs.getString("nombres"));
			}
		}catch(Exception e) {
		}
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(150, 64, 55, 15);
		frame.getContentPane().add(lblHora);
		
		tfHora = new JTextField();
		tfHora.setBounds(187, 62, 35, 19);
		frame.getContentPane().add(tfHora);
		tfHora.setColumns(10);
		
		tfMin = new JTextField();
		tfMin.setColumns(10);
		tfMin.setBounds(238, 62, 35, 19);
		frame.getContentPane().add(tfMin);
		
		label = new JLabel(":");
		label.setBounds(228, 62, 20, 15);
		frame.getContentPane().add(label);
		
		lblAula = new JLabel("Aula:");
		lblAula.setBounds(305, 64, 55, 15);
		frame.getContentPane().add(lblAula);
		
		tfAula = new JTextField();
		tfAula.setBounds(341, 62, 97, 19);
		frame.getContentPane().add(tfAula);
		tfAula.setColumns(10);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showOptionDialog(null, "Esta segura/o?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[]{"SI","NO"},"SI");
						
						if(option == 0){
							Administrar nuevo = new Administrar();
							nuevo.main(null);
							frame.dispose();
						}
			}
		});
		btnCancelar.setBounds(228, 169, 98, 25);
		frame.getContentPane().add(btnCancelar);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(341, 169, 98, 25);
		frame.getContentPane().add(btnOk);
		
		lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(12, 120, 55, 15);
		frame.getContentPane().add(lblMonto);
		
		textField = new JTextField();
		textField.setBounds(71, 118, 97, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(187, 120, 55, 15);
		frame.getContentPane().add(lblTiempo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(260, 115, 178, 24);
		frame.getContentPane().add(comboBox);
	}

}
