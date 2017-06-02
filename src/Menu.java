import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\guto_\\Desktop\\logo_ucb_med.gif"));
		label.setBounds(51, 40, 299, 417);
		frame.getContentPane().add(label);
		
		JButton Btinsc = new JButton("Inscripciones");
		Btinsc.setBounds(547, 108, 134, 42);
		frame.getContentPane().add(Btinsc);
		
		JButton Btreport = new JButton("Reportes");
		Btreport.setBounds(547, 176, 134, 42);
		frame.getContentPane().add(Btreport);
		
		JButton Btrecibos = new JButton("Recibos");
		Btrecibos.setBounds(547, 241, 134, 42);
		frame.getContentPane().add(Btrecibos);
		
		JButton btsalir = new JButton("Salir");
		btsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//System.exit(0);
			}
		});
		btsalir.setBounds(547, 415, 134, 42);
		frame.getContentPane().add(btsalir);
	}

}
