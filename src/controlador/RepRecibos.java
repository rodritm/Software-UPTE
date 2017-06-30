package controlador;

import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import modelo.Querry;

public class RepRecibos {
	
	private static Font title = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
	private static Font sub = new Font(Font.FontFamily.COURIER,12,Font.NORMAL);
	private static Font body = new Font(Font.FontFamily.COURIER,12,Font.ITALIC);

	

	public static void recibos( String gestion,String curso,String paralelo,String ruta){
		String id=null,cod=null,fec=null;
	String contenido="hooooooooooooooolas";
	try{
		ResultSet rs = null;
		Querry connec = new Querry();
		rs = connec.ContRecibos(gestion, curso, paralelo);
		
        if( rs!= null){
        	try {
				FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
				Document doc =new Document(PageSize.A4,30,30,30,30);
				PdfWriter.getInstance(doc,archivo);
				
				doc.open();
				
				//--------curso
				Paragraph par1 = new Paragraph();
				par1.add(new Phrase(curso,title));
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				doc.add(par1);
				// -------echa y hora
				Paragraph par2 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par2.add(new Phrase(contenido,sub));
				par2.setAlignment(Element.ALIGN_LEFT);
				doc.add(par2);
			
				// -------- paraleo
				Paragraph par3 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par3.add(new Phrase(paralelo,sub));
				par3.setAlignment(Element.ALIGN_RIGHT);
				par3.add(new Phrase(Chunk.NEWLINE));
				par3.add(new Phrase(Chunk.NEWLINE));
				doc.add(par3);
			
				//---------------------
				
				/*Image logo = Image.getInstance("/logop.jpg");
				logo.setAlignment(Image.ALIGN_RIGHT | Image.UNDERLYING);
				logo.scaleToFit(100, 100);
				doc.add(logo);*/
				//---------------------
				PdfPTable tabla = new PdfPTable(7);
				PdfPCell c1 = new PdfPCell(new Paragraph("Nº",sub));
				PdfPCell c2 = new PdfPCell(new Paragraph("Fecha",sub));
				PdfPCell c3 = new PdfPCell(new Paragraph("Recibo",sub));
				PdfPCell c4 = new PdfPCell(new Paragraph("C.I.",sub));
				PdfPCell c5 = new PdfPCell(new Paragraph("Apellido y Nombre",sub));
				PdfPCell c6 = new PdfPCell(new Paragraph("bs.",sub));
				PdfPCell c7 = new PdfPCell(new Paragraph("NIT",sub));
				
				tabla.addCell(c1);
				tabla.addCell(c2);
				tabla.addCell(c3);
				tabla.addCell(c4);
				tabla.addCell(c5);
				tabla.addCell(c6);
				tabla.addCell(c7);
				
				//---------- aqui van los titulos de las columnas de la consulta------
				 while(rs.next()){
		                tabla.addCell(rs.getString("1"));
		                tabla.addCell(rs.getString("2"));
		                tabla.addCell(rs.getString("3"));
		                tabla.addCell(rs.getString("4"));
		                tabla.addCell(rs.getString("5"));
		                tabla.addCell(rs.getString("6"));
		                tabla.addCell(rs.getString("qwertyuiopqwertyuiop"));
		            }
				
				//---------------------
				 //tabla.calculateHeights(true);
				 tabla.setTotalWidth(500);
				 tabla.setLockedWidth(true);
				doc.add(tabla);
				
				doc.close();
				
			} catch (Exception e2) { 
				System.out.println("error"+e2);
			}
        }
        
        rs.close();
        
    }
    catch (Exception ev){
        JOptionPane.showMessageDialog(null,"Error:\n"+ev);
    }
		
	}

}
