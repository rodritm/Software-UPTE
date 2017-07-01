package controlador;

import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.Querry;

public class RepAnulados {

	
	private static Font title = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
	private static Font sub = new Font(Font.FontFamily.COURIER,12,Font.BOLD);
	private static Font body = new Font(Font.FontFamily.COURIER,12,Font.NORMAL);

	

	public static void recibos( String gestion,String curso,String paralelo,String ruta){
		String id=null,cod=null,fec=null;
	try{
		ResultSet rs = null;
		Querry connec = new Querry();
		rs = connec.ContAnulados(gestion, curso, paralelo);
		
        if( rs!= null){
        	try {
        		FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
				Document doc =new Document(PageSize.A4,30,30,30,30);;
				PdfWriter.getInstance(doc,archivo);
				
				doc.open();

				Image logo = Image.getInstance("/logop.jpg");
				logo.setAlignment(Image.ALIGN_RIGHT | Image.UNDERLYING);
				logo.scaleToFit(100, 100);
				doc.add(logo);
				
				//---------------------
				Paragraph par = new Paragraph();
				par.add(new Phrase("ANULADOS",title));
				par.setAlignment(Element.ALIGN_CENTER);
				par.add(new Phrase(Chunk.NEWLINE));
				par.add(new Phrase(Chunk.NEWLINE));
				doc.add(par);

				
				
				Paragraph par1 = new Paragraph();
				par1.add(new Phrase(curso,title));
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				doc.add(par1);
				// --------------------
				Paragraph par2 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par2.add(new Phrase(paralelo+" "+gestion,sub));
				par2.setAlignment(Element.ALIGN_LEFT);
				doc.add(par2);
			
				// ---------------  contenido = fecha y hora del dia-----
				Fecha fff = new Fecha();
				Paragraph par3 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par3.add(new Phrase(fff.sacarfecha(),sub));
				par3.setAlignment(Element.ALIGN_RIGHT);
				par3.add(new Phrase(Chunk.NEWLINE));
				par3.add(new Phrase(Chunk.NEWLINE));
				doc.add(par3);
			
				
				//---------------------
				
				float[] columnWidths = {3,7,5,9,20,3,9};
				PdfPTable tabla = new PdfPTable(columnWidths);
				tabla.setTotalWidth(520);
				tabla.setLockedWidth(true);
				
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
				String nombre = "";
				 for(int i=1;rs.next();i++){
		                tabla.addCell(i+"");
		                tabla.addCell(rs.getString("fechan"));
		                tabla.addCell(rs.getString("idrecibo"));
		                tabla.addCell(rs.getString("idestudiante"));
		                nombre = rs.getString("apellido_paterno")+" "+rs.getString("apellido_materno")+" "+rs.getString("nombres");
		                tabla.addCell(nombre);
		                tabla.addCell(rs.getString("monto"));
		                tabla.addCell(rs.getString("nit"));
		            }
				
				//---------------------
				 //tabla.calculateHeights(true);
				 
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
