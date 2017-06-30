package controlador;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Querry;

public class Login {
	public boolean login(Empleados emp, int restantes){
		String user = emp.user;
		String pass = emp.pass;
		
		String userbd = null, passbd = null,name = null;
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
			JOptionPane.showMessageDialog(null, "ERROR\n"+ev,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if(userbd.equals(user) && passbd.equals(pass)){
			JOptionPane.showMessageDialog(null, "Bienvenido: "+name+"\n "
					+ "Has ingresado satisfactoriamente al sistema.","Acceso Concedido",JOptionPane.PLAIN_MESSAGE);
			return true;
		}
		return false;
	}
	public boolean loginAdmin(Empleados emp, int restantes){
		String user = emp.user;
		String pass = emp.pass;
		
		String userbd = null, passbd = null,name = null,tipo = null;
		ResultSet rs;
		try{
			Querry que = new Querry();
			rs = que.Log(user,pass);
			while(rs.next()){
				userbd = (rs.getString("idempleados"));
				passbd = (rs.getString("password"));
				name = (rs.getString("nombres"));
				tipo = (rs.getString("idTipo_empleado"));
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
			JOptionPane.showMessageDialog(null, "ERROR\n"+ev,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if(userbd.equals(user) && passbd.equals(pass) && tipo.equals("1")){
			JOptionPane.showMessageDialog(null, "Bienvenido: "+name+"\n "
					+ "Has ingresado satisfactoriamente al sistema.","Acceso Concedido",JOptionPane.PLAIN_MESSAGE);
			return true;
		}else {
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
	}
}
