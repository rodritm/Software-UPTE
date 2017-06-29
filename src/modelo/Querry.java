package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Querry {
	//						LOGIN
	
	
	public ResultSet Log(String user,String pass) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "select idempleados, password,nombres from empleados where idempleados = '"+user+"' and password = '"+pass+"'";
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
	
	
	public void Registrar() throws SQLException{
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
	
	
	//					ESTADISTICOS
	
	
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
	
	
	public ResultSet ContRecibos(String gestion, String curso, int paralelo) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT a.nombres, c.idrecibo, c.fechan"
				+ " FROM estudiante a, inscripcion b, recibo c, materia_has_paralelo d, materia e, paralelo f"
				+ " WHERE a.idestudiante=b.estudiante_idestudiante"
				+ " AND b.recibo_idrecibo = c.idrecibo"
				+ " AND b.materia_has_paralelo_materia_idmateria=d.materia_idmateria"
				+ " AND b.materia_has_paralelo_paralelo_idparalelo=f.idparalelo"
				+ " AND d.gestion='"+gestion+"'"
				+ " AND e.nombres='"+curso+"'"
				+ " AND f.idparalelo='"+paralelo+"'";
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
	
	
	public void AdminUsersNew(String id, String nombre, String apellidoPat, String apellidoMat, String fecha, String dir, int cel, String pass, int tipo) {
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "INSERT INTO empleados VALUES"
					+ "('"+id+"', '"+nombre+"', '"+apellidoPat+"', '"+apellidoMat+"',"
					+ " '"+fecha+"', '"+dir+"', '"+cel+"', '"+pass+"', '"+tipo+"');";
			rs = st.executeQuery(querry);
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el usuario","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
//	public ResultSet AdminUsersUpdate() throws SQLException{
//		DB_Connect con = new DB_Connect();
//		Connection conn=con.conexion();
//		Statement st;
//		ResultSet rs = null;
//		st = (Statement)conn.createStatement();
//		String querry = "select idempleados, password,nombres from empleados where idempleados = '"+user+"' and password = '"+pass+"'";
//		rs = st.executeQuery(querry);
//		return rs;
//	}	
	public void AdminUsersRemove(String id) {
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "DELETE FROM empleados WHERE idempleados='"+id+"'";
			rs = st.executeQuery(querry);
			rs.close();
			st.close();
			conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el usuario","Error al eliminar",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void AdminDocNew(String id, String nombre, String apellidoPat, String apellidoMat, String fecha, String dir, int cel){
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "INSERT INTO empleados VALUES"
					+ "('"+id+"', '"+nombre+"', '"+apellidoPat+"', '"+apellidoMat+"', '"+fecha+"', '"+dir+"', '"+cel+"');";
			rs = st.executeQuery(querry);
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el docente","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
//	public ResultSet AdminDocUpdate() throws SQLException{
//		DB_Connect con = new DB_Connect();
//		Connection conn=con.conexion();
//		Statement st;
//		ResultSet rs = null;
//		st = (Statement)conn.createStatement();
//		String querry = "select idempleados, password,nombres from empleados where idempleados = '"+user+"' and password = '"+pass+"'";
//		rs = st.executeQuery(querry);
//		return rs;
//	}
	public void AdminDocRemove(String id) {
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "DELETE FROM docente WHERE iddocente='"+id+"'";
			rs = st.executeQuery(querry);
			rs.close();
			st.close();
			conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el docente","Error al eliminar",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void AdminMatNew(String id, String nombre) {
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "INSERT INTO materia VALUES"
					+ "('"+id+"', '"+nombre+"');";
			rs = st.executeQuery(querry);
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear la materia","Error al crear",JOptionPane.ERROR_MESSAGE);
		}
	}
//	public ResultSet AdminMatUpdate() throws SQLException{
//		DB_Connect con = new DB_Connect();
//		Connection conn=con.conexion();
//		Statement st;
//		ResultSet rs = null;
//		st = (Statement)conn.createStatement();
//		String querry = "select idempleados, password,nombres from empleados where idempleados = '"+user+"' and password = '"+pass+"'";
//		rs = st.executeQuery(querry);
//		return rs;
//	}
	public void AdminMatRemove(String id) {
		try{
			DB_Connect con = new DB_Connect();
			Connection conn=con.conexion();
			Statement st;
			ResultSet rs = null;
			st = (Statement)conn.createStatement();
			String querry = "DELETE FROM materia WHERE idmateria='"+id+"'";
			rs = st.executeQuery(querry);
			st.close();
			rs.close();
			conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar la materia","Error al eliminar",JOptionPane.ERROR_MESSAGE);
		}
	}
}
