package br.com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.delivery.model.Cliente;

public class ClienteDto {
	private long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String endereco;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.endereco = cliente.getEndereco();
	}

	public ClienteDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
