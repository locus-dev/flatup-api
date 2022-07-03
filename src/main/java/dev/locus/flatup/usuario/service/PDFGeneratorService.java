package dev.locus.flatup.usuario.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import dev.locus.flatup.usuario.model.Usuario;


public class PDFGeneratorService {
	
	private List<Usuario> listUsuarios;
	
	public PDFGeneratorService(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font =FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Senha", font));
		table.addCell(cell);
		
	}
	
	private void writeTableData(PdfPTable table) {
		for(Usuario usuario : listUsuarios) {
			table.addCell(String.valueOf(usuario.getIdUsuario()));
			table.addCell(usuario.getEmail());
			table.addCell(usuario.getSenha());
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph p = new Paragraph("Lista De Usuários", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f});	
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		document.close();
		
		
	}
	
	
}
