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
	private JTextField tfNombre;
	private JLabel lblApellidoPaterno;
	private JTextField tfApePat;
	private JLabel lblApellidoMaterno;
	private JTextField tfApeMat;
	private JLabel lblCarnet;
	private JTextField tfCI;
	private JLabel lblFechaNacimiento;
	private JTextField tfDireccion;
	private JLabel lblCelular;
	private JTextField tfCel;
	private JLabel lblContrasea;
	private JTextField tfPass;
	private JLabel lblTipo;
	private JComboBox cbTipo;
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
		
		tfNombre = new JTextField();
		tfNombre.setBounds(69, 10, 369, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(12, 39, 96, 15);
		frame.getContentPane().add(lblApellidoPaterno);
		
		tfApePat = new JTextField();
		tfApePat.setBounds(126, 37, 312, 19);
		frame.getContentPane().add(tfApePat);
		tfApePat.setColumns(10);
		
		lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(12, 66, 114, 15);
		frame.getContentPane().add(lblApellidoMaterno);
		
		tfApeMat = new JTextField();
		tfApeMat.setBounds(126, 64, 312, 19);
		frame.getContentPane().add(tfApeMat);
		tfApeMat.setColumns(10);
		
		lblCarnet = new JLabel("Carnet:");
		lblCarnet.setBounds(12, 93, 55, 15);
		frame.getContentPane().add(lblCarnet);
		
		tfCI = new JTextField();
		tfCI.setBounds(62, 91, 114, 19);
		frame.getContentPane().add(tfCI);
		tfCI.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(194, 93, 104, 15);
		frame.getContentPane().add(lblFechaNacimiento);
		
		JDateChooser FechaNac = new JDateChooser();
		FechaNac.setBounds(303, 93, 135, 19);
		frame.getContentPane().add(FechaNac);
		FechaNac.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(12, 122, 73, 15);
		frame.getContentPane().add(lblDireccion);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(82, 120, 356, 19);
		frame.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(12, 149, 55, 15);
		frame.getContentPane().add(lblCelular);
		
		tfCel = new JTextField();
		tfCel.setBounds(62, 147, 135, 19);
		frame.getContentPane().add(tfCel);
		tfCel.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(12, 176, 83, 15);
		frame.getContentPane().add(lblContrasea);
		
		tfPass = new JTextField();
		tfPass.setToolTipText("");
		tfPass.setBounds(96, 174, 342, 19);
		frame.getContentPane().add(tfPass);
		tfPass.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(215, 149, 38, 15);
		frame.getContentPane().add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setBounds(271, 144, 167, 24);
		frame.getContentPane().add(cbTipo);
		cbTipo.addItem("Admin");
		cbTipo.addItem("Empleado");
		cbTipo.addItem("Docente");
		
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
