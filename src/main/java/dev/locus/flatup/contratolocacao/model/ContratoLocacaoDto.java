package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoLocacaoDto {

	@JsonProperty(value = "locacao_id")
	private Long idLocacao;

	@NotNull(message = "O imóvel deve ser informado.")
	@JsonProperty(value = "imovel_id")
	private Long idImovelFK;

	@NotNull(message = "Os dias de locação devem ser informado.")
	@JsonProperty(value = "dias_locacao")
	private Integer diasLocacao;
	
	@NotNull(message = "O valor da locação deve ser informado.")
	@JsonProperty(value = "valor_locacao")
	private Integer valorLocacao;
	
	@NotNull(message = "A data de entrada deve ser informada.")
	@JsonProperty(value = "check_in")
	private LocalDateTime checkIn;
	
	@NotNull(message = "A data de entrada deve ser informada.")
	@JsonProperty(value = "check_out")
	private LocalDateTime checkOut;
	
	@NotBlank(message = "A quantidade de pessoas deve ser informada.")
	@JsonProperty(value = "quant_pessoa")
	private String quantPessoa;
	
	@NotNull
	@JsonProperty(value = "validade_promocao")
	@JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate validadePromocao;

}
