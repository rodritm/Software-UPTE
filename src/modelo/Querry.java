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
		String querry = "SELECT DISTINCT gestion FROM materia_has_paralelo";
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
	
	
	public ResultSet Anular(String id) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "UPDATE recibos SET anulado=1 WHERE idrecibo ='"+id+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//							REGISTRAR
	
	
	public void Registrar(String id, String exp, String nombres, String ape_paterno, String ape_materno,String genero, int edad,
			String estado_civil, String foto, String fechanc, String direccion, String zona, String ciudad, String email, int celular, 
			int telefono, String per_contact, int per_tel, String instruccion, String profesion, String ocupacion, String actividad, 
			String per_vive, String ingreso, String info_upte, String motivo, String problemas, String obs, int per_cel, String per_ape_pat, 
			String per_ape_mat, String per_correo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs;
		st = (Statement)conn.createStatement();
		String querry = "INSERT INTO estudiante"
				+ " VALUES ('"+id+"','"+exp+"','"+nombres+"','"+ape_paterno+"','"+ape_materno+"','"+genero+"','"+edad+"','"+estado_civil+"','"+foto+"','"+fechanc+"','"+direccion+"','"+zona+"','"+ciudad+"','"+email+"','"+celular+"','"+telefono+"','"+per_contact+"','"+per_tel+"','"+instruccion+"','"+profesion+"','"+ocupacion+"','"+actividad+"','"+per_vive+"','"+ingreso+"','"+info_upte+"','"+motivo+"','"+problemas+"','"+obs+"','"+per_cel+"','"+per_ape_pat+"','"+per_ape_mat+"','"+per_correo+"')";
		rs = st.executeQuery(querry);
		rs.close();
		st.close();
		conn.close();
	}
	
	
	//							INSCRIBIR
	
	
	public void Inscribir() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs;
		st = (Statement)conn.createStatement();
		String querry = "";
		rs = st.executeQuery(querry);
		rs.close();
		st.close();
		conn.close();
	}
	
	
	//							ACADEMICOS
	
	
	public ResultSet AcadCurso(String curso, String gestion, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.nombres" + 
				" FROM estudiante a, inscripcion b, materia_has_paralelo c , materia d, paralelo e " + 
				" WHERE a.idestudiante=b.estudiante_idestudiante" + 
				" AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria" + 
				" AND b.materia_has_paralelo_paralelo_idparalelo=c.paralelo_idparalelo" + 
				" AND c.materia_idmateria=d.idmateria" + 
				" AND c.paralelo_idparalelo1=e.idparalelo" + 
				" AND d.nombres='"+curso+"'" + 
				" AND e.idparalelo='"+paralelo+"'" + 
				" AND c.gestion='"+gestion+"'" + 
				" ORDER BY a.nombres";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet AcadGeneral(String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.nombres, c.idrecibo, c.fechan, e.nombres" + 
				" FROM estudiante a, inscripcion b, recibo c, materia_has_paralelo d, materia e" + 
				" WHERE a.idestudiante=b.estudiante_idestudiante" + 
				" AND b.recibo_idrecibo=c.idrecibo" + 
				" AND b.materia_has_paralelo_materia_idmateria=d.materia_idmateria" + 
				" AND b.materia_has_paralelo_paralelo_idparalelo=d.paralelo_idparalelo" + 
				" AND e.idmateria=d.materia_idmateria" + 
				" AND d.gestion='"+gestion+"'";
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
		String querry = "SELECT COUNT(b.estudiante_idestudiante) AS Total" + 
				" FROM materia_has_paralelo a, inscripcion b" + 
				" WHERE a.materia_idmateria=b.materia_has_paralelo_materia_idmateria" + 
				" AND a.paralelo_idparalelo=b.materia_has_paralelo_paralelo_idparalelo" + 
				" AND a.gestion='"+gestion+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstGenero(String curso, String gestion,String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.idestudiante) AS Total"
				+ "FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d, paralelo e"
				+ " WHERE a.idestudiante=b.estudiante_idestudiante"
				+ " AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria"
				+ " AND b.materia_has_paralelo_paralelo_idparalelo=e.paralelo_idparalelo"
				+ " AND c.gestion='"+gestion+"'"
				+ " AND d.nombres='"+curso+"'"
				+ " AND e.idparalelo='"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstCurso(String curso, String gestion, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.nombres) AS Total"
				+ " FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d, paralelo e"
				+ " WHERE a.idestudiante=b.estudiante_idestudiante"
				+ " AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria"
				+ " AND e.materia_has_paralelo_materia_idmateria=d.idmateria"
				+ " AND c.materia_has_paralelo_idparalelo=e.idparalelo"
				+ " AND c.gestion = '"+gestion+"'"
				+ " AND d.nombres = '"+curso+"'"
				+ " AND e.idParalelo = '"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstEdad(String gestion, String curso, String paralelo, int edad) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.nombres) AS Total" + 
				" FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d, paralelo e" + 
				" WHERE a.idestudiante=b.estudiante_idestudiante" + 
				" AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria1" + 
				" AND b.materia_has_paralelo_paralelo_idparalelo=c.paralelo_idparalelo" + 
				" AND c.materia_idmateria=d.idmateria" + 
				" AND c.paralelo_idparalelo=e.idparalelo" + 
				" AND e.idparalelo='"+paralelo+"'" + 
				" AND c.gestion='"+gestion+"'" + 
				" AND a.Edad='"+edad+"'" + 
				" AND d.nombres='"+curso+"'";
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
		String querry = "SELECT a.ideestudiante, a.nombres, a.apellido_paterno, a.apellido_materno , c.idrecibo, c.fechan, c.monto, c.nit"
				+ " FROM estudiante a, inscripcion b, recibo c, materia_has_paralelo d, materia e, paralelo f"
				+ " WHERE a.idestudiante=b.estudiante_idestudiante"
				+ " AND b.recibo_idrecibo = c.idrecibo"
				+ " AND b.materia_has_paralelo_materia_idmateria=d.materia_idmateria"
				+ " AND b.materia_has_paralelo_paralelo_idparalelo=f.idparalelo"
				+ " AND d.gestion='"+gestion+"'"
				+ " AND e.nombres='"+curso+"'"
				+ " AND f.idparalelo='"+paralelo+"'"
				+ " ORDER BY c.iderecibo";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet ContAnulados(String gestion, String curso, String paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT c.idrecibo" + 
				" FROM estudiante a, inscripcion b, recibo c, materia_has_paralelo d, materia e, paralelo f" + 
				" WHERE a.idestudiante=b.estudiante_idestudiante" + 
				" AND b.recibo_idrecibo=c.idrecibo" + 
				" AND b.materia_has_paralelo_materia_idmateria=d.materia_idmateria" + 
				" AND b.materia_has_paralelo_paralelo_idparalelo=d.paralelo_idparalelo" + 
				" AND d.materia_idmateria=e.idmateria" + 
				" AND d.paralelo_idparalelo=f.idparalelo" + 
				" AND d.gestion='"+gestion+"'" + 
				" AND e.nombres='"+curso+"'" + 
				" AND f.idparalelo='"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
	
	
	//							ADMIN
	
	
	public void Prueba(String ci) throws ClassNotFoundException {
		try{
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upte","root","");
			String sql = "INSERT INTO prueba (hola) VALUES(?)";
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, ci);
			pre.executeUpdate();
			con.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el usuario","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public void AdminUsersNew(String ci, String nombre, String apellidoPat, String apellidoMat, String fecha, String dir, String cel, String pass, String tipo) throws ClassNotFoundException {
		try{
			Connection con;
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upte","root","");
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
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upte","root","");
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
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upte","root","");
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
