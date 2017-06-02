import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;
	private JTextField tfusuario;
	private JPasswordField tfpass;
	private JButton btnSalir;

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
		frame.setBounds(0, 0, 439, 465);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inicio de sesion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		tfusuario = new JTextField();
		tfusuario.setBounds(147, 216, 110, 20);
		frame.getContentPane().add(tfusuario);
		tfusuario.setColumns(10);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(147, 272, 110, 20);
		frame.getContentPane().add(tfpass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(171, 190, 51, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(157, 247, 65, 14);
		frame.getContentPane().add(lblContrasea);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(147, 324, 110, 23);
		frame.getContentPane().add(btnComprobar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(147, 358, 110, 23);
		frame.getContentPane().add(btnSalir);
	}
}
