package controlador;

import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.Querry;

public class Listas {

	
	private static Font title = new Font(Font.FontFamily.TIMES_ROMAN,20,Font.BOLD);
	private static Font sub = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
	private static Font body = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL);

	

	public static void listas( String gestion,String curso,String paralelo,String ruta){
		String id=null,cod=null,fec=null;
	try{
		ResultSet rs = null;;
		ResultSet rss = null;;
		Querry connec = new Querry();
		rs = connec.AcadCurso(curso, gestion, paralelo);
		rss = connec.AcadCurso(curso, gestion, paralelo);
		
        if( rs!= null){
        	try {
				FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
				Document doc =new Document(PageSize.A4,30,30,30,30);;
				PdfWriter.getInstance(doc,archivo);
				
				doc.open();

				Image logo = Image.getInstance("images/logop.jpg");
				logo.setAlignment(Image.ALIGN_RIGHT | Image.UNDERLYING);
				logo.scaleToFit(100, 100);
				doc.add(logo);
				
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
				par1.add(new Phrase(curso,title));
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				doc.add(par1);
				
				String docente = "";
				while(rss.next()){
					docente = rss.getString("nombred");
				}
				
				
				// --------------------
				Paragraph par2 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par2.add(new Phrase("Docente: "+docente,sub));
				par2.setAlignment(Element.ALIGN_LEFT);
				doc.add(par2);
			
				// ---------------  contenido = fecha y hora del dia-----
				Paragraph par3 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par3.add(new Phrase("Paralelo: "+paralelo+"\nGestion: "+gestion,sub));
				par3.setAlignment(Element.ALIGN_LEFT);
				par3.add(new Phrase(Chunk.NEWLINE));
				par3.add(new Phrase(Chunk.NEWLINE));
				doc.add(par3);
			
				
				//---------------------
				
				//---------------------
				float[] columnWidths = {2,25,9,6};
				PdfPTable tabla = new PdfPTable(columnWidths);
				tabla.setTotalWidth(520);
				tabla.setLockedWidth(true);
				
				PdfPCell c1 = new PdfPCell(new Paragraph("Nº",sub));
				PdfPCell c2 = new PdfPCell(new Paragraph("Apellidos y Nombres",sub));
				PdfPCell c3 = new PdfPCell(new Paragraph("Firma",sub));
				PdfPCell c4 = new PdfPCell(new Paragraph("Control",sub));
				
				tabla.addCell(c1);
				tabla.addCell(c2);
				tabla.addCell(c3);
				tabla.addCell(c4);
				
				//---------- aqui van los titulos de las columnas de la consulta------
			
				String nombre = "";
				 for(int i=1;rs.next();i++){
					 
					    tabla.addCell(i+"");
		                nombre = rs.getString("apellido_paterno")+" "+rs.getString("apellido_materno")+" "+rs.getString("nombres");
		                
		                tabla.addCell(nombre);
		                tabla.addCell("\n");
		                tabla.addCell("");
		            }
				doc.add(tabla);
				//-------------------
				Paragraph par33 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
				par33.add(new Phrase("",sub));
				par33.setAlignment(Element.ALIGN_LEFT);
				par33.add(new Phrase(Chunk.NEWLINE));
				doc.add(par33);
				//--------------------
				
				float[] columnWidths1 = {5,5};
				PdfPTable tabla1 = new PdfPTable(columnWidths1);
				tabla1.setTotalWidth(200);
				tabla1.setLockedWidth(true);
				tabla1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				
				PdfPCell c11 = new PdfPCell(new Paragraph("Hora entrada",sub));
				PdfPCell c22 = new PdfPCell(new Paragraph("Hora salida",sub));
				
				tabla1.addCell(c11);
				tabla1.addCell(c22);
	                tabla1.addCell("\n");
	                tabla1.addCell("\n");
	                doc.add(tabla1);
				//---------------------
	                Paragraph par444 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
					par444.add(new Phrase("___________",sub));
					par444.setAlignment(Element.ALIGN_LEFT);
					doc.add(par444);
	                
	                Paragraph par44 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
					par44.add(new Phrase("F I R M A",sub));
					par44.setAlignment(Element.ALIGN_LEFT);
					par44.add(new Phrase(Chunk.NEWLINE));
					doc.add(par44);
	                
	                Fecha f = new Fecha();
				 Paragraph par4 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
					par4.add(new Phrase("Fecha de consulta: "+f.sacarfecha0(),sub));
					par4.setAlignment(Element.ALIGN_LEFT);
					doc.add(par4);
					
				 
				
				
				doc.close();
				 rs.close();
				 rss.close();				 
				
			} catch (Exception e2) { 
				JOptionPane.showMessageDialog(null,"error"+e2);
			}
        }
        
       
        
    }
    catch (Exception ev){
        JOptionPane.showMessageDialog(null,"Error:\n"+ev);
    }
		
	}
}
