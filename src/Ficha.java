import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ficha extends JFrame {

	private JPanel contentPane;
	private JTextField nombres;
	private JTextField apellidos;
	private JTextField apellidop;
	private JTextField apellidom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha frame = new Ficha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ficha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setBounds(12, 12, 111, 15);
		contentPane.add(lblEstudiante);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(12, 39, 70, 15);
		contentPane.add(lblNewLabel);
		
		nombres = new JTextField();
		nombres.setBounds(88, 37, 550, 19);
		contentPane.add(nombres);
		nombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(662, 39, 70, 15);
		contentPane.add(lblApellidos);
		
		apellidos = new JTextField();
		
		apellidos.setBounds(738, 37, 550, 19);
		contentPane.add(apellidos);
		apellidos.setColumns(10);
		
		JLabel lblape = new JLabel("Apellido Paterno:");
		lblape.setBounds(12, 66, 123, 15);
		contentPane.add(lblape);
		
		apellidop = new JTextField();
		apellidop.setBounds(144, 64, 494, 19);
		contentPane.add(apellidop);
		apellidop.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(662, 66, 146, 15);
		contentPane.add(lblApellidoMaterno);
		
		apellidom = new JTextField();
		apellidom.setBounds(793, 64, 494, 19);
		contentPane.add(apellidom);
		apellidom.setColumns(10);
	}
}
