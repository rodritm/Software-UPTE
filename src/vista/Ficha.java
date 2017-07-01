package vista;

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

import controlador.Estudiante;
import modelo.Querry;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Ficha {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApeMat;
	private JTextField tfApePat;
	private JTextField tfCI;
	private JTextField tfEdad;
	private JTextField tfDireccion;
	private JTextField tfNumero;
	private JTextField tfZona;
	private JTextField tfCiudad;
	private JTextField tfCorreo;
	private JTextField tfCel;
	private JTextField tfTel;
	private JTextField tfPerContactoNombre;
	private JTextField tfPerContactoApePat;
	private JTextField tfPerContactoApeMat;
	private JTextField tfPerContactoCorreo;
	private JTextField tfPerContactoCel;
	private JTextField tfPerContactoTel;
	private JTextField tfProfesion;
	private JTextField tfOcupacion;
	private JTextField tfActividad;
	private JTextField tfPersonaVive;
	private JTextField tfTipoIngreso;
	private JTextField tfMedio;
	private JTextField tfProblemas;
	private int edad;

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
		frame.setBounds(100, 100, 670, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JLabel lblEstudiantes = new JLabel("Estudiante");
		lblEstudiantes.setBounds(12, 12, 94, 15);
		frame.getContentPane().add(lblEstudiantes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 32, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(76, 30, 584, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
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
		btnAtras.setBounds(406, 632, 117, 25);
		frame.getContentPane().add(btnAtras);
		
		tfApeMat = new JTextField();
		tfApeMat.setBounds(141, 83, 519, 19);
		frame.getContentPane().add(tfApeMat);
		tfApeMat.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellido Paterno:");
		lblNewLabel.setBounds(12, 58, 139, 15);
		frame.getContentPane().add(lblNewLabel);
		
		tfApePat = new JTextField();
		tfApePat.setBounds(141, 56, 519, 19);
		frame.getContentPane().add(tfApePat);
		tfApePat.setColumns(10);
		
		JLabel lblCedulaDeIdentidad = new JLabel("Cedula de identidad:");
		lblCedulaDeIdentidad.setBounds(12, 112, 159, 15);
		frame.getContentPane().add(lblCedulaDeIdentidad);
		
		tfCI = new JTextField();
		tfCI.setBounds(164, 110, 251, 19);
		frame.getContentPane().add(tfCI);
		tfCI.setColumns(10);
		
		
		JLabel lblExp = new JLabel("exp:");
		lblExp.setBounds(433, 112, 70, 15);
		frame.getContentPane().add(lblExp);
		
		JList list = new JList();
		list.setBounds(1155, 61, 1, 1);
		frame.getContentPane().add(list);
		
		JComboBox cbEstado_civil = new JComboBox();
		cbEstado_civil.setBounds(443, 166, 217, 24);
		frame.getContentPane().add(cbEstado_civil);
		cbEstado_civil.addItem("Casado/a");
		cbEstado_civil.addItem("Viudo/a");
		cbEstado_civil.addItem("Soltero/a");
		cbEstado_civil.addItem("Divorciado/a");
		cbEstado_civil.addItem("Otro");
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 144, 163, 15);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JDateChooser fechanc = new JDateChooser();
		fechanc.setDateFormatString("yyyy-MM-dd");
		fechanc.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						String fecha = ((JTextField) fechanc.getDateEditor().getUiComponent()).getText();
						if(!fecha.isEmpty()) {
							DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate fechaNac = LocalDate.parse(fecha, fmt);
							LocalDate ahora = LocalDate.now();
							Period periodo = Period.between(fechaNac, ahora);
							edad = periodo.getYears();
							tfEdad.setText(edad+"");
						}
					}
				});
		fechanc.setBounds(174, 141, 175, 19);
		frame.getContentPane().add(fechanc);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setBounds(330, 171, 85, 15);
		frame.getContentPane().add(lblEstadoCivil);
		
		JComboBox cbExp = new JComboBox();
		cbExp.setBounds(476, 107, 184, 24);
		frame.getContentPane().add(cbExp);
		cbExp.addItem("LP");
		cbExp.addItem("OR");
		cbExp.addItem("PT");
		cbExp.addItem("CB");
		cbExp.addItem("SC");
		cbExp.addItem("BN");
		cbExp.addItem("PA");
		cbExp.addItem("TJ");
		cbExp.addItem("CH");
		cbExp.addItem("EX");
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 171, 70, 15);
		frame.getContentPane().add(lblGenero);
		
		JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(76, 166, 217, 24);
		frame.getContentPane().add(cbGenero);
		cbGenero.addItem("Masculino");
		cbGenero.addItem("Femenino");
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(385, 144, 70, 15);
		frame.getContentPane().add(lblEdad);
		
		tfEdad = new JTextField();
		tfEdad.setEditable(false);
		tfEdad.setBounds(443, 142, 114, 19);
		frame.getContentPane().add(tfEdad);
		tfEdad.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(12, 198, 70, 15);
		frame.getContentPane().add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(86, 196, 418, 19);
		frame.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNo = new JLabel("No:");
		lblNo.setBounds(522, 198, 29, 15);
		frame.getContentPane().add(lblNo);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(556, 196, 104, 19);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);
		
		tfZona = new JTextField();
		tfZona.setBounds(60, 223, 251, 19);
		frame.getContentPane().add(tfZona);
		tfZona.setColumns(10);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setBounds(12, 225, 47, 15);
		frame.getContentPane().add(lblZona);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(345, 227, 70, 15);
		frame.getContentPane().add(lblCiudad);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(409, 223, 251, 19);
		frame.getContentPane().add(tfCiudad);
		tfCiudad.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(12, 254, 70, 15);
		frame.getContentPane().add(lblCorreo);
		
		tfCorreo = new JTextField();
		tfCorreo.setBounds(70, 252, 241, 19);
		frame.getContentPane().add(tfCorreo);
		tfCorreo.setColumns(10);
		
		JLabel lblCeltel = new JLabel("Cel/Tel:");
		lblCeltel.setBounds(335, 254, 58, 15);
		frame.getContentPane().add(lblCeltel);
		
		tfCel = new JTextField();
		tfCel.setBounds(398, 252, 125, 19);
		frame.getContentPane().add(tfCel);
		tfCel.setColumns(10);
		
		tfTel = new JTextField();
		tfTel.setBounds(535, 252, 125, 19);
		frame.getContentPane().add(tfTel);
		tfTel.setColumns(10);
		
		JLabel lblPersonaDeContacto = new JLabel("Persona de contacto");
		lblPersonaDeContacto.setBounds(12, 489, 152, 15);
		frame.getContentPane().add(lblPersonaDeContacto);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(12, 510, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfPerContactoNombre = new JTextField();
		tfPerContactoNombre.setBounds(76, 508, 584, 19);
		frame.getContentPane().add(tfPerContactoNombre);
		tfPerContactoNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido Paterno:");
		lblNewLabel_2.setBounds(12, 537, 139, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfPerContactoApePat = new JTextField();
		tfPerContactoApePat.setBounds(141, 535, 519, 19);
		frame.getContentPane().add(tfPerContactoApePat);
		tfPerContactoApePat.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(12, 564, 139, 15);
		frame.getContentPane().add(lblApellidoMaterno);
		
		tfPerContactoApeMat = new JTextField();
		tfPerContactoApeMat.setBounds(141, 562, 519, 19);
		frame.getContentPane().add(tfPerContactoApeMat);
		tfPerContactoApeMat.setColumns(10);
		
		JLabel label = new JLabel("Correo:");
		label.setBounds(12, 591, 70, 15);
		frame.getContentPane().add(label);
		
		tfPerContactoCorreo = new JTextField();
		tfPerContactoCorreo.setColumns(10);
		tfPerContactoCorreo.setBounds(76, 589, 241, 19);
		frame.getContentPane().add(tfPerContactoCorreo);
		
		JLabel label_1 = new JLabel("Cel/Tel:");
		label_1.setBounds(335, 591, 58, 15);
		frame.getContentPane().add(label_1);
		
		tfPerContactoCel = new JTextField();
		tfPerContactoCel.setColumns(10);
		tfPerContactoCel.setBounds(385, 589, 125, 19);
		frame.getContentPane().add(tfPerContactoCel);
		
		tfPerContactoTel = new JTextField();
		tfPerContactoTel.setColumns(10);
		tfPerContactoTel.setBounds(535, 589, 125, 19);
		frame.getContentPane().add(tfPerContactoTel);
		
		JLabel lblNivelDeInstruccin = new JLabel("Nivel de instrucción:");
		lblNivelDeInstruccin.setBounds(12, 281, 152, 15);
		frame.getContentPane().add(lblNivelDeInstruccin);
		
		JComboBox cbInstruccion = new JComboBox();
		cbInstruccion.setBounds(164, 276, 147, 24);
		frame.getContentPane().add(cbInstruccion);
		cbInstruccion.addItem("Primaria");
		cbInstruccion.addItem("Secundaria");
		cbInstruccion.addItem("Pregrado");
		cbInstruccion.addItem("Postgrado");
		cbInstruccion.addItem("Tecnico");
		cbInstruccion.addItem("Nada");
		cbInstruccion.addItem("Otro");
		
		JLabel lblProfesin = new JLabel("Profesión:");
		lblProfesin.setBounds(330, 281, 73, 15);
		frame.getContentPane().add(lblProfesin);
		
		tfProfesion = new JTextField();
		tfProfesion.setBounds(396, 279, 264, 19);
		frame.getContentPane().add(tfProfesion);
		tfProfesion.setColumns(10);
		
		JLabel lblOcupacinActual = new JLabel("Ocupación actual:");
		lblOcupacinActual.setBounds(12, 308, 152, 15);
		frame.getContentPane().add(lblOcupacinActual);
		
		tfOcupacion = new JTextField();
		tfOcupacion.setBounds(152, 306, 508, 19);
		frame.getContentPane().add(tfOcupacion);
		tfOcupacion.setColumns(10);
		
		JLabel lblActividadEnFin = new JLabel("Actividad en fin de semana:");
		lblActividadEnFin.setBounds(12, 335, 202, 15);
		frame.getContentPane().add(lblActividadEnFin);
		
		tfActividad = new JTextField();
		tfActividad.setBounds(188, 333, 472, 19);
		frame.getContentPane().add(tfActividad);
		tfActividad.setColumns(10);
		
		JLabel lblPersonasConLas = new JLabel("Personas con las que vive:");
		lblPersonasConLas.setBounds(12, 362, 202, 15);
		frame.getContentPane().add(lblPersonasConLas);
		
		tfPersonaVive = new JTextField();
		tfPersonaVive.setColumns(10);
		tfPersonaVive.setBounds(188, 360, 472, 19);
		frame.getContentPane().add(tfPersonaVive);
		
		JLabel lblTipoDeIngreso = new JLabel("Tipo de ingreso economico:");
		lblTipoDeIngreso.setBounds(12, 389, 202, 15);
		frame.getContentPane().add(lblTipoDeIngreso);
		
		tfTipoIngreso = new JTextField();
		tfTipoIngreso.setColumns(10);
		tfTipoIngreso.setBounds(188, 387, 472, 19);
		frame.getContentPane().add(tfTipoIngreso);
		
		JLabel lblMedioPorEl = new JLabel("Medio por el cual se entero de la UPTE:");
		lblMedioPorEl.setBounds(12, 416, 281, 15);
		frame.getContentPane().add(lblMedioPorEl);
		
		tfMedio = new JTextField();
		tfMedio.setBounds(262, 414, 398, 19);
		frame.getContentPane().add(tfMedio);
		tfMedio.setColumns(10);
		
		JLabel lblProblemasDeSalud = new JLabel("Problemas de salud:");
		lblProblemasDeSalud.setBounds(12, 444, 159, 15);
		frame.getContentPane().add(lblProblemasDeSalud);
		
		tfProblemas = new JTextField();
		tfProblemas.setBounds(164, 443, 496, 19);
		frame.getContentPane().add(tfProblemas);
		tfProblemas.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int option = JOptionPane.showOptionDialog(null, "Esta segura/o?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, new Object[]{"SI","NO"},"SI");
						
						if(option== 0){
							String nombre, apePat, apeMat, ci, exp, fecha, genero, estado, dir, zona, ciudad, correo,
							instruccion, profesion, ocupacion, actividad, personas, ingreso, medio, problemas, percontactnombre,
							percontactapep, percontactcorreo, percontactapem, percontactcel, percontacttel;
							String edad, cel, tel;
							nombre = tfNombre.getText().toString();
							apePat = tfApePat.getText().toString();
							apeMat = tfApeMat.getText().toString();
							ci = tfCI.getText().toString();
							exp = (String) cbExp.getSelectedItem();
							fecha = ((JTextField) fechanc.getDateEditor().getUiComponent()).getText();
							edad = tfEdad.getText().toString();
							genero = (String) cbGenero.getSelectedItem();
							estado = (String) cbEstado_civil.getSelectedItem();
							dir = tfDireccion.getText().toString();
							zona = tfZona.getText().toString();
							ciudad = tfCiudad.getText().toString();
							correo  = tfCorreo.getText().toString();
							instruccion = (String) cbInstruccion.getSelectedItem();
							profesion = tfProfesion.getText().toString();
							ocupacion = tfOcupacion.getText().toString();
							actividad = tfActividad.getText().toString();
							personas = tfPersonaVive.getText().toString();
							ingreso = tfTipoIngreso.getText().toString();
							medio = tfMedio.getText().toString();
							problemas = tfProblemas.getText().toString();
							percontactnombre = tfPerContactoNombre.getText().toString();
							percontactapep = tfPerContactoApePat.getText().toString();
							percontactapem = tfPerContactoApeMat.getText().toString();
							percontactcorreo = tfPerContactoCorreo.getText().toString();
							percontactcel = tfPerContactoCel.getText().toString();
							percontacttel = tfPerContactoTel.getText().toString();
							cel = tfCel.getText().toString();
							tel = tfTel.getText().toString();
							Querry q = new Querry();
							try {
								q.Registrar(ci, exp, nombre, apePat, apeMat, genero, edad, estado, fecha, dir, zona, ciudad, correo, cel, tel, percontactnombre, percontacttel, instruccion, profesion, ocupacion, actividad, personas, ingreso, medio, problemas, percontactcel, percontactapep, percontactapem, percontactcorreo);
								JOptionPane.showMessageDialog(null, "Persona inscrita correctamente.", "Creado", JOptionPane.INFORMATION_MESSAGE);
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							Menu nuevo = new Menu();
							nuevo.main(null);
							frame.dispose();
						}
				
			}
		});
		btnOk.setBounds(543, 632, 117, 25);
		frame.getContentPane().add(btnOk);
	}
}
