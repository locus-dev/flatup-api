package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
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
	private Double valorLocacao;

	@NotNull(message = "A data de entrada deve ser informada.")
	@JsonProperty(value = "check_in")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime checkIn;

	@NotNull(message = "A data de entrada deve ser informada.")
	@JsonProperty(value = "check_out")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime checkOut;

	@NotBlank(message = "A quantidade de pessoas deve ser informada.")
	@JsonProperty(value = "quant_pessoa")
	private String quantPessoa;

	@NotNull(message = "A validade da Promoção deve ser informada.")
	@JsonProperty(value = "validade_promocao")
	// @DateTimeFormat(iso = ISO.DATE_TIME,pattern = "yyyy-MM-dd")
	// @JsonDeserialize(using = LocalDateTimeDeserializer.class)
	// @JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime validadePromocao;

}
