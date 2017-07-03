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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Recibo {
	
	private static Font title = new Font(Font.FontFamily.TIMES_ROMAN,30,Font.BOLD);
	private static Font sub = new Font(Font.FontFamily.TIMES_ROMAN,22,Font.BOLD);
	private static Font body = new Font(Font.FontFamily.TIMES_ROMAN,15,Font.NORMAL);

	public static void reciboC(String nombre,String apePa,String apeMa,String idRecibo,String monto,String fecha,String nit1,String mate){
		String Ruta = "";
		Ruta dic = new Ruta();
		Ruta=dic.funcion();
		try {
			FileOutputStream archivo = new FileOutputStream(Ruta+".pdf");
			Document doc =new Document(PageSize.A4,30,30,30,30);;
			PdfWriter.getInstance(doc,archivo);
			
			doc.open();

			Image logo = Image.getInstance("images/logop.jpg");
			logo.setAlignment(Image.ALIGN_LEFT | Image.UNDERLYING);
			logo.scaleToFit(100, 100);
			doc.add(logo);
			
			//---------------------
			Paragraph par = new Paragraph();
			String head = "UNIVERSIDAD PARA LA TERCERA EDAD";
			par.add(new Phrase(head,sub));
			par.setAlignment(Element.ALIGN_RIGHT);
			par.add(new Phrase(Chunk.NEWLINE));
			par.add(new Phrase(Chunk.NEWLINE));
			doc.add(par);

			
			
			Paragraph par1 = new Paragraph();
			par1.add(new Phrase("RECIBO TEMPORAL",title));
			par1.setAlignment(Element.ALIGN_CENTER);
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase(Chunk.NEWLINE));
			doc.add(par1);
			// --------------------
			Paragraph par2 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par2.add(new Phrase("Nº: "+idRecibo,body));
			par2.setAlignment(Element.ALIGN_CENTER);
			par2.add(new Phrase(Chunk.NEWLINE));
			doc.add(par2);
		
			// ---------------  contenido = fecha y hora del dia-----
			Fecha fff = new Fecha();
			Paragraph par3 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par3.add(new Phrase("Fecha: "+fff.sacarfecha0(),body));
			par3.setAlignment(Element.ALIGN_RIGHT);
			par3.add(new Phrase(Chunk.NEWLINE));
			doc.add(par3);
			
			Paragraph par4 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par4.add(new Phrase("Monto: Bs. "+monto,body));
			par4.setAlignment(Element.ALIGN_RIGHT);
			par4.add(new Phrase(Chunk.NEWLINE));
			par4.add(new Phrase(Chunk.NEWLINE));
			doc.add(par4);
			
			Numero_a_Letra NumLetra = new Numero_a_Letra();
			String mmm=NumLetra.Convertir(monto,true);
			
			Paragraph par5 = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par5.add(new Phrase("Recibi de: "+apePa+" "+apeMa+" "+nombre+"\n"
					+ "La suma de "+mmm+"\n"
					+ "Por concepto de: Inscripción al curso de "+mate+"\n"
					+ "NIT: "+nit1,body));
			par5.setAlignment(Element.ALIGN_CENTER);
			par5.add(new Phrase(Chunk.NEWLINE));
			par5.add(new Phrase(Chunk.NEWLINE));
			par5.add(new Phrase(Chunk.NEWLINE));
			par5.add(new Phrase(Chunk.NEWLINE));
			par5.add(new Phrase(Chunk.NEWLINE));
			doc.add(par5);
			
			float[] columnWidths1 = {5,5};
			PdfPTable tabla1 = new PdfPTable(columnWidths1);
			tabla1.setTotalWidth(500);
			tabla1.setLockedWidth(true);
			tabla1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			PdfPCell c1 = new PdfPCell(new Paragraph("__________________________",body));
			PdfPCell c2 = new PdfPCell(new Paragraph("__________________________",body));
			PdfPCell c11 = new PdfPCell(new Paragraph("Entregué",body));
			PdfPCell c22 = new PdfPCell(new Paragraph("Recibí",body));
			PdfPCell c33 = new PdfPCell(new Paragraph("Nombre:__________________",body));
			PdfPCell c44 = new PdfPCell(new Paragraph("Nombre:__________________",body));
			PdfPCell c55 = new PdfPCell(new Paragraph("C.I.:______________________",body));
			PdfPCell c66 = new PdfPCell(new Paragraph("C.I.:______________________",body));
			
			c1.setBorder(PdfPCell.NO_BORDER);
			c2.setBorder(PdfPCell.NO_BORDER);
			c11.setBorder(PdfPCell.NO_BORDER );
			c22.setBorder(PdfPCell.NO_BORDER);
			c33.setBorder(PdfPCell.NO_BORDER );
			c44.setBorder(PdfPCell.NO_BORDER);
			c55.setBorder(PdfPCell.NO_BORDER );
			c66.setBorder(PdfPCell.NO_BORDER);
			
			tabla1.addCell(c1);
			tabla1.addCell(c2);
			tabla1.addCell(c11);
			tabla1.addCell(c22);
			tabla1.addCell(c33);
			tabla1.addCell(c44);
			tabla1.addCell(c55);
			tabla1.addCell(c66);
            doc.add(tabla1);
            
          //-------------------------
            Paragraph p = new Paragraph();
			p.add(new Phrase("",body));
			p.setAlignment(Element.ALIGN_CENTER);
			p.add(new Phrase(Chunk.NEWLINE));
			p.add(new Phrase(Chunk.NEWLINE));
			p.add(new Phrase(Chunk.NEWLINE));
			doc.add(p);
            
            Paragraph p1 = new Paragraph();
			p1.add(new Phrase("--------------------------------------------------------------------------"
					+ "-----------------------------",body));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.add(new Phrase(Chunk.NEWLINE));
			p1.add(new Phrase(Chunk.NEWLINE));
			p1.add(new Phrase(Chunk.NEWLINE));
			doc.add(p1);
            
		//---------------------- COPIA


			Image logoC = Image.getInstance("images/logop.jpg");
			logoC.setAlignment(Image.ALIGN_LEFT | Image.UNDERLYING);
			logoC.scaleToFit(100, 100);
			doc.add(logoC);
			
			//---------------------
			Paragraph parC = new Paragraph();
			String headC = "UNIVERSIDAD PARA LA TERCERA EDAD";
			parC.add(new Phrase(headC,sub));
			parC.setAlignment(Element.ALIGN_RIGHT);
			parC.add(new Phrase(Chunk.NEWLINE));
			parC.add(new Phrase(Chunk.NEWLINE));
			doc.add(parC);

			
			
			Paragraph par1C = new Paragraph();
			par1C.add(new Phrase("RECIBO TEMPORAL",title));
			par1C.setAlignment(Element.ALIGN_CENTER);
			par1C.add(new Phrase(Chunk.NEWLINE));
			par1C.add(new Phrase(Chunk.NEWLINE));
			doc.add(par1C);
			// --------------------
			Paragraph par2C = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par2C.add(new Phrase("Nº: "+idRecibo,body));
			par2C.setAlignment(Element.ALIGN_CENTER);
			par2C.add(new Phrase(Chunk.NEWLINE));
			doc.add(par2C);
		
			// ---------------  contenido = fecha y hora del dia-----
			Fecha fffC = new Fecha();
			Paragraph par3C = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par3C.add(new Phrase("Fecha: "+fffC.sacarfecha0(),body));
			par3C.setAlignment(Element.ALIGN_RIGHT);
			par3C.add(new Phrase(Chunk.NEWLINE));
			doc.add(par3C);
			
			Paragraph par4C = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par4C.add(new Phrase("Monto: Bs. "+monto,body));
			par4C.setAlignment(Element.ALIGN_RIGHT);
			par4C.add(new Phrase(Chunk.NEWLINE));
			par4C.add(new Phrase(Chunk.NEWLINE));
			doc.add(par4C);
			
			Numero_a_Letra NumLetraC = new Numero_a_Letra();
			String mmmC=NumLetra.Convertir(monto,true);
			
			Paragraph par5C = new Paragraph();//Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
			par5C.add(new Phrase("Recibi de: "+apePa+" "+apeMa+" "+nombre+"\n"
					+ "La suma de "+mmmC+"\n"
					+ "Por concepto de: Inscripción al curso de "+mate+"\n"
					+ "NIT: "+nit1,body));
			par5C.setAlignment(Element.ALIGN_CENTER);
			par5C.add(new Phrase(Chunk.NEWLINE));
			par5C.add(new Phrase(Chunk.NEWLINE));
			par5C.add(new Phrase(Chunk.NEWLINE));
			par5C.add(new Phrase(Chunk.NEWLINE));
			par5C.add(new Phrase(Chunk.NEWLINE));
			doc.add(par5C);
			
			
			PdfPTable tabla1C = new PdfPTable(columnWidths1);
			tabla1.setTotalWidth(500);
			tabla1.setLockedWidth(true);
			tabla1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			PdfPCell c1C = new PdfPCell(new Paragraph("__________________________",body));
			PdfPCell c2C = new PdfPCell(new Paragraph("__________________________",body));
			PdfPCell c11C = new PdfPCell(new Paragraph("Entregué",body));
			PdfPCell c22C = new PdfPCell(new Paragraph("Recibí",body));
			PdfPCell c33C = new PdfPCell(new Paragraph("Nombre:__________________",body));
			PdfPCell c44C = new PdfPCell(new Paragraph("Nombre:__________________",body));
			PdfPCell c55C = new PdfPCell(new Paragraph("C.I.:______________________",body));
			PdfPCell c66C = new PdfPCell(new Paragraph("C.I.:______________________",body));
			
			c1C.setBorder(PdfPCell.NO_BORDER);
			c2C.setBorder(PdfPCell.NO_BORDER);
			c11C.setBorder(PdfPCell.NO_BORDER );
			c22C.setBorder(PdfPCell.NO_BORDER);
			c33C.setBorder(PdfPCell.NO_BORDER );
			c44C.setBorder(PdfPCell.NO_BORDER);
			c55C.setBorder(PdfPCell.NO_BORDER );
			c66C.setBorder(PdfPCell.NO_BORDER);
			
			tabla1C.addCell(c1C);
			tabla1C.addCell(c2C);
			tabla1C.addCell(c11C);
			tabla1C.addCell(c22C);
			tabla1C.addCell(c33C);
			tabla1C.addCell(c44C);
			tabla1C.addCell(c55C);
			tabla1C.addCell(c66C);
            doc.add(tabla1C);
            
			
			doc.close();
			
		} catch (Exception e2) { 
			JOptionPane.showMessageDialog(null,"error"+e2);
		}
		
	}
	

}
