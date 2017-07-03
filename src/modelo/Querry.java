package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import controlador.Fecha;

public class Querry {
	
	private static Puerto p = new Puerto();
	private static String puerto=p.puerto();
	//						LOGIN
	
	
	public ResultSet Log(String user,String pass) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select a.idempleados, a.password,a.nombres,b.idTipo_empleado from empleados a, tipo_empleado b where idempleados = '"+user+"' and password = '"+pass+"' and a.Tipo_empleado_idTipo_empleado=b.idTipo_empleado";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//						AUTOCOMPLETAR
	
	
	public ResultSet auto() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select idempleados from empleados";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet ci() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select idestudiante from estudiante";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet AutoReciboid() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select idrecibo from recibo where anulado = 1";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet Gestiones() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT DISTINCT gestion FROM materia_has_docente";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet Paralelos(String curso) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT DISTINCT paralelo FROM materia WHERE nombres='"+curso+"'";                               
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet Cursos() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT DISTINCT nombres FROM materia";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet Docentes() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT DISTINCT nombres FROM docente";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//							ANULAR
	
	public ResultSet AutoCompl(String id) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.monto, d.nombres ,c.gestion, d.paralelo  FROM recibo a, inscripcion b, materia_has_docente c, materia d"
				+ " WHERE a.inscripcion_idinscripcion=b.idinscripcion AND b.materia_has_docente_materia_idmateria=c.materia_idmateria"
				+ " AND b.materia_has_docente_docente_iddocente=c.docente_iddocente AND c.materia_idmateria=d.idmateria"
				+ " AND a.idrecibo='"+id+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public void Anular(String id) throws ClassNotFoundException{
		try{
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "UPDATE recibo SET anulado=1 WHERE idrecibo = ? ";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.executeUpdate();
			
			pre.execute("SET FOREIGN_KEY_CHECKS=0");
			sql = "DELETE FROM inscripcion WHERE idinscripcion =?";
			pre.setString(1, id);
			pre.executeUpdate();
			pre.execute("SET FOREIGN_KEY_CHECKS=1");
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//							REGISTRAR
	
	
	public void Registrar(String id, String exp, String nombres, String ape_paterno, String ape_materno,String genero, String edad,
			String estado_civil, String fechanc, String direccion, String zona, String ciudad, String email, String celular, 
			String telefono, String per_contact, String per_tel, String instruccion, String profesion, String ocupacion, String actividad, 
			String per_vive, String ingreso, String info_upte, String problemas, String per_cel, String per_ape_pat, 
			String per_ape_mat, String per_correo) throws ClassNotFoundException{
		try {
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO estudiante(idestudiante, exp, nombres, apellido_paterno, apellido_materno, genero, Edad, estado_civil, fechanc, "
					+ "direccion, zona, Ciudad, email, celular, telefono, per_contact, per_tel, instruccion, profesion, ocupacion, actividad, per_vive, "
					+ "ingreso, info_upte, problemas, per_cel, per_ape_pat, per_ape_mat, per_correo) VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, exp);
			pre.setString(3, nombres);
			pre.setString(4, ape_paterno);
			pre.setString(5, ape_materno);
			pre.setString(6, genero);
			pre.setString(7, edad);
			pre.setString(8, estado_civil);
			pre.setString(9, fechanc);
			pre.setString(10, direccion);
			pre.setString(11, zona);
			pre.setString(12, ciudad);
			pre.setString(13, email);
			pre.setString(14, celular);
			pre.setString(15, telefono);
			pre.setString(16, per_contact);
			pre.setString(17, per_tel);
			pre.setString(18, instruccion);
			pre.setString(19, profesion);
			pre.setString(20, ocupacion);
			pre.setString(21, actividad);
			pre.setString(22, per_vive);
			pre.setString(23, ingreso);
			pre.setString(24, info_upte);
			pre.setString(25, problemas);
			pre.setString(26, per_cel);
			pre.setString(27, per_ape_pat);
			pre.setString(28, per_ape_mat);
			pre.setString(29, per_correo);
			
			
			pre.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear la materia","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//							INSCRIBIR
	
	public ResultSet AutoIns(String id) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT * from estudiante WHERE idestudiante ='"+id+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	public void Update(String id, String exp, String nombres, String ape_paterno, String ape_materno,String genero, String edad,
			String estado_civil, String fechanc, String direccion, String zona, String ciudad, String email, String celular, 
			String telefono, String per_contact, String per_tel, String instruccion, String profesion, String ocupacion, String actividad, 
			String per_vive, String ingreso, String info_upte, String problemas, String per_cel, String per_ape_pat, 
			String per_ape_mat, String per_correo) throws ClassNotFoundException{
		try {
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "UPDATE estudiante SET idestudiante = ? ,exp = ?,nombres = ?,apellido_paterno = ?,apellido_materno = ?,genero = ?,"
					+ " Edad = ?,estado_civil = ?,fechanc = ?, direccion = ?, zona = ?, Ciudad = ?, email = ?, celular = ?, telefono = ?, "
					+ "per_contact = ?, per_tel = ?, instruccion = ?, profesion = ?, ocupacion = ?, actividad = ?, per_vive = ?, ingreso = ?, "
					+ "info_upte = ?, problemas = ?, per_cel = ?, per_ape_pat = ?, per_ape_mat = ?, per_correo = ? WHERE idestudiante = ?";
		
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, exp);
			pre.setString(3, nombres);
			pre.setString(4, ape_paterno);
			pre.setString(5, ape_materno);
			pre.setString(6, genero);
			pre.setString(7, edad);
			pre.setString(8, estado_civil);
			pre.setString(9, fechanc);
			pre.setString(10, direccion);
			pre.setString(11, zona);
			pre.setString(12, ciudad);
			pre.setString(13, email);
			pre.setString(14, celular);
			pre.setString(15, telefono);
			pre.setString(16, per_contact);
			pre.setString(17, per_tel);
			pre.setString(18, instruccion);
			pre.setString(19, profesion);
			pre.setString(20, ocupacion);
			pre.setString(21, actividad);
			pre.setString(22, per_vive);
			pre.setString(23, ingreso);
			pre.setString(24, info_upte);
			pre.setString(25, problemas);
			pre.setString(26, per_cel);
			pre.setString(27, per_ape_pat);
			pre.setString(28, per_ape_mat);
			pre.setString(29, per_correo);
			pre.setString(30, id);
			
			pre.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cambiar datos del estudiante", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void Inscribir(String id, String materia, String paralelo, String nit) throws ClassNotFoundException{
		try {	
			//JOptionPane.showMessageDialog(null, "Nit llego a inscribir querry: "+nit);
			Float monto = null;
			DB_Connect con1 = new DB_Connect();
			Connection conn=con1.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "select monto from materia where nombres = '"+materia+"'";
			rs = st.executeQuery(querry);
			while(rs.next()) {
				monto = Float.parseFloat(rs.getString("monto"));
			}
			con1.closecon();
			
			String idMateria = "";
			String idDocente = "";
			DB_Connect con2 = new DB_Connect();
			conn=con2.conexion();
			st = (Statement)conn.createStatement();
			querry = "SELECT b.idmateria, a.docente_iddocente FROM materia_has_docente a, materia b WHERE b.nombres = '"+materia+"'";
			rs = st.executeQuery(querry);
			while(rs.next()) {
				idMateria = rs.getString("idmateria");
				idDocente = rs.getString("docente_iddocente");
			}
			con2.closecon();
			
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO inscripcion(empleados_idempleados, estudiante_idestudiante, materia_has_docente_materia_idmateria, materia_has_docente_docente_iddocente, materia, paralelo) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, "9896776");
			pre.setString(2, id);
			pre.setString(3, idMateria);
			pre.setString(4, idDocente);
			pre.setString(5, materia);
			pre.setString(6, paralelo);
			
			pre.executeUpdate();
			
			ReciboAdd(monto,nit);
			
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Alumnos no inscrito","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void ReciboAdd(Float monto, String nit) throws ClassNotFoundException{
		try {
			//JOptionPane.showMessageDialog(null, "Nit para el recibo: "+nit);
			String id = "";
			DB_Connect con1 = new DB_Connect();
			Connection conn=con1.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "select idinscripcion from inscripcion order by idinscripcion desc limit 1";
			rs = st.executeQuery(querry);
			while(rs.next()) {
				id = rs.getString("idinscripcion");
			}
			con1.closecon();
			
			Fecha f = new Fecha();
			String actual=f.sacarfecha();
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO recibo(inscripcion_idinscripcion,fechan, anulado, monto, nit) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, actual);
			pre.setString(3, "0");
			pre.setFloat(4, monto);
			pre.setString(5, nit);
			pre.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear la materia","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
	public ResultSet SacarRecibo() throws SQLException{
		String idrecibo = "";
		DB_Connect con1 = new DB_Connect();
		Connection conn=con1.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select idrecibo from recibo order by idrecibo desc limit 1";
		rs = st.executeQuery(querry);
		while(rs.next()) {
			idrecibo = rs.getString("idrecibo");
		}
		con1.closecon();
		
		DB_Connect con = new DB_Connect();
		conn=con.conexion();
		st = (Statement)conn.createStatement();
		querry = "SELECT a.nombres,a.apellido_paterno,a.apellido_materno, c.idrecibo, c.monto, c.fechan, c.nit, e.nombres AS nmateria"
				+ " FROM estudiante a, inscripcion b, recibo c, materia_has_docente d, materia e WHERE a.idestudiante=b.estudiante_idestudiante"
				+ " AND b.idinscripcion=c.inscripcion_idinscripcion AND b.materia_has_docente_materia_idmateria=d.materia_idmateria"
				+ " AND b.materia_has_docente_docente_iddocente=d.docente_iddocente AND d.materia_idmateria=e.idmateria"
				+ " AND c.idrecibo='"+idrecibo+"'";
		ResultSet rs1 = st.executeQuery(querry);
		return rs1;
	}
	//							ACADEMICOS
	
	
	public ResultSet AcadCurso(String curso, String gestion, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.apellido_paterno, a.apellido_materno, a.nombres, e.nombres as nombred, e.ape_pat, e.ape_mat FROM "
				+ "estudiante a, inscripcion b, materia_has_docente c, materia d, docente e WHERE "
				+ "a.idestudiante=b.estudiante_idestudiante AND b.materia_has_docente_materia_idmateria=c.materia_idmateria "
				+ "AND b.materia_has_docente_docente_iddocente=c.docente_iddocente AND c.materia_idmateria=d.idmateria "
				+ "AND c.docente_iddocente=e.iddocente AND c.gestion='"+gestion+"' AND d.nombres='"+curso+"' AND d.paralelo='"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet AcadGeneral(String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.nombres,a.apellido_paterno,a.apellido_materno,a.idestudiante, c.fechan, c.idrecibo ,c.monto, c.nit"
				+ " FROM estudiante a, inscripcion b, recibo c, materia_has_docente d, materia e"
				+ " WHERE a.idestudiante=b.estudiante_idestudiante AND  b.idinscripcion=c.inscripcion_idinscripcion"
				+ " AND b.materia_has_docente_materia_idmateria=d.materia_idmateria"
				+ " AND b.materia_has_docente_docente_iddocente=d.docente_iddocente"
				+ " AND d.materia_idmateria=e.idmateria AND d.gestion='"+gestion+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//							ESTADISTICOS
	
	
	public ResultSet EstGeneral(String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.idinscripcion) AS Total FROM inscripcion a, materia_has_docente b "
				+ "WHERE a.materia_has_docente_materia_idmateria=b.materia_idmateria AND "
				+ "a.materia_has_docente_docente_iddocente=b.docente_iddocente AND b.gestion='"+gestion+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstGenero(String curso, String gestion,String paralelo, String genero) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.genero) AS Total FROM estudiante a, inscripcion b, "
				+ "materia_has_docente c, materia d WHERE a.idestudiante=b.estudiante_idestudiante AND  "
				+ "b.materia_has_docente_materia_idmateria=c.materia_idmateria AND "
				+ "b.materia_has_docente_docente_iddocente=c.docente_iddocente AND d.idmateria = c.materia_idmateria AND "
				+ "d.nombres='"+curso+"' AND d.paralelo='"+paralelo+"' AND c.gestion='"+gestion+"' "
				+ "AND a.genero='"+genero+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstCurso(String curso, String gestion, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.idinscripcion) AS Total FROM inscripcion a , materia_has_docente b , materia c "
				+ "WHERE a.materia_has_docente_materia_idmateria=b.materia_idmateria AND "
				+ "a.materia_has_docente_docente_iddocente=b.docente_iddocente AND b.materia_idmateria=c.idmateria AND "
				+ "c.nombres='"+curso+"' AND c.paralelo='"+paralelo+"' AND b.gestion='"+gestion+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstEdad(String gestion, String curso, String paralelo, int edad) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.idestudiante) AS Total FROM estudiante a, inscripcion b, "
				+ "materia_has_docente c, materia d WHERE a.idestudiante=b.estudiante_idestudiante AND "
				+ "b.materia_has_docente_materia_idmateria=c.materia_idmateria AND b.materia_has_docente_docente_iddocente=c.docente_iddocente "
				+ "AND d.idmateria=c.materia_idmateria AND d.nombres='"+curso+"' AND d.paralelo='"+paralelo+"' AND c.gestion='"+gestion+"' "
				+ "AND a.Edad='"+edad+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//						CONTABLES
	
	
	public ResultSet ContRecibos(String gestion, String curso, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.idestudiante, a.nombres, a.apellido_paterno, a.apellido_materno, c.idrecibo, c.fechan, c.monto, c.nit "
				+ "FROM estudiante a, inscripcion b, recibo c, materia_has_docente d, materia e " 
				+ "WHERE a.idestudiante=b.estudiante_idestudiante AND b.idinscripcion=c.inscripcion_idinscripcion "
				+ "AND b.materia_has_docente_materia_idmateria=d.materia_idmateria "
				+ "AND b.materia_has_docente_docente_iddocente=d.docente_iddocente "
				+ "AND e.idmateria=d.materia_idmateria AND d.gestion='"+gestion+"' AND e.nombres='"+curso+"' AND e.paralelo='"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet ContAnulados(String gestion, String curso, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.idestudiante, a.nombres, a.apellido_paterno, a.apellido_materno, c.idrecibo, c.fechan, c.monto, c.nit "
				+ "FROM estudiante a, inscripcion b, recibo c, materia_has_docente d, materia e "
				+ "WHERE a.idestudiante=b.estudiante_idestudiante AND b.idinscripcion=c.inscripcion_idinscripcion "
				+ "AND b.materia_has_docente_materia_idmateria=d.materia_idmateria "
				+ "AND b.materia_has_docente_docente_iddocente=d.docente_iddocente "
				+ "AND e.idmateria=d.materia_idmateria AND d.gestion='"+gestion+"' AND e.nombres='"+curso+"' AND e.paralelo='"+paralelo+"' AND c.anulado=1";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//							ADMIN
	
	
	public void AdminUsersNew(String ci, String nombre, String apellidoPat, String apellidoMat, String fecha, String dir, String cel, String pass, String tipo) throws ClassNotFoundException {
		try{
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO empleados(idempleados, nombres, apellido_paterno, apellido_materno, fechanc, direccion, celular, password, Tipo_empleado_idTipo_empleado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, ci);
			pre.setString(2, nombre);
			pre.setString(3, apellidoPat);
			pre.setString(4, apellidoMat);
			pre.setString(5, fecha);
			pre.setString(6, dir);
			pre.setString(7, cel);
			pre.setString(8, pass);
			pre.setString(9, tipo);
			
			pre.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear el empleado","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void AdminDocNew(String id, String nombre, String apellidoPat, String apellidoMat, String fecha, String dir, String cel) throws ClassNotFoundException{
		try {
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO docente(iddocente, nombres, ape_pat, ape_mat, fechanac, direccion, celular) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, nombre);
			pre.setString(3, apellidoPat);
			pre.setString(4, apellidoMat);
			pre.setString(5, fecha);
			pre.setString(6, dir);
			pre.setString(7, cel);
			
			pre.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear el docente","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void AdminMatNew(String id, String nombre, String paralelo, String hora, String docente, float monto, String tiempo) throws ClassNotFoundException{
		try {
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/upte","root","");
			String sql = "INSERT INTO materia(idmateria, nombres, paralelo, hora, monto, tiempo) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, nombre);
			pre.setString(3, paralelo);
			pre.setString(4, hora);
			pre.setFloat(5, monto);
			pre.setString(6, tiempo);
			pre.executeUpdate();
			
			String idDocente = "";
			DB_Connect con1 = new DB_Connect();
			Connection conn=con1.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "select iddocente from docente where nombres = '"+docente+"'";
			rs = st.executeQuery(querry);
			while(rs.next()) {
				idDocente = rs.getString("iddocente");
			}
			con1.closecon();
			Fecha f = new Fecha();
			String gestion = f.gestion();
			sql = "INSERT INTO materia_has_docente(materia_idmateria, docente_iddocente, gestion) VALUES(?, ?, ?)";
			PreparedStatement pre1 = (PreparedStatement) con.prepareStatement(sql);
			pre1.setString(1, id);
			pre1.setString(2, idDocente);
			pre1.setString(3, gestion);
			pre1.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear la materia","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
}
