package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
	public static String sacarfecha() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate ahora = LocalDate.now();
		String fecha = ahora.format(fmt);
		return fecha;
	}
	public String gestion() {
		String fecha = "";
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		if(month<=6) 
			fecha = "1-"+year;
		else
			fecha = "2-"+year;
		return fecha;
	}
}
