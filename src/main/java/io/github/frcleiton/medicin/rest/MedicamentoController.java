package io.github.frcleiton.medicin.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.frcleiton.medicin.model.entity.Medicamento;
import io.github.frcleiton.medicin.model.repository.MedicamentoRepository;

@RestController
@RequestMapping("/api/medicamentos")
//@CrossOrigin("http://localhost:4200")
public class MedicamentoController {

	private MedicamentoRepository repository;
	
	@Autowired
	public MedicamentoController(MedicamentoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Medicamento> obterTodos() {
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamento salvar( @RequestBody @Valid Medicamento medicamento ) {
		return repository.save(medicamento);
	}
	
	@GetMapping("{id}")
	public Medicamento getById( @PathVariable Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado") );		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar( @PathVariable Integer id) {
		repository
				.findById(id)
				.map( medicamento -> {
					repository.delete(medicamento);
					return Void.TYPE;
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar( @PathVariable Integer id, @RequestBody Medicamento medicAtualizado) {
		repository
		.findById(id)
		.map( medicamento -> {
			medicamento.setDescricao(medicAtualizado.getDescricao());
			return repository.save(medicamento);
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}	
	
}
