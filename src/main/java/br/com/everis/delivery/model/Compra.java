package br.com.everis.delivery.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.com.everis.delivery.dto.CompraDto;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Pagamento formaDePagamento;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Produto> produto;

	public Compra(Long id, Cliente cliente, Pagamento formaDePagamento, List<Produto> produto) {
		this.id = id;
		this.cliente = cliente;
		this.formaDePagamento = formaDePagamento;
		this.produto = produto;

	}

	public Compra() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(Pagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public static List<CompraDto> converter(List<Compra> compras) {
		return compras.stream().map(CompraDto::new).collect(Collectors.toList());
	}

};