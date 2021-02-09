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

import br.com.everis.delivery.dto.ProdutoDto;
import br.com.everis.delivery.form.ProdutoForm;
import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
		Produto produto = produtoForm.converter();
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	@GetMapping
	@Transactional
	public List<ProdutoDto> produtos() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDto.converter(produtos);
	}

	@GetMapping("/{id}")
	@Transactional
	public ProdutoDto detalhar(@PathVariable Long id) {
		Produto produto = produtoRepository.getOne(id);
		return new ProdutoDto(produto);

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizarPreco(@PathVariable Long id, @RequestBody ProdutoForm produtoForm) {
		Produto produto = produtoForm.atualizaValor(id, produtoRepository);
		return ResponseEntity.ok(new ProdutoDto(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return ResponseEntity.ok().build();

	}

}
