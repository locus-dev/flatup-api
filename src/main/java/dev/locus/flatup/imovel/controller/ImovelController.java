package dev.locus.flatup.imovel.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.lowagie.text.DocumentException;


import dev.locus.flatup.imovel.model.Imovel;

import dev.locus.flatup.contratolocacao.service.ContratoLocacaoService;
import dev.locus.flatup.imovel.model.ImovelDetalharDto;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.model.ImovelListaDto;
import dev.locus.flatup.imovel.service.ImovelService;
import dev.locus.flatup.imovel.service.PdfServiceExport;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*" )
@RequestMapping(value = "/imovel")
public class ImovelController {

	@Autowired
	ImovelService imovelService;
	
	@Autowired
	PdfServiceExport pdfServiceExport;


	@GetMapping("/listar")
	public List<ImovelDto> listarImoveis() {
		return imovelService.listarImoveis();
	}

	@GetMapping("/listar/descricao")
	public List<ImovelListaDto> listarImoveisDescricao() {
		return imovelService.listarImoveisDescricoes();
	}
	
	@GetMapping("/listar/detalhes/{id}")
	public ImovelDetalharDto listarImoveisDetalhes(@PathVariable("id") Long id) {
		return imovelService.exibirImovelDetalhamento(id);
	}

	@GetMapping("/listar/{id}")
	public List<ImovelDto> listarMeusImoveis(@PathVariable("id") Long idPessoa) {
		return imovelService.listarImoveisPessoa(idPessoa);
	}

	@GetMapping("/listar/{cidade}")
	public List<ImovelDto> listarImoveisPorCidade(@PathVariable("cidade") String cidade) {
		return imovelService.listarImoveisCidade(cidade);
	}

	@PostMapping("/salvar")
	public ResponseEntity<ImovelDto> salvarImovel(@RequestBody @Valid ImovelDto imovelDto) {
		var imovel = imovelService.salvar(imovelDto);
		return ResponseEntity.ok(imovel);

	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<ImovelDto> buscarImovelPorId(@PathVariable Long id) throws Exception {
		var imovel = imovelService.encontrarImovel(id);
		return ResponseEntity.ok(imovel);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ImovelDto> editarImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid ImovelDto imovelDto) throws Exception {
		var novoimovel = imovelService.alterar(id, imovelDto);
		return ResponseEntity.ok(novoimovel);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerImovelPorId(@PathVariable Long id) throws Exception {
		imovelService.removerImovel(id);
		return ResponseEntity.ok().build();
	}

	//produces = { "text/plain" }
	@GetMapping(path="/pdf/{id}")
	public void exportPdfImovelPorPessoa(HttpServletResponse response, @PathVariable("id") Long id) throws DocumentException, IOException{
		//response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=imóveis-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<ImovelDto> imoveis = imovelService.listarImoveisPessoa(id);
		System.out.println("Aqui é o array de imoveis por pessoa" + imoveis);
		ImovelService exporter = new ImovelService(imoveis);
		exporter.export(response);
	}
	
	
	@GetMapping(path="/pdf")
	public void exportPdTodosOsImoveis(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=imóveis-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Imovel> imoveis = imovelService.listarImoveisGERAl();
		
		PdfServiceExport exporter = new PdfServiceExport(imoveis);
		exporter.exportTodosImoveis(response);
	}
	
	
//	@GetMapping("/csv")
//    public void exportToCSV(HttpServletResponse response) throws IOException {
//        response.setContentType("text/csv");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//        String currentDateTime = dateFormatter.format(new Date());
//         
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=Imóveis" + currentDateTime + ".csv";
//        response.setHeader(headerKey, headerValue);
//         
//    	List<Imovel> imoveis = imovelService.listarImoveisGERAl();
// 
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//        String[] csvHeader = {"ID imóvel", "Climatizado", "Status Ocupação", "Rua", "Bairro"};
//        
//         
//        csvWriter.writeHeader(csvHeader);
//         
//        for (Imovel imov : imoveis) {
//        	
//        	String idImovel = String.valueOf(imov.getIdImovel());
//			String climatizado = String.valueOf(imov.getClimatizado());
//			String statusOcupacao = String.valueOf(imov.getStatusOcupacao());
//			String logradouro  = String.valueOf(imov.getIdEnderecoFK().getLogradouro());
//			String bairro = String.valueOf(imov.getIdEnderecoFK().getBairro());
//			
//			String[] nameMapping = {idImovel, climatizado,statusOcupacao, logradouro, bairro};
//			
//            csvWriter.write(imov, nameMapping);
//        }
//
//        csvWriter.close();
//         
//    }
	
}
