package dev.locus.flatup.imovel.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import dev.locus.flatup.imovel.model.Imovel;
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
import dev.locus.flatup.endereco.repository.EnderecoRepository;
import dev.locus.flatup.imovel.builder.ImovelBuilder;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
@Transactional
public class ImovelService {

	@Autowired
	ImovelBuilder builder;

	@Autowired
	ImovelRepository repository;

	@Autowired
	EnderecoRepository enderecoRepository;

	private List<ImovelDto> listaComImoveisPorPessoa;
	

	public ImovelService(List<ImovelDto> listaComImoveisPorPessoa) {
		this.listaComImoveisPorPessoa = listaComImoveisPorPessoa;
		this.enderecoRepository = enderecoRepository;
		this.repository = repository;
	}
	
	
	
	

	public List<ImovelDto> listarImoveis() {
		List<ImovelDto> listaImovelDtos = new ArrayList<ImovelDto>();

		repository.findAll().forEach(Imovel -> {
			listaImovelDtos.add(builder.builderDto(Imovel));
		});
		
	
		return listaImovelDtos;
	}

	public List<ImovelDto> listarImoveisPessoa(Long idPessoa) {
		var listaImovelDtos = new ArrayList<ImovelDto>();

		repository.findAllByIdPessoa(idPessoa).forEach(Imovel -> {
			listaImovelDtos.add(builder.builderDto(Imovel));
		});

	
		return listaImovelDtos;
	}

	@Transactional
	public ImovelDto salvar(ImovelDto imovelDto) {
		Endereco endereco = enderecoRepository.getById(imovelDto.getIdEnderecoFK());
		var imovel = builder.builderModel(imovelDto, EnumClimatizado.valueOf(imovelDto.getClimatizado()), endereco,
				EnumStatusOcupacao.valueOf(imovelDto.getStatusOcupacao()));
		var imovelSalvo = builder.builderDto(repository.save(imovel));
		return imovelSalvo;
	}

	public ImovelDto encontrarImovel(Long idImovel) {
		var imovel = repository.findById(idImovel).orElseThrow();
		return builder.builderDto(imovel);
	}

	@Transactional
	public ImovelDto alterar(Long idImovel, ImovelDto imovelDto) {
		imovelDto.setIdImovel(idImovel);
		var endereco = enderecoRepository.findById(imovelDto.getIdImovel()).orElseThrow();
		var imovel = builder.builderModel(imovelDto, EnumClimatizado.valueOf(imovelDto.getClimatizado()), endereco,
				EnumStatusOcupacao.valueOf(imovelDto.getStatusOcupacao()));
		return builder.builderDto(repository.save(imovel));
	}

	@Transactional
	public void removerImovel(Long id) {
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

		cell.setPhrase(new Phrase("climatizado", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("statusOcupacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Rua", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Bairro", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
	
		for (ImovelDto imovelDto : listaComImoveisPorPessoa) {
			Endereco endereco = enderecoRepository.findById(imovelDto.getIdEnderecoFK()).orElseThrow();
			table.addCell(String.valueOf(imovelDto.getIdImovel()));
			table.addCell(String.valueOf(imovelDto.getClimatizado()));
			table.addCell(String.valueOf(imovelDto.getStatusOcupacao()));
			table.addCell(String.valueOf(endereco.getLogradouro()));
			table.addCell(String.valueOf(endereco.getBairro()));
		}
	}

	private List<ImovelDto> retornaDtoImoveis(List<Imovel> imoveis) {
		var imovelDtos = new ArrayList<ImovelDto>();
		imoveis.forEach(imovel -> imovelDtos.add(builder.builderDto(imovel)));
		return imovelDtos;
	}

	public List<ImovelDto> listarImoveisCidade(String cidade) {
		var imovelDtos = new ArrayList<ImovelDto>();
		repository.findAllByCidade(cidade).forEach(imovel -> imovelDtos.add(builder.builderDto(imovel)));
		return imovelDtos;
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
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
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();
	}


}
