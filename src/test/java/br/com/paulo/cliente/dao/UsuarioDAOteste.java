package br.com.paulo.cliente.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import br.com.paulo.cliente.model.Usuario;

public class UsuarioDAOteste {
	
	//@Test
	//@Ignore
	public void usuario() {
		Usuario Usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario = dao.buscar(new Long(1));
		List<Usuario> lista  = dao.listar();
		System.out.println(Usuario.getCpf());
		for (Usuario vo : lista) {
			System.out.println("Nome: " + vo.getCpf());
			
		}
	}
	@Test
	//@Ignore
	public void salvar() {
		Usuario u = new Usuario();
		u.setAtivo("1");
		u.setCpf("93377357092");
		u.setTipo("A");
		UsuarioDAO dao = new UsuarioDAO();		
		SimpleHash hash = new SimpleHash("md5", "qwerty");
		u.setSenha(hash.toHex());
		dao.merge(u);
		
	}

}
