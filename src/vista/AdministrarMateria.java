package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarMateria {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNombre;
	private JTextField textField_1;
	private JLabel lblParalelo;
	private JTextField textField_2;
	private JLabel lblDocente;
	private JComboBox comboBox;
	private JLabel lblHora;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label;
	private JLabel lblAula;
	private JTextField textField_5;
	private JButton btnCancelar;
	private JButton btnOk;

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
		frame.setBounds(100, 100, 450, 167);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSiglaDeLa = new JLabel("Sigla de la materia:");
		lblSiglaDeLa.setBounds(12, 12, 108, 15);
		frame.getContentPane().add(lblSiglaDeLa);
		
		textField = new JTextField();
		textField.setBounds(128, 10, 63, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 39, 55, 15);
		frame.getContentPane().add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 37, 367, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblParalelo = new JLabel("Paralelo:");
		lblParalelo.setBounds(12, 66, 55, 15);
		frame.getContentPane().add(lblParalelo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(71, 62, 55, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblDocente = new JLabel("Docente:");
		lblDocente.setBounds(12, 93, 55, 15);
		frame.getContentPane().add(lblDocente);
		
		comboBox = new JComboBox();
		comboBox.setBounds(71, 88, 367, 24);
		frame.getContentPane().add(comboBox);
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(150, 64, 55, 15);
		frame.getContentPane().add(lblHora);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 62, 35, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(238, 62, 35, 19);
		frame.getContentPane().add(textField_4);
		
		label = new JLabel(":");
		label.setBounds(228, 62, 20, 15);
		frame.getContentPane().add(label);
		
		lblAula = new JLabel("Aula:");
		lblAula.setBounds(305, 64, 55, 15);
		frame.getContentPane().add(lblAula);
		
		textField_5 = new JTextField();
		textField_5.setBounds(341, 62, 97, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
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
		btnCancelar.setBounds(228, 124, 98, 25);
		frame.getContentPane().add(btnCancelar);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(340, 124, 98, 25);
		frame.getContentPane().add(btnOk);
	}

}
