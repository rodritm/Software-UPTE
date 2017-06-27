package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ficha {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;

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
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setBounds(300, 0, 670, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEstudiantes = new JLabel("Estudiante");
		lblEstudiantes.setBounds(12, 12, 94, 15);
		frame.getContentPane().add(lblEstudiantes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 32, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(76, 30, 584, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Materno:");
		lblApellidoPaterno.setBounds(12, 85, 139, 15);
		frame.getContentPane().add(lblApellidoPaterno);
		
		JButton btnAtras = new JButton("Cancelar");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showOptionDialog(null, "Esta segura/o?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, new Object[]{"SI","NO"},"SI");
				
				if(option == 0){
					Menu nuevo = new Menu();
					nuevo.main(null);
					frame.dispose();
				}
				
			}
		});
		btnAtras.setBounds(406, 696, 117, 25);
		frame.getContentPane().add(btnAtras);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 83, 519, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellido Paterno:");
		lblNewLabel.setBounds(12, 58, 139, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 56, 519, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCedulaDeIdentidad = new JLabel("Cedula de identidad:");
		lblCedulaDeIdentidad.setBounds(12, 112, 159, 15);
		frame.getContentPane().add(lblCedulaDeIdentidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 110, 251, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblExp = new JLabel("exp:");
		lblExp.setBounds(433, 112, 70, 15);
		frame.getContentPane().add(lblExp);
		
		JList list = new JList();
		list.setBounds(1155, 61, 1, 1);
		frame.getContentPane().add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 166, 217, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 144, 163, 15);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JDateChooser fechanc = new JDateChooser();
		fechanc.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		fechanc.setBounds(174, 141, 175, 19);
		frame.getContentPane().add(fechanc);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setBounds(330, 171, 85, 15);
		frame.getContentPane().add(lblEstadoCivil);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(476, 107, 184, 24);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 171, 70, 15);
		frame.getContentPane().add(lblGenero);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(76, 166, 217, 24);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(385, 144, 70, 15);
		frame.getContentPane().add(lblEdad);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(443, 142, 114, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(12, 198, 70, 15);
		frame.getContentPane().add(lblDireccin);
		
		textField_5 = new JTextField();
		textField_5.setBounds(86, 196, 418, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNo = new JLabel("No:");
		lblNo.setBounds(522, 198, 29, 15);
		frame.getContentPane().add(lblNo);
		
		textField_6 = new JTextField();
		textField_6.setBounds(556, 196, 104, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(60, 223, 251, 19);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setBounds(12, 225, 47, 15);
		frame.getContentPane().add(lblZona);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(345, 227, 70, 15);
		frame.getContentPane().add(lblCiudad);
		
		textField_8 = new JTextField();
		textField_8.setBounds(409, 223, 251, 19);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(12, 254, 70, 15);
		frame.getContentPane().add(lblCorreo);
		
		textField_9 = new JTextField();
		textField_9.setBounds(70, 252, 241, 19);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblCeltel = new JLabel("Cel/Tel:");
		lblCeltel.setBounds(335, 254, 58, 15);
		frame.getContentPane().add(lblCeltel);
		
		textField_10 = new JTextField();
		textField_10.setBounds(398, 252, 125, 19);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(535, 252, 125, 19);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblPersonaDeContacto = new JLabel("Persona de contacto");
		lblPersonaDeContacto.setBounds(12, 298, 152, 15);
		frame.getContentPane().add(lblPersonaDeContacto);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(12, 317, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_12 = new JTextField();
		textField_12.setBounds(76, 315, 584, 19);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido Paterno:");
		lblNewLabel_2.setBounds(12, 344, 139, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_13 = new JTextField();
		textField_13.setBounds(141, 342, 519, 19);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(12, 371, 139, 15);
		frame.getContentPane().add(lblApellidoMaterno);
		
		textField_14 = new JTextField();
		textField_14.setBounds(141, 369, 519, 19);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);
		
		JLabel label = new JLabel("Correo:");
		label.setBounds(12, 398, 70, 15);
		frame.getContentPane().add(label);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(70, 396, 241, 19);
		frame.getContentPane().add(textField_15);
		
		JLabel label_1 = new JLabel("Cel/Tel:");
		label_1.setBounds(335, 398, 58, 15);
		frame.getContentPane().add(label_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(398, 396, 125, 19);
		frame.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(535, 396, 125, 19);
		frame.getContentPane().add(textField_17);
		
		JLabel label_2 = new JLabel("Estudiante");
		label_2.setBounds(12, 440, 94, 15);
		frame.getContentPane().add(label_2);
		
		JLabel lblNivelDeInstruccin = new JLabel("Nivel de instrucción:");
		lblNivelDeInstruccin.setBounds(12, 460, 152, 15);
		frame.getContentPane().add(lblNivelDeInstruccin);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(164, 455, 147, 24);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblProfesin = new JLabel("Profesión:");
		lblProfesin.setBounds(330, 460, 73, 15);
		frame.getContentPane().add(lblProfesin);
		
		textField_18 = new JTextField();
		textField_18.setBounds(409, 458, 251, 19);
		frame.getContentPane().add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblOcupacinActual = new JLabel("Ocupación actual:");
		lblOcupacinActual.setBounds(12, 487, 152, 15);
		frame.getContentPane().add(lblOcupacinActual);
		
		textField_19 = new JTextField();
		textField_19.setBounds(152, 485, 508, 19);
		frame.getContentPane().add(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblActividadEnFin = new JLabel("Actividad en fin de semana:");
		lblActividadEnFin.setBounds(12, 514, 202, 15);
		frame.getContentPane().add(lblActividadEnFin);
		
		textField_20 = new JTextField();
		textField_20.setBounds(214, 512, 446, 19);
		frame.getContentPane().add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblPersonasConLas = new JLabel("Personas con las que vive:");
		lblPersonasConLas.setBounds(12, 541, 202, 15);
		frame.getContentPane().add(lblPersonasConLas);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(214, 537, 446, 19);
		frame.getContentPane().add(textField_21);
		
		JLabel lblTipoDeIngreso = new JLabel("Tipo de ingreso economico:");
		lblTipoDeIngreso.setBounds(12, 568, 202, 15);
		frame.getContentPane().add(lblTipoDeIngreso);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(214, 566, 446, 19);
		frame.getContentPane().add(textField_22);
		
		JLabel lblMedioPorEl = new JLabel("Medio por el cual se entero de la UPTE:");
		lblMedioPorEl.setBounds(12, 595, 281, 15);
		frame.getContentPane().add(lblMedioPorEl);
		
		textField_23 = new JTextField();
		textField_23.setBounds(295, 593, 365, 19);
		frame.getContentPane().add(textField_23);
		textField_23.setColumns(10);
		
		JLabel lblMotivoDelCurso = new JLabel("Motivo del curso:");
		lblMotivoDelCurso.setBounds(12, 622, 139, 15);
		frame.getContentPane().add(lblMotivoDelCurso);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(152, 620, 508, 19);
		frame.getContentPane().add(textField_24);
		
		JLabel lblProblemasDeSalud = new JLabel("Problemas de salud:");
		lblProblemasDeSalud.setBounds(12, 649, 159, 15);
		frame.getContentPane().add(lblProblemasDeSalud);
		
		textField_25 = new JTextField();
		textField_25.setBounds(164, 647, 496, 19);
		frame.getContentPane().add(textField_25);
		textField_25.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(535, 696, 117, 25);
		frame.getContentPane().add(btnOk);
	}
}
