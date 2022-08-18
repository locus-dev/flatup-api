package dev.locus.flatup.parceiro.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
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

import dev.locus.flatup.parceiro.builder.ParceiroBuilder;
import dev.locus.flatup.parceiro.model.Parceiro;
import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;
import dev.locus.flatup.usuario.model.Usuario;
import dev.locus.flatup.usuario.repository.ConfigurationInstance;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Service
public class ParceiroService {

	@Autowired
	ParceiroBuilder builder;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ParceiroRepository repository;
	@Autowired
	ConfigurationInstance configurationInstance;

	private List<Parceiro> listParceiros;

	public ParceiroService(List<Parceiro> listParceiros) {
		super();
		this.listParceiros = listParceiros;
		this.usuarioRepository = usuarioRepository;
		this.repository = repository;
		this.configurationInstance = configurationInstance;
	}

	public List<Parceiro> listarParceiroTodes(){
		return repository.findAll();
	}
	
	public List<ParceiroDto> listarParceiros() {
		List<ParceiroDto> listaParceiroDtos = new ArrayList<>();

		repository.findAll().forEach(parceiro -> {
			listaParceiroDtos.add(builder.builderDto(parceiro));
		});

		return listaParceiroDtos;
	}

	@Transactional
	public ParceiroDto salvar(ParceiroDto parceiroDto) {
		var usuario = usuarioRepository.findById(parceiroDto.getIdParceiro()).orElseThrow();
		var parceiro = builder.builderModel(parceiroDto, usuario);
		var parceiroSalvo = builder.builderDto(repository.save(parceiro));
		return parceiroSalvo;
	}

	public ParceiroDto encontrarParceiro(Long idParceiro) {
		var parceiro = repository.findById(idParceiro).orElseThrow();
		return builder.builderDto(parceiro);
	}

	@Transactional
	public ParceiroDto alterar(Long idParceiro, ParceiroDto parceiroDto) {
		var usuario = usuarioRepository.findById(parceiroDto.getIdUsuarioFK()).orElseThrow();
		parceiroDto.setIdParceiro(idParceiro);
		var parceiro = builder.builderModel(parceiroDto, usuario);
		return builder.builderDto(repository.save(parceiro));
	}

	@Transactional
	public void removerParceiro(Long id) {
		repository.deleteById(id);
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Descrição", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nome Fantasia", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("CNPJ", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Usuario Responsável", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Parceiro parceiro : listParceiros) {
			table.addCell(String.valueOf(parceiro.getIdParceiro()));
			table.addCell(String.valueOf(parceiro.getDescricao()));
			table.addCell(String.valueOf(parceiro.getNomeFantasia()));
			table.addCell(String.valueOf(parceiro.getCnpj()));
			table.addCell(String.valueOf(parceiro.getIdUsuarioFK().getEmail()));
			
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("Lista De Parceiros", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();
	}

}
