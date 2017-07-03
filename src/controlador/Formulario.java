package controlador;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class Formulario {

	private static Font title = new Font(Font.FontFamily.TIMES_ROMAN,25,Font.BOLD);
	private static Font sub = new Font(Font.FontFamily.TIMES_ROMAN,20,Font.BOLD);
	private static Font body = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.NORMAL);
	
	public static void form (String apePat, String apeMat,String nombre, String ci ,String exp, String fecha , String edad , String genero , String estado, String dir,
			String zona , String ciudad , String correo  , String instruccion , String profesion , String ocupacion,
			String actividad , String personas , String ingreso , String medio , String problemas , String percontactnombre,
			String percontactapep , String percontactapem , String percontactcorreo , String percontactcel,
			String percontacttel , String cel  , String tel ){
		
		String Ruta = "";
		Ruta dic = new Ruta();
		Ruta=dic.funcion();
		
		try {
    		FileOutputStream archivo = new FileOutputStream(Ruta+".pdf");
			Document doc =new Document(PageSize.A4,30,30,30,30);;
			PdfWriter.getInstance(doc,archivo);
			
			doc.open();

			Image logo = Image.getInstance("images/logop.jpg");
			logo.setAlignment(Image.ALIGN_RIGHT | Image.UNDERLYING);
			logo.scaleToFit(100, 100);
			doc.add(logo);
			
			Paragraph p = new Paragraph();
			String h = "";
			p.add(new Phrase(h,body));
			p.setAlignment(Element.ALIGN_LEFT);
			p.add(new Phrase(Chunk.NEWLINE));
			doc.add(p);
			
			//---------------------
			Paragraph par = new Paragraph();
			String head = "Universidad Católica Boliviana San Pablo\n"
						+"Departamento de Pastoral Universitaria\n"
						+"Universidad para la Tercera Edad (UPTE)";
			par.add(new Phrase(head,sub));
			par.setAlignment(Element.ALIGN_LEFT);
			par.add(new Phrase(Chunk.NEWLINE));
			par.add(new Phrase(Chunk.NEWLINE));
			doc.add(par);
			
			Paragraph par1 = new Paragraph();
			String head1 = "'FICHA DE REGISTRO'";
			par1.add(new Phrase(head1,title));
			par1.setAlignment(Element.ALIGN_LEFT);
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase(Chunk.NEWLINE));
			
			doc.add(par1);
			
			Fecha f = new Fecha();
			Paragraph parc = new Paragraph();
			String headc = "Fecha: "+f.sacarfecha0();
			parc.add(new Phrase(headc,sub));
			parc.setAlignment(Element.ALIGN_RIGHT);
			parc.add(new Phrase(Chunk.NEWLINE));
			parc.add(new Phrase(Chunk.NEWLINE));
			doc.add(parc);
			
			Paragraph par2 = new Paragraph();
			String head2 = "Apellido Paterno: "+apePat;
			par2.add(new Phrase(head2,body));
			par2.setAlignment(Element.ALIGN_LEFT);
			doc.add(par2);
			
			Paragraph par22 = new Paragraph();
			String head22 = "Apellido Materno: "+apeMat;
			par22.add(new Phrase(head22,body));
			par22.setAlignment(Element.ALIGN_LEFT);
			doc.add(par22);
			
			Paragraph par23 = new Paragraph();
			String head23 = "Nombre: "+nombre;
			par23.add(new Phrase(head23,body));
			par23.setAlignment(Element.ALIGN_LEFT);
			doc.add(par23);
			
			Paragraph par24 = new Paragraph();
			String head24 = "C.I.: "+ci+" "+exp;
			par24.add(new Phrase(head24,body));
			par24.setAlignment(Element.ALIGN_LEFT);
			doc.add(par24);
			
			Paragraph par3 = new Paragraph();
			String head3 = "Fecha de nacimiento: "+fecha;
			par3.add(new Phrase(head3,body));
			par3.setAlignment(Element.ALIGN_LEFT);
			doc.add(par3);
			
			Paragraph par33 = new Paragraph();
			String head33 = "Edad: "+edad;
			par33.add(new Phrase(head33,body));
			par33.setAlignment(Element.ALIGN_LEFT);
			doc.add(par33);
			
			Paragraph par333 = new Paragraph();
			String head333 = "Genero: "+genero;
			par333.add(new Phrase(head333,body));
			par333.setAlignment(Element.ALIGN_LEFT);
			doc.add(par333);
			
			Paragraph par4 = new Paragraph();
			String head4 = "Estado Civil: "+estado;
			par4.add(new Phrase(head4,body));
			par4.setAlignment(Element.ALIGN_LEFT);
			doc.add(par4);
			
			Paragraph par5 = new Paragraph();
			String head5 = "Dirreccion: "+dir;
			par5.add(new Phrase(head5,body));
			par5.setAlignment(Element.ALIGN_LEFT);
			doc.add(par5);
			
			Paragraph par6 = new Paragraph();
			String head6 = "Zona: "+zona;
			par6.add(new Phrase(head6,body));
			par6.setAlignment(Element.ALIGN_LEFT);
			doc.add(par6);
			
			Paragraph par61 = new Paragraph();
			String head61 = "Ciudad: "+ciudad;
			par61.add(new Phrase(head61,body));
			par61.setAlignment(Element.ALIGN_LEFT);
			doc.add(par61);
			
			Paragraph par7 = new Paragraph();
			String head7 = "Correo: "+correo;
			par7.add(new Phrase(head7,body));
			par7.setAlignment(Element.ALIGN_LEFT);
			doc.add(par7);
			
			Paragraph par71 = new Paragraph();
			String head71 ="Tel/Cel: "+tel+" - "+cel;
			par71.add(new Phrase(head71,body));
			par71.setAlignment(Element.ALIGN_LEFT);
			doc.add(par71);
			
			Paragraph par8 = new Paragraph();
			String head8 = "Intruccion: "+instruccion;
			par8.add(new Phrase(head8,body));
			par8.setAlignment(Element.ALIGN_LEFT);
			doc.add(par8);
			
			Paragraph par81 = new Paragraph();
			String head81 = "Profesión: "+profesion;
			par81.add(new Phrase(head81,body));
			par81.setAlignment(Element.ALIGN_LEFT);
			doc.add(par81);
			
			Paragraph par82 = new Paragraph();
			String head82 ="Ocupación: "+ocupacion;
			par82.add(new Phrase(head82,body));
			par82.setAlignment(Element.ALIGN_LEFT);
			doc.add(par82);
			
			Paragraph par9 = new Paragraph();
			String head9 = "Actividades fin de semana: "+actividad;
			par9.add(new Phrase(head9,body));
			par9.setAlignment(Element.ALIGN_LEFT);
			doc.add(par9);
			
			Paragraph par10 = new Paragraph();
			String head10 = "Personas con las que vive: "+personas;
			par10.add(new Phrase(head10,body));
			par10.setAlignment(Element.ALIGN_LEFT);
			doc.add(par10);
			
			Paragraph par11 = new Paragraph();
			String head11 = "Tipo de ingreso: "+ingreso;
			par11.add(new Phrase(head11,body));
			par11.setAlignment(Element.ALIGN_LEFT);
			doc.add(par11);
			
			Paragraph par12 = new Paragraph();
			String head12 = "Medio por el cual se entero de la UPTE: "+medio;
			par12.add(new Phrase(head12,body));
			par12.setAlignment(Element.ALIGN_LEFT);
			doc.add(par12);
			
			Paragraph par13 = new Paragraph();
			String head13 = "Problemas de salud: "+problemas;
			par13.add(new Phrase(head13,body));
			par13.setAlignment(Element.ALIGN_LEFT);
			doc.add(par13);
			
			Paragraph par14 = new Paragraph();
			String head14 = "Persona de contacto: "+percontactapep+" "+percontactapem+" "+percontactnombre;
			par14.add(new Phrase(head14,body));
			par14.setAlignment(Element.ALIGN_LEFT);
			doc.add(par14);
			
			Paragraph par144 = new Paragraph();
			String head144 = "Correo: "+percontactcorreo;
			par144.add(new Phrase(head144,body));
			par144.setAlignment(Element.ALIGN_LEFT);
			doc.add(par144);
			
			Paragraph par15 = new Paragraph();
			String head15 = "Tel/Cel: "+percontacttel+" - "+percontactcel;
			par15.add(new Phrase(head15,body));
			par15.setAlignment(Element.ALIGN_LEFT);
			doc.add(par15);
			
			
			doc.close();
		} catch (Exception e2) {
			  JOptionPane.showMessageDialog(null,"Error:\n"+e2);						}
    }
	

}
