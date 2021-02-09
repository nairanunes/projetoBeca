package br.com.everis.delivery.form;

import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.ProdutoRepository;

public class ProdutoForm {
	private long id;
	private String nome;
	private double valor;
	private int quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto atualizaValor(Long id, ProdutoRepository produtoRepository) {

		Produto produto = produtoRepository.getOne(id);
		produto.setValor(valor);
		return produto;
	}

	public Produto converter() {

		return new Produto(id, nome, valor, quantidade);
	}
}
