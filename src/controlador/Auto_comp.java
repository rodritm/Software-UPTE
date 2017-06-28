package controlador;

import java.sql.ResultSet;

import javax.swing.JTextField;

import com.mxrck.autocompleter.TextAutoCompleter;

import modelo.Querry;

public class Auto_comp {
	public void item() {
		JTextField caja = null;									//Aqui tienes q tener el text field no puede ir en otro lado xD
		TextAutoCompleter auto = new TextAutoCompleter(caja);
		Querry q = new Querry();
		ResultSet rs;
		String ids;
		try{
			rs = q.auto();
			while(rs.next()) {
				ids = (rs.getString("idempleados"));
				auto.addItem(ids);
			}
		}catch(Exception e) {
			
		}
		
	}
}

