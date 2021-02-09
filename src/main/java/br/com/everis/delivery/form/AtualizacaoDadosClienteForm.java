package br.com.everis.delivery.form;

import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.repository.ClienteRepository;

public class AtualizacaoDadosClienteForm {
	private String nome;
	private String cpf;
	private String endereco;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente atualizaDadosClientes(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		return cliente;
	}

	public Cliente atualizaSenha(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setSenha(senha);
		return cliente;
	}

}
