import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Ficha {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		lblApellidoPaterno.setBounds(678, 32, 139, 15);
		frame.getContentPane().add(lblApellidoPaterno);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(1006, 672, 117, 25);
		frame.getContentPane().add(btnAtras);
		
		textField_1 = new JTextField();
		textField_1.setBounds(805, 30, 549, 19);
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
		lblCedulaDeIdentidad.setBounds(678, 58, 159, 15);
		frame.getContentPane().add(lblCedulaDeIdentidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(830, 56, 277, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblExp = new JLabel("exp:");
		lblExp.setBounds(1115, 58, 70, 15);
		frame.getContentPane().add(lblExp);
		
		JList list = new JList();
		list.setBounds(1155, 61, 1, 1);
		frame.getContentPane().add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1155, 53, 199, 24);
		frame.getContentPane().add(comboBox);
	}
}
