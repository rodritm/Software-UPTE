package controlador;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Querry;

public class Login {
	public static boolean login(Empleados emp, int restantes){
		String user = emp.user;
		String pass = emp.pass;
		
		String userbd = null, passbd = null,name=null;
		ResultSet rs;
		try{
			Querry que = new Querry();
			rs = que.Log(user,pass);
			while(rs.next()){
				userbd = (rs.getString("idempleados"));
				passbd = (rs.getString("password"));
				name = (rs.getString("nombres"));
			}
			if((userbd == null) || (passbd == null)){
				if(restantes>1){
					restantes--;
					JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
		                    + "Por favor ingrese un usuario y/o contraseña correctos \nIntentos Disponibles: "+restantes, "Acceso denegado",
		                    JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else{
					JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
		                    + "Exceso de ingresos permitidos", "Acceso denegado",
		                    JOptionPane.ERROR_MESSAGE);
					System.exit(0);
					return false;
				}
			}
		}catch (Exception ev) {
			
		}
		if(userbd.equals(user) && passbd.equals(pass)){
			JOptionPane.showMessageDialog(null, "Bienvenido: "+name+"\n "
					+ "Has ingresado satisfactoriamente al sistema.","Acceso Concedido",JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		return false;
	}
}
