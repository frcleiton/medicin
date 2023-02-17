package io.github.frcleiton.medicin.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.frcleiton.medicin.model.entity.Medicamento;
import io.github.frcleiton.medicin.model.entity.Registro;
import io.github.frcleiton.medicin.model.repository.MedicamentoRepository;
import io.github.frcleiton.medicin.model.repository.RegistroRepository;
import io.github.frcleiton.medicin.rest.dto.RegistroDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/registro")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:4200")
public class RegistroController {
	
	private final MedicamentoRepository medicamentoRepository;
	private final RegistroRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Registro salvar( @RequestBody @Valid RegistroDTO dto ) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idMedicamento = dto.getIdMedicamento();
		
		Medicamento medicamento = medicamentoRepository
										.findById(idMedicamento)
										.orElseThrow(() ->
											new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medicamento não encontrado")
										);
		
		Registro registro = new Registro();
		registro.setMedicamento(medicamento);
		registro.setObservacao(dto.getObservacao());
		registro.setData( data );
		registro.setHora( dto.getHora() );
		
		return repository.save(registro);		
	}
	
	@GetMapping
	public List<Registro> getRegistros( @RequestParam(value = "nome", required = false, defaultValue = "") String nome ) {
		return repository.findByNomeMedicamento("%"+nome+"%");
	}

}
