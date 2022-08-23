package dev.locus.flatup.locacao.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;
import dev.locus.flatup.imovel.repository.ImovelRepository;
import dev.locus.flatup.locacao.builder.LocacaoBuilder;
import dev.locus.flatup.locacao.model.EnumStatusLocacao;
import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.repository.LocacaoRepository;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Service
public class LocacaoService {

	@Autowired
	LocacaoBuilder builder;

	@Autowired
	LocacaoRepository repository;

	@Autowired
	ImovelRepository imovelRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ContratoLocacaoRepository contratoLocacaoRepository;

	private List<Locacao> listLocacoes;

	public LocacaoService(List<Locacao> listLocacoes) {
		super();
		this.listLocacoes = listLocacoes;
		this.repository = repository;
		this.imovelRepository = imovelRepository;
		this.usuarioRepository = usuarioRepository;
		this.contratoLocacaoRepository = contratoLocacaoRepository;
	}

	public List<Locacao> listarLocacaosTodes() {
		return repository.findAll();
	}

	public List<LocacaoDto> listarLocacaos() {
		List<LocacaoDto> listaLocacaoDtos = new ArrayList<>();

		repository.findAll().forEach(Locacao -> {
			listaLocacaoDtos.add(builder.builderDto(Locacao));
		});

		return listaLocacaoDtos;
	}

	@Transactional
	public LocacaoDto salvar(LocacaoDto locacaoDto) {

		var usuario = usuarioRepository.findById(locacaoDto.getIdUsuarioFK()).orElseThrow();
		var imovel = imovelRepository.findById(locacaoDto.getIdImovelFK()).orElseThrow();
		var contratolocacao = contratoLocacaoRepository.findById(locacaoDto.getIdContratoLocacaoFK()).orElseThrow();

		var locacao = builder.builderModel(locacaoDto, imovel, contratolocacao, usuario,
				EnumStatusLocacao.valueOf(locacaoDto.getStatusLocacao()));
		var locacaoSalvo = builder.builderDto(repository.save(locacao));
		return locacaoSalvo;
	}

	public LocacaoDto encontrarLocacao(Long idLocacao) {
		var locacao = repository.findById(idLocacao).orElseThrow();
		return builder.builderDto(locacao);
	}

	@Transactional
	public LocacaoDto alterar(Long idLocacao, LocacaoDto locacaoDto) {
		var usuario = usuarioRepository.findById(locacaoDto.getIdUsuarioFK()).orElseThrow();
		var imovel = imovelRepository.findById(locacaoDto.getIdImovelFK()).orElseThrow();
		var contratolocacao = contratoLocacaoRepository.findById(locacaoDto.getIdContratoLocacaoFK()).orElseThrow();

		locacaoDto.setIdLocacao(idLocacao);
		var locacao = builder.builderModel(locacaoDto, imovel, contratolocacao, usuario,
				EnumStatusLocacao.valueOf(locacaoDto.getStatusLocacao()));
		return builder.builderDto(repository.save(locacao));
	}

	@Transactional
	public void removerLocacao(Long id) {
		repository.deleteById(id);
	}

	public List<LocacaoDto> retornaLocacoesPorUsuarioEspecifico(Long id) {
		var locacao = repository.retornaLocacaoPorUsuario(id);
		var locacaoDto = builder.builderDto(locacao);

		List<LocacaoDto> listaDeLocacoes = new ArrayList<>();
		listaDeLocacoes.add(locacaoDto);
		return listaDeLocacoes;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("E-mail Usuário", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Imovel Disponibilidade", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Valor Da Locacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status Da Locação", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Locacao locacao : listLocacoes) {
			table.addCell(String.valueOf(locacao.getIdLocacao()));
			table.addCell(String.valueOf(locacao.getIdUsuarioFK().getEmail()));
			table.addCell(String.valueOf(locacao.getIdImovelFK().getStatusOcupacao()));
			table.addCell(String.valueOf(locacao.getIdContratoLocacaoFK().getValorLocacao()));
			table.addCell(String.valueOf(locacao.getStatusLocacao()));

		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Lista De Locações", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.0f, 3.5f, 3.5f, 3.5f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();

	}

}
