package dev.locus.flatup.contratolocacao.service;

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

import dev.locus.flatup.contratolocacao.builder.ContratoLocacaoBuilder;
import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
public class ContratoLocacaoService {
	
	private List<ContratoLocacaoDto> listContratoLocacaoDto;
	
	public ContratoLocacaoService(List<ContratoLocacaoDto> listContratoLocacaoDto) {
		this.listContratoLocacaoDto = listContratoLocacaoDto;
	}

  @Autowired
  ContratoLocacaoBuilder builder;

  @Autowired
  ContratoLocacaoRepository repository;

  @Autowired
  ImovelRepository imovelRepository;


  public List<ContratoLocacao> listarContratoLocacaosTodos(){
	  return repository.findAll();
  }


  public List<ContratoLocacaoDto> listarContratoLocacaos() {
    List<ContratoLocacaoDto> listaContratoLocacaoDtos = new ArrayList<>();

    repository.findAll().forEach(ContratoLocacao -> {
      listaContratoLocacaoDtos.add(builder.builderDto(ContratoLocacao));
    });

    return listaContratoLocacaoDtos;
  }


  @Transactional
  public ContratoLocacaoDto salvar(ContratoLocacaoDto contratoLocacaoDto) {
    var imovel = imovelRepository.findById(contratoLocacaoDto.getIdImovelFK()).orElseThrow();
    var contratoLocacao = builder.builderModel(contratoLocacaoDto, imovel);
    var contratoLocacaoSalvo = builder.builderDto(repository.save(contratoLocacao));
    return contratoLocacaoSalvo;
  }

  public ContratoLocacaoDto encontrarContratoLocacao(Long idContratoLocacao) {
    var contratoLocacao = repository.findById(idContratoLocacao).orElseThrow();
    return builder.builderDto(contratoLocacao);
  }

  @Transactional
  public ContratoLocacaoDto alterar(Long idContratoLocacao, ContratoLocacaoDto contratoLocacaoDto) {
    contratoLocacaoDto.setIdLocacao(idContratoLocacao);
    var imovel = imovelRepository.findById(contratoLocacaoDto.getIdImovelFK()).orElseThrow();
    var contratoLocacao = builder.builderModel(contratoLocacaoDto, imovel);
    return builder.builderDto(repository.save(contratoLocacao));
  }

  @Transactional
  public void removerContratoLocacao(Long id) {
    repository.deleteById(id);
  }

  
  private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("idLocacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("idImovelFK", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("diasLocacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("valorLocacao", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("checkIn", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("checkOut", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("quantPessoa", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (ContratoLocacaoDto contratoLocacaoDto : listContratoLocacaoDto) {
			table.addCell(String.valueOf(contratoLocacaoDto.getIdLocacao()));
			table.addCell(String.valueOf(contratoLocacaoDto.getIdImovelFK()));
			table.addCell(String.valueOf(contratoLocacaoDto.getDiasLocacao()));
			table.addCell(String.valueOf(contratoLocacaoDto.getValorLocacao()));
			table.addCell(String.valueOf(contratoLocacaoDto.getCheckIn()));
			table.addCell(String.valueOf(contratoLocacaoDto.getCheckOut()));
			table.addCell(String.valueOf(contratoLocacaoDto.getQuantPessoa()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("Lista De Contratos de Locação", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();

	}

}
