package io.github.frcleiton.medicin.rest.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroDTO {
	
	private String observacao;
	private String data;
	@NotEmpty(message = "Campo Hora é obrigatório")
	private String hora;
	private Integer idMedicamento;

}
