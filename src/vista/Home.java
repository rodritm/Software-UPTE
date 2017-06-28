package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home {

	private JFrame frame;
	private JTextField tfusuario;
	private JPasswordField tfpass;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private int restantes = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 440, 460);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inicio de sesion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setUndecorated(true);
		
		
		
		tfusuario = new JTextField();
		tfusuario.setBounds(165, 278, 110, 20);
		frame.getContentPane().add(tfusuario);
		tfusuario.setColumns(10);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(165, 334, 110, 20);
		frame.getContentPane().add(tfpass);
		
		JLabel lblUsuario = new JLabel("Usuario ");
		lblUsuario.setBounds(165, 252, 110, 14);
		lblUsuario.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Password");
		lblContrasea.setBounds(165, 309, 110, 14);
		lblContrasea.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(lblContrasea);
		
		JButton btnComprobar = new JButton("Ingresar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char clave[]=tfpass.getPassword();
				String clavedef=new String(clave);
				
				if(tfusuario.getText().equals("Augusto") && clavedef.equals("123") ||
						tfusuario.getText().equals("prime") && clavedef.equals("123")){
					JOptionPane.showMessageDialog(null, "Bienvenido\n"
		                    + "Has ingresado satisfactoriamente al sistema.\nBienvenido: "+tfusuario.getText());
					Menu nuevo = new Menu();
					nuevo.main(null);
					frame.dispose();
				}else{
					if(restantes>1){
						restantes--;
						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
			                    + "Por favor ingrese un usuario y/o contraseña correctos \nIntentos Disponibles: "+restantes, "Acceso denegado",
			                    JOptionPane.ERROR_MESSAGE);
						tfpass.setText("");
						tfusuario.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
			                    + "Exceso de ingresos permitidos", "Acceso denegado",
			                    JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			}
		});
		btnComprobar.setBounds(165, 386, 110, 23);
		frame.getContentPane().add(btnComprobar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(165, 420, 110, 23);
		frame.getContentPane().add(btnSalir);
		lblNewLabel = new JLabel("");
		
		ImageIcon icon = new ImageIcon("images/logopeque.jpg");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(130, 10, 180, 220);
		frame.getContentPane().add(lblNewLabel);
	}
}
