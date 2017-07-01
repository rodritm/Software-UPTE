package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
	public String sacarfecha() {
		String fecha = "";
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		fecha = year+"-"+month+"-"+dia;
		return fecha;
	}
	public String sacarfecha0() {
		String fecha = "";
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		fecha = dia+"/"+month+"/"+year;
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
