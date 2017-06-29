package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarUsuario {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblApellidoPaterno;
	private JTextField textField_1;
	private JLabel lblApellidoMaterno;
	private JTextField textField_2;
	private JLabel lblCarnet;
	private JTextField textField_3;
	private JLabel lblFechaNacimiento;
	private JTextField textField_4;
	private JLabel lblCelular;
	private JTextField textField_5;
	private JLabel lblContrasea;
	private JTextField textField_6;
	private JLabel lblTipo;
	private JComboBox comboBox;
	private JButton btnCancelar;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarUsuario window = new AdministrarUsuario();
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
	public AdministrarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 12, 55, 15);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(69, 10, 369, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(12, 39, 96, 15);
		frame.getContentPane().add(lblApellidoPaterno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 37, 312, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(12, 66, 114, 15);
		frame.getContentPane().add(lblApellidoMaterno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 64, 312, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblCarnet = new JLabel("Carnet:");
		lblCarnet.setBounds(12, 93, 55, 15);
		frame.getContentPane().add(lblCarnet);
		
		textField_3 = new JTextField();
		textField_3.setBounds(62, 91, 114, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(194, 93, 104, 15);
		frame.getContentPane().add(lblFechaNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(303, 93, 135, 19);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblDireccion = new JLabel("DIreccion:");
		lblDireccion.setBounds(12, 122, 73, 15);
		frame.getContentPane().add(lblDireccion);
		
		textField_4 = new JTextField();
		textField_4.setBounds(82, 120, 356, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(12, 149, 55, 15);
		frame.getContentPane().add(lblCelular);
		
		textField_5 = new JTextField();
		textField_5.setBounds(62, 147, 135, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(12, 176, 83, 15);
		frame.getContentPane().add(lblContrasea);
		
		textField_6 = new JTextField();
		textField_6.setBounds(96, 174, 342, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(215, 149, 38, 15);
		frame.getContentPane().add(lblTipo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(271, 144, 167, 24);
		frame.getContentPane().add(comboBox);
		
		btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(215, 211, 98, 25);
		frame.getContentPane().add(btnCancelar);
		
		btnOk = new JButton("ok");
		btnOk.setBounds(340, 211, 98, 25);
		frame.getContentPane().add(btnOk);
	}
}
