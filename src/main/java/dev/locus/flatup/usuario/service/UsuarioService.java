package dev.locus.flatup.usuario.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import dev.locus.flatup.usuario.model.Usuario;
import dev.locus.flatup.usuario.model.UsuarioOAuth;
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

import dev.locus.flatup.usuario.builder.UsuarioBuilder;
import dev.locus.flatup.usuario.model.UsuarioDto;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

/**
 * Classe de serviço e por gerenciar as chamadas ao repositório.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioBuilder builder;

    @Autowired
    private UsuarioRepository repository;
    
    
    
    private List<UsuarioDto> listUsuariosDto;
	
	public UsuarioService(List<UsuarioDto> listUsuariosDto) {
		this.listUsuariosDto = listUsuariosDto;
	}

    public List<UsuarioDto> listarUsuarios() {
        List<UsuarioDto> listaUsuarioDtos = new ArrayList<>();
        
        repository.findAll().forEach(usuario -> {
            listaUsuarioDtos.add(builder.builderDto(usuario));
        });

        return listaUsuarioDtos;
    }

    @Transactional
    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        
        var usuario = builder.builderModel(usuarioDto);
        var usuarioSalvo = builder.builderDto(repository.save(usuario));
        return usuarioSalvo;
    }


    public UsuarioDto encontrarUsuario(Long idUsuario) {
        var usuario = repository.findById(idUsuario).orElseThrow();
        return builder.builderDto(usuario);
    }

    @Transactional
    public UsuarioDto alterar(Long idUsuario, UsuarioDto usuarioDto) {
        usuarioDto.setIdUsuario(idUsuario);
        var usuarioAlterado = repository.save(builder.builderModel(usuarioDto));
        return builder.builderDto(usuarioAlterado);
    }

    @Transactional
    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
    
    private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font =FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		
		
		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Senha", font));
		table.addCell(cell);
		
	}
    
    
    private void writeTableData(PdfPTable table) {
		for(UsuarioDto usuarioDto : listUsuariosDto) {
			table.addCell(usuarioDto.getEmail());
			table.addCell(usuarioDto.getSenha());
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
		
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f});	
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		document.close();
		
		
	}

    public Usuario encontraUsuarioToken(UsuarioOAuth usuarioOAuth) {
        var usuario = repository.findByEmail(usuarioOAuth.getEmail());
        return usuario.get();
    }

    public void atualizarComUid(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario encontrarUsuarioEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }
}
