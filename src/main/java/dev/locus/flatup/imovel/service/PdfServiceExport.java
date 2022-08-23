package dev.locus.flatup.imovel.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.endereco.model.EnderecoDto;
import dev.locus.flatup.endereco.repository.EnderecoRepository;
import dev.locus.flatup.endereco.service.EnderecoService;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
@Transactional
public class PdfServiceExport {
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	  EnderecoRepository enderecoRepository;
	
	@Autowired
	ImovelRepository repository;
	
	private List<Imovel> listImovel;
	
	
	
	public PdfServiceExport() {
		super();
	}


	public PdfServiceExport(List<Imovel> listImovel) {
		super();
		this.listImovel = listImovel;
		this.enderecoRepository = enderecoRepository;
	}
	
	
	public List<Imovel> retornaTodosImoveis(){
		return repository.findAll();
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("climatizado", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("statusOcupacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Rua", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Bairro", font));
		table.addCell(cell);

	}
	

	private void writeTableDataTodosImoveis(PdfPTable table) {
		
		for (Imovel imovel : listImovel ) {
			
			System.out.println(imovel.getIdEnderecoFK().getBairro() + "aquié o endereco");
			//System.out.println("aqui peasd"+endereco);
			table.addCell(String.valueOf(imovel.getIdImovel()));
			table.addCell(String.valueOf(imovel.getClimatizado()));
			table.addCell(String.valueOf(imovel.getStatusOcupacao()));
			table.addCell(String.valueOf(imovel.getIdEnderecoFK().getLogradouro()));
			table.addCell(String.valueOf(imovel.getIdEnderecoFK().getBairro()));
			
		}
	}

	public void exportTodosImoveis(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("Lista De Imóveis", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.0f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableDataTodosImoveis(table);

		document.add(table);
		document.close();
	}
}
