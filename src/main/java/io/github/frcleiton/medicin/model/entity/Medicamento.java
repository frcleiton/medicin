package io.github.frcleiton.medicin.model.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
		setDataInicio(LocalDate.now());
	}
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String forma;
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String intensidade;
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String unidade;
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String frequencia;
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String horario;
	
	@Column(nullable = true, length = 150)
	//@NotEmpty(message = "Campo obrigatório")
	private String observacao;
	
	@Column(name = "data_inicio", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

			
	//@Column(name = "data_ini")
	//@JsonFormat(pattern = "yyyy/MM/dd")
	//private LocalDate dataIni;
	
	//@Column(name = "data_fim")
	//@JsonFormat(pattern = "dd/MM/yyyy")
	//private LocalDate dataFim;
	
}
