package br.com.paulo.cliente.model;



import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.swing.text.MaskFormatter;

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
	@Transient
	private String telefoneFormatado;

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

	public String getTelefoneFormatado() {
		String tel = this.telefoneFormatado;	
		if(this.telefone != "" && this.telefone != null) {
			MaskFormatter maskFormatter = null;
			try {
				maskFormatter = new MaskFormatter("(##)#####-####");
				maskFormatter.setValueContainsLiteralCharacters(false);
				tel = maskFormatter.valueToString(this.telefone) ; 
			} catch (ParseException e) {				
				e.printStackTrace();
			}	
		}		
		return tel;
	}

	public void setTelefoneFormatado(String telefoneFormatado) {		
		this.telefoneFormatado = telefoneFormatado;
		this.telefone = telefoneFormatado.replace("(", "").replace(")", "").replace("-", "");
	}
	

	
	
	
	
	

	
	
}
