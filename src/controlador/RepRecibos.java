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

public class RepRecibos {

	public static void recibos(String ruta){

		String id=null,cod=null,fec=null;
		String contenido = null;
		try{
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
            Class.forName("java.sql.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/upte","root","");
            st=(Statement) conn.createStatement();
            String query="select * from recibo ";
            rs=st.executeQuery(query);
            if( conn != null){
            	try {
					FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
					Document doc =new Document(PageSize.A4);
					PdfWriter.getInstance(doc,archivo);
					
					doc.open();
					Paragraph par1 = new Paragraph();
					Font tipo1 = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD, BaseColor.BLUE);
					par1.add(new Phrase(contenido,tipo1));
					par1.setAlignment(Element.ALIGN_CENTER);
					par1.add(new Phrase(Chunk.NEWLINE));
					par1.add(new Phrase(Chunk.NEWLINE));
					doc.add(par1);
					// --------------------
					Paragraph par2 = new Paragraph();
					Font tipo2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL, BaseColor.BLACK);
					par2.add(new Phrase(contenido,tipo2));
					par2.setAlignment(Element.ALIGN_JUSTIFIED);
					par2.add(new Phrase(Chunk.NEWLINE));
					par2.add(new Phrase(Chunk.NEWLINE));
					doc.add(par2);
				
					//---------------------
					Image logo = Image.getInstance("/home/prime/Descargas/prueba/anulado.png");
					logo.setAlignment(Image.ALIGN_CENTER | Image.UNDERLYING);
					logo.scaleToFit(100, 100);
					doc.add(logo);
					//---------------------
					PdfPTable tabla = new PdfPTable(3);
					PdfPCell c1 = new PdfPCell(new Paragraph("celda 1",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.RED)));
					PdfPCell c2 = new PdfPCell(new Paragraph("celda 2",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.RED)));
					PdfPCell c3 = new PdfPCell(new Paragraph("celda 3",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.RED)));
					
					tabla.addCell(c1);
					tabla.addCell(c2);
					tabla.addCell(c3);
					
					//---------------------
					 while(rs.next()){
			                tabla.addCell(rs.getString("idrecibo"));
			                tabla.addCell(rs.getString("codigo"));
			                tabla.addCell(rs.getString("fechan"));
			            }
					
					//---------------------
					doc.add(tabla);
					doc.close();
					JOptionPane.showMessageDialog(null, "EXITO2");
					
				} catch (Exception e2) { 
					System.out.println("error"+e2);
				}
            	
            }
           
            rs.close();
            st.close();
            conn.close();
           // contenido += id +"\n"+ cod +"\n"+ fec;
            JOptionPane.showMessageDialog(null, "EXITO1\n"+contenido);
            
        }
        catch (Exception ev){
            JOptionPane.showMessageDialog(null,"Error: No hay el producto\n"+ev);
        }
		
	}

}
