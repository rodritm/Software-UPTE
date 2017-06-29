package modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DB_Connect {
	public Connection con;
	
	public Connection conexion(){
		try{
			Class.forName("java.sql.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upte2","root","");
		}catch(Exception e){
			System.out.println("");
		}
		return con;
	}
	public void closecon(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/*
										String ed1=null,ed2=null;
										try{
											DB_Connect con = new DB_Connect();
											Connection conn=con.conexion();
											Statement st = (Statement)conn.createStatement();
											String querry = "select * from prueba";
											ResultSet rs = st.executeQuery(querry);
											while(rs.next()){
												ed1 = (rs.getString("Prueba1"));
												ed2 = (rs.getString("Prueba2"));
											}
											rs.close();
											st.close();
											conn.close();
											String contenido = ed1 + "\t" + ed2;
											JOptionPane.showMessageDialog(null, contenido);
											}catch (Exception ev) {
												// TODO: handle exception
											}
*/
