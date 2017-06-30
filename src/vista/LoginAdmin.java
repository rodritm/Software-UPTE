package vista;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Empleados;
import controlador.Login;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginAdmin {

	private JFrame frmAcceder;
	private JTextField tfUsuario;
	private JPasswordField tfpass;
	private int restantes = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
					window.frmAcceder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAdmin() {
		initialize();
	}

	private void initialize() {
		frmAcceder = new JFrame();
		frmAcceder.setTitle("ACCEDER");
		frmAcceder.setBounds(100, 100, 291, 156);
		frmAcceder.setLocationRelativeTo(null);
		frmAcceder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAcceder.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 80, 14);
		frmAcceder.getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(100, 8, 137, 20);
		frmAcceder.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(10, 51, 80, 14);
		frmAcceder.getContentPane().add(lblContrasea);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(100, 48, 137, 20);
		frmAcceder.getContentPane().add(tfpass);
		tfpass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	char clave[]=tfpass.getPassword();
				String clavedef=new String(clave);
				String user = tfUsuario.getText().toString();
				Empleados emp = new Empleados(user, clavedef);
				Login log = new Login();
				if (log.loginAdmin(emp, restantes)){
					Administrar nuevo = new Administrar();
					nuevo.main(null);
					frmAcceder.dispose();
				}else{
					restantes--;
					tfpass.setText("");
					tfUsuario.setText("");
					tfUsuario.requestFocusInWindow();
				}
			}
            });
		
		JButton btLog = new JButton("Ingresar");
		btLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char clave[]=tfpass.getPassword();
				String clavedef=new String(clave);
				String user = tfUsuario.getText().toString();
				Empleados emp = new Empleados(user,clavedef);
				Login log = new Login();
				if (log.loginAdmin(emp, restantes)){
					Administrar nuevo = new Administrar();
					nuevo.main(null);
					frmAcceder.dispose();					
				}else{
					restantes--;
					tfpass.setText("");
					tfUsuario.setText("");
				}
			}
		});
		btLog.setBounds(85, 83, 89, 23);
		frmAcceder.getContentPane().add(btLog);
	}
}
