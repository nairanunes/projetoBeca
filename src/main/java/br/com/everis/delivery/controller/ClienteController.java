package br.com.everis.delivery.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.everis.delivery.dto.ClienteDto;
import br.com.everis.delivery.form.AtualizacaoDadosClienteForm;
import br.com.everis.delivery.form.ClienteForm;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	// Método para cadastro
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converter();
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));

	}

	@GetMapping("/{id}")
	@Transactional
	public ClienteDto detalhar(@PathVariable Long id) {
		Cliente cliente = clienteRepository.getOne(id);
		return new ClienteDto(cliente);

	}

	// Método para listar todos
	@GetMapping
	@Transactional
	public List<ClienteDto> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes);

	}

	@PutMapping("/id")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarDados(@PathVariable Long id,
			@RequestBody AtualizacaoDadosClienteForm clienteForm) {
		Cliente cliente = clienteForm.atualizaDadosClientes(id, clienteRepository);

		return ResponseEntity.ok(new ClienteDto(cliente));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarSenha(@PathVariable Long id,
			@RequestBody AtualizacaoDadosClienteForm clienteForm) {
		Cliente cliente = clienteForm.atualizaSenha(id, clienteRepository);
		return ResponseEntity.ok(new ClienteDto(cliente));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
