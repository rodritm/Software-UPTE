package controlador;

public class Empleados {
	String user,pass,nombre,tipo_user;

	public Empleados(String user, String pass, String nombre, String tipo_user) {
		super();
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.tipo_user = tipo_user;
	}

	public Empleados(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	
}
