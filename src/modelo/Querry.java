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
	
	
	//					ESTADISTICOS
	
	
	public ResultSet EstGeneral(String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstGenero(String curso, String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT COUNT(a.idestudiante) AS Total"
				+ "FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d"
				+ "WHERE a.idestudiante=b.estudiante_idestudiante"
				+ "AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria"
				+ "AND b.materia_has_paralelo_paralelo_idparalelo=c.paralelo_idparalelo"
				+ "AND c.gestion='"+gestion+"'"
				+ "AND d.nombres='"+curso+"'";
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
				+ "FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d, paralelo e"
				+ "WHERE a.idestudiante=b.estudiante_idestudiante"
				+ "AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria"
				+ "AND e.materia_has_paralelo_materia_idmateria=d.idmateria"
				+ "AND c.materia_has_paralelo_idparalelo=e.idparalelo"
				+ "AND c.gestion = '"+gestion+"'"
				+ "AND d.nombres = '"+curso+"'"
				+ "AND e.idParalelo = '"+paralelo+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
}
