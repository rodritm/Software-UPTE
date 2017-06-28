package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Querry {
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
//	public ResultSet EstGeneral() throws SQLException{
//		
//	}
	public ResultSet EstGenero() throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT genero, COUNT(genero) AS Total FROM estudiante GROUP BY (genero)";
		rs = st.executeQuery(querry);
		return rs;
	}
	public ResultSet EstCurso(String curso, String gestion) throws SQLException{
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		st = (Statement)conn.createStatement();
		String querry = "SELECT d.nombres, a.nombres, a.apellido paterno, a.apellido materno"
				+ "FROM estudiante a, inscripcion b, materia_has_paralelo c, materia d, materia_has_paralelo_has_decente e"
				+ "WHERE a.idestudiante=b.estudiante_idestudiante"
				+ "AND b.materia_has_paralelo_materia_idmateria=c.materia_idmateria"
				+ "AND e.materia_has_paralelo_materia_idmateria=d.idmateria"
				+"AND e.gestion = '"+gestion+"' AND d.nombres = '"+curso+"'";
		rs = st.executeQuery(querry);
		return rs;
	}
}
