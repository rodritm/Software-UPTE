package vista;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controlador.Empleados;
import controlador.Login;
import modelo.Querry;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home extends JFrame{

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
		frame.setBounds(0, 0, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inicio de sesion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setUndecorated(true);
		
		
		
		tfusuario = new JTextField();
		tfusuario.setBounds(296, 236, 180, 32);
		frame.getContentPane().add(tfusuario);
		tfusuario.setColumns(10);
		tfusuario.setBorder(null);
		//((JComponent) tfusuario.getContentPane()).setOpaque(false);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(296, 285, 180, 32);
		frame.getContentPane().add(tfpass);
		tfpass.setBorder(null);
		
		tfpass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	char clave[]=tfpass.getPassword();
				String clavedef=new String(clave);
				String user = tfusuario.getText().toString();
				Empleados emp = new Empleados(user, clavedef);
				Login log = new Login();
				if (log.login(emp, restantes)){
					Menu nuevo = new Menu();
					nuevo.main(null);
					frame.dispose();
				}else{
					restantes--;
					tfpass.setText("");
					tfusuario.setText("");
					tfusuario.requestFocusInWindow();
				}
			}
            });
				
		JButton btnComprobar = new JButton("");
		URL url = Home.class.getResource("/login/1.png");
		ImageIcon icon = new ImageIcon(url);
		btnComprobar.setIcon(icon);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
            	char clave[]=tfpass.getPassword();
				String clavedef=new String(clave);
				String user = tfusuario.getText().toString();
				Empleados emp = new Empleados(user,clavedef);
				Login log = new Login();
				if (log.login(emp, restantes)){
					Menu nuevo = new Menu();
					nuevo.main(null);
					Querry q = new Querry();
					try {
						q.Prueba(user);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					frame.dispose();					
				}else{
					restantes--;
					tfpass.setText("");
					tfusuario.setText("");
				}
			}
            });

		btnComprobar.setBounds(284, 351, 128, 38);
		frame.getContentPane().add(btnComprobar);
		btnComprobar.setBorder(null);
		
		btnSalir = new JButton("");
		URL url2 = Home.class.getResource("/login/2.png");
		ImageIcon icon2 = new ImageIcon(url2);
		btnSalir.setIcon(icon2);
		btnSalir.setBorder(null);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(432, 351, 89, 38);
		frame.getContentPane().add(btnSalir);
		
		lblNewLabel = new JLabel("");
		((JPanel)getContentPane()).setOpaque(false); 
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/login/fondo.png")); 
		lblNewLabel.setIcon(uno); 
		getLayeredPane().add(lblNewLabel,JLayeredPane.FRAME_CONTENT_LAYER); 
		lblNewLabel.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		
		/*URL url = Home.class.getResource("/logopeque.jpg");
		ImageIcon icon = new ImageIcon(url);
		lblNewLabel.setIcon(icon);*/
		//lblNewLabel.setBounds(130, 10, 180, 220);
		frame.getContentPane().add(lblNewLabel);
	}
}
