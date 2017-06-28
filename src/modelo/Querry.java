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
	public ResultSet EstGen(){
		DB_Connect con = new DB_Connect();
		Connection conn=con.conexion();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = (Statement)conn.createStatement();
			String querry = "select * from prueba";
			rs = st.executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.closecon();
		return rs;
	}
}
