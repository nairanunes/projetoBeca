package br.com.everis.delivery.dto;

import java.util.List;

import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Compra;
import br.com.everis.delivery.model.Pagamento;
import br.com.everis.delivery.model.Produto;

public class CompraDto {
	private long id;
	private Cliente cliente;
	private Pagamento formaDePagamento;
	private List<Produto> produto;

	public CompraDto(Compra compra) {
		this.id = compra.getId();
		this.cliente = compra.getCliente();
		this.formaDePagamento = compra.getFormaDePagamento();
		this.produto = compra.getProduto();
	}

	public CompraDto() {

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

}
