package br.com.paulo.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Transient
	private String senhaSemCriptografia;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private String ativo;
	
	@Column(nullable = false)
	private String cpf;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}
	
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public String getTipo() {
		return tipo;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipo == "A") {
			tipoFormatado = "Administrador";
		} 
		
		return tipoFormatado;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAtivo() {
		return ativo;
	}
	
	@Transient
	public String getAtivoFormatado(){
		String ativoFormatado = "Não";
		
		if(ativo.equals("1")){
			ativoFormatado = "Sim";
		}
		
		return ativoFormatado;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	
}