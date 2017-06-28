package controlador;

import javax.swing.JOptionPane;

import vista.Menu;

public class Login {
	public static boolean login(Empleados emp, int restantes){
		String user = emp.user;
		String pass = emp.pass;
		if(user.equals("Augusto") && pass.equals("123") ||
				user.equals("prime") && pass.equals("123")){
			JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema.\nBienvenido: "+user);
			return true;
		}else{
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
