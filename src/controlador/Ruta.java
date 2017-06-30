package controlador;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ruta {
	
	public String funcion(){
		String ruta = "";
		try {
			File f = null;
			JFileChooser dlg = new JFileChooser();
			int option = 0;
			option = dlg.showOpenDialog(null);
			if (option == JFileChooser.APPROVE_OPTION){
				f= dlg.getSelectedFile();
				//txtruta.setText(f.toString());
			}
			ruta = f.toString();
		} catch (Exception e) {
			  JOptionPane.showMessageDialog(null,"NO HAY DIRECCIÓN","",JOptionPane.ERROR_MESSAGE);
		}
		return ruta;
		
	}

}
