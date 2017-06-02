import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ficha {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha window = new Ficha();
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
	public Ficha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setBounds(0, 0, 10000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEstudiantes = new JLabel("Estudiantes");
		lblEstudiantes.setBounds(12, 12, 94, 15);
		frame.getContentPane().add(lblEstudiantes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 32, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(76, 30, 584, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(12, 85, 139, 15);
		frame.getContentPane().add(lblApellidoPaterno);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(1006, 672, 117, 25);
		frame.getContentPane().add(btnAtras);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 83, 519, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellido Materno:");
		lblNewLabel.setBounds(12, 58, 139, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 56, 519, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCedulaDeIdentidad = new JLabel("Cedula de identidad:");
		lblCedulaDeIdentidad.setBounds(12, 112, 159, 15);
		frame.getContentPane().add(lblCedulaDeIdentidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 110, 251, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblExp = new JLabel("exp:");
		lblExp.setBounds(433, 112, 70, 15);
		frame.getContentPane().add(lblExp);
		
		JList list = new JList();
		list.setBounds(1155, 61, 1, 1);
		frame.getContentPane().add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 166, 217, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 144, 163, 15);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JDateChooser fechanc = new JDateChooser();
		fechanc.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		fechanc.setBounds(174, 141, 175, 19);
		frame.getContentPane().add(fechanc);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setBounds(330, 171, 85, 15);
		frame.getContentPane().add(lblEstadoCivil);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(476, 107, 184, 24);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 171, 70, 15);
		frame.getContentPane().add(lblGenero);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(76, 166, 217, 24);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(385, 144, 70, 15);
		frame.getContentPane().add(lblEdad);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(443, 142, 114, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(12, 198, 70, 15);
		frame.getContentPane().add(lblDireccin);
		
		textField_5 = new JTextField();
		textField_5.setBounds(86, 196, 418, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNo = new JLabel("No:");
		lblNo.setBounds(522, 198, 29, 15);
		frame.getContentPane().add(lblNo);
		
		textField_6 = new JTextField();
		textField_6.setBounds(556, 196, 104, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(60, 223, 251, 19);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setBounds(12, 225, 47, 15);
		frame.getContentPane().add(lblZona);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(345, 227, 70, 15);
		frame.getContentPane().add(lblCiudad);
		
		textField_8 = new JTextField();
		textField_8.setBounds(409, 223, 251, 19);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(12, 254, 70, 15);
		frame.getContentPane().add(lblCorreo);
		
		textField_9 = new JTextField();
		textField_9.setBounds(70, 252, 241, 19);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblCeltel = new JLabel("Cel/Tel:");
		lblCeltel.setBounds(335, 254, 58, 15);
		frame.getContentPane().add(lblCeltel);
		
		textField_10 = new JTextField();
		textField_10.setBounds(398, 252, 125, 19);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(535, 252, 125, 19);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
	}
}
