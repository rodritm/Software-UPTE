package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mxrck.autocompleter.TextAutoCompleter;

import controlador.Ruta;
import modelo.Querry;

public class Anular {

	private JFrame frame;
	private JTextField tfRuta;
	private JTextField tfNumero;
	private JTextField tfGestion;
	private JTextField tfCurso;
	private JTextField tfParalelo;
	private JTextField tfMonto;
	private String Ruta = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anular window = new Anular();
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
	public Anular() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 421, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		tfRuta = new JTextField();
		tfRuta.setBounds(22, 184, 255, 19);
		frame.getContentPane().add(tfRuta);
		tfRuta.setEditable(false);
		tfRuta.setColumns(10);
		
		JButton btnCarpeta = new JButton("CARPETA");
		btnCarpeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ruta dic = new Ruta();
				Ruta=dic.funcion();
				tfRuta.setText(Ruta);
			}
		});
		btnCarpeta.setBounds(302, 181, 98, 25);
		frame.getContentPane().add(btnCarpeta);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(302, 218, 98, 25);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				String ruta = Ruta;
				if (!ruta.equals("")){
					String id = tfNumero.getText().toString();
					Querry q = new Querry();
					try {
						q.Anular(id);
					} catch (SQLException e1) {
				
						e1.printStackTrace();
					}
				}else{
					  JOptionPane.showMessageDialog(null,"NO HAY DIRECCIÓN","",JOptionPane.ERROR_MESSAGE);

=======
				String id = tfNumero.getText().toString();
				Querry q = new Querry();
				try {
					q.Anular(id);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
>>>>>>> refs/remotes/origin/master
				}
			}
		});
		
		JLabel lblGestion = new JLabel("GESTION:");
		lblGestion.setBounds(80, 75, 55, 15);
		frame.getContentPane().add(lblGestion);
		
		JLabel lblCurso = new JLabel("CURSO:");
		lblCurso.setBounds(80, 102, 55, 15);
		frame.getContentPane().add(lblCurso);
		
		JLabel lblParalelo = new JLabel("PARALELO: ");
		lblParalelo.setBounds(81, 129, 78, 15);
		frame.getContentPane().add(lblParalelo);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nuevo1 = new Menu();
				nuevo1.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(22, 218, 98, 25);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setBounds(80, 46, 55, 15);
		frame.getContentPane().add(lblNumero);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(149, 44, 128, 19);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);
		TextAutoCompleter auto = new TextAutoCompleter(tfNumero);
		Querry q = new Querry();
		ResultSet rs;
		String ids;
		try{
			rs = q.AutoReciboid();
			while(rs.next()) {
				ids = (rs.getString("idrecibo"));
				auto.addItem(ids);
			}
		}catch(Exception e) {}
		
		tfGestion = new JTextField();
		tfGestion.setColumns(10);
		tfGestion.setBounds(149, 73, 251, 19);
		tfGestion.setEditable(false);
		frame.getContentPane().add(tfGestion);
		
		tfCurso = new JTextField();
		tfCurso.setColumns(10);
		tfCurso.setBounds(149, 100, 251, 19);
		tfCurso.setEditable(false);
		frame.getContentPane().add(tfCurso);
		
		tfParalelo = new JTextField();
		tfParalelo.setColumns(10);
		tfParalelo.setBounds(170, 127, 65, 19);
		tfParalelo.setEditable(false);
		frame.getContentPane().add(tfParalelo);
		
		JLabel lblMonto = new JLabel("MONTO:     bs.");
		lblMonto.setBounds(80, 157, 79, 15);
		frame.getContentPane().add(lblMonto);
		
		tfMonto = new JTextField();
		tfMonto.setEditable(false);
		tfMonto.setColumns(10);
		tfMonto.setBounds(170, 153, 65, 19);
		frame.getContentPane().add(tfMonto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfNumero.getText().toString();
				Querry q = new Querry();
				try {
					ResultSet rs = q.AutoCompl(id);
					String gestion, paralelo, curso, monto;
					while(rs.next()) {
						tfCurso.setText(rs.getString("nombres"));
						tfGestion.setText(rs.getString("gestion"));
						tfParalelo.setText(rs.getString("paralelo"));
						tfMonto.setText(rs.getString("monto"));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(311, 42, 89, 23);
		frame.getContentPane().add(btnBuscar);
	}

}
