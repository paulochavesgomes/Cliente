package br.com.paulo.cliente.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.paulo.cliente.dao.UsuarioDAO;
import br.com.paulo.cliente.model.Usuario;



@ManagedBean
@SessionScoped
public class AutentificacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		
	}

	public void autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuario.getCpf(), usuario.getSenha());
			
			if(usuarioLogado == null){
				Messages.addGlobalError("CPF e/ou senha incorretos");
				return;
			}
			
			Faces.redirect("./pages/clientes.xhtml");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
	public boolean temPermissoes(List<String> permissoes){		
		for(String permissao : permissoes){
			if(usuarioLogado.getTipo() == permissao){
				return true;
			}
		}
		
		return false;
	}
}
