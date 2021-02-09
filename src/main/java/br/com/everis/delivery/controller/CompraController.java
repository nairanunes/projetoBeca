package br.com.everis.delivery.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.delivery.dto.CompraDto;
import br.com.everis.delivery.form.CompraForm;
import br.com.everis.delivery.model.Compra;

import br.com.everis.delivery.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<CompraDto> comprar(@RequestBody CompraForm compraForm, UriComponentsBuilder uriBuilder) {
		Compra compra = compraForm.converter();
		compraRepository.save(compra);

		URI uri = uriBuilder.path("/compras/{id}").buildAndExpand(compra.getId()).toUri();
		return ResponseEntity.created(uri).body(new CompraDto(compra));
	}

	@GetMapping
	@Transactional
	public List<CompraDto> compras() {
		List<Compra> compras = compraRepository.findAll();
		return Compra.converter(compras);
	}

}
