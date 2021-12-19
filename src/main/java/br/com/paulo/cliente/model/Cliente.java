package br.com.paulo.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.primefaces.component.password.Password;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {
	
	@Column(length = 100, nullable = false)
	private String  nome;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 12, nullable = false)
	private String telefone;
	
	@Column(length = 8, nullable = false)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
	
	

	
	
}
