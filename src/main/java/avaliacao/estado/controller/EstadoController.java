package avaliacao.estado.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import avaliacao.estado.controller.dto.EstadoDto;
import avaliacao.estado.controller.form.AtualizacaoEstadoForm;
import avaliacao.estado.controller.form.EstadoForm;
import avaliacao.estado.model.Estado;
import avaliacao.estado.repository.EstadoRepository;

@RestController
@RequestMapping("api/states")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<EstadoDto> listar() {
		List<Estado> estados = estadoRepository.findAll();
		return EstadoDto.converter(estados);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form, UriComponentsBuilder UriBuilder) {
		
		Estado estado = form.converter(estadoRepository);
		estadoRepository.save(estado);
		
		URI uri = UriBuilder.path("/states/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> detalhar(@PathVariable Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return ResponseEntity.ok(new EstadoDto(estado.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoForm form) {
		Optional<Estado> optional = estadoRepository.findById(id);
		if(optional.isPresent()) {
			Estado estado = form.atualizar(id, estadoRepository);
			return ResponseEntity.ok(new EstadoDto(estado));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Estado> optional = estadoRepository.findById(id);
		if(optional.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping ("/area")
	public List<Estado> listarArea() {
		Sort sort = Sort.by("area").descending();
		return this.estadoRepository.findAll(sort);
	}
	
	@GetMapping ("/populacao")
	public List<Estado> listarPopulacao() {
		Sort sort = Sort.by("populacao").descending();
		return this.estadoRepository.findAll(sort);
	}
	
	@GetMapping ("/regiao")
	public List<Estado> listarRegiao() {
		Sort sort = Sort.by("regiao").ascending();
		return this.estadoRepository.findAll(sort);
	}
	
}