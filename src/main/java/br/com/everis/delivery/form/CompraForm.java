package br.com.everis.delivery.form;

import java.util.List;

import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Compra;
import br.com.everis.delivery.model.Pagamento;
import br.com.everis.delivery.model.Produto;

public class CompraForm {
	private long id;
	private Cliente cliente;
	private Pagamento formaDePagamento;
	private List<Produto> produto;

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

	public void setProdutos(List<Produto> produto) {
		this.produto = produto;
	}

	public Compra converter() {
		return new Compra(id, cliente, formaDePagamento, produto);

	}

}
