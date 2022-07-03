package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoLocacaoDto {

	private Long idLocacao;

	@NotNull
	private Long idImovelFK;

	@NotNull
	private Integer diasLocacao;
	
	@NotNull
	private Integer valorLocacao;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime checkIn;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss" )
	private LocalDateTime checkOut;
	
	@NotBlank
	private String quantPessoa;
}
