package br.com.paulo.cliente.dao;

import java.util.List;

import com.google.protobuf.TextFormat.ParseException;

import br.com.paulo.cliente.model.Cliente;

public class ClienteDAOTest {
	//@Test
	//@Ignore
	public void salvar() throws ParseException {
		Cliente cliente = new Cliente();
		cliente.setNome("paulo");
		cliente.setEmail("paulo@gmail.com");
		cliente.setSenha("qwerty");
		cliente.setTelefone("212121211");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso.");
	}
	//@Test
	//@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.listar();
		for (Cliente vo : lista) {
			System.out.println("Nome: " + vo.getNome());
			System.out.println("Email: " + vo.getEmail());
			System.out.println("Senha: " + vo.getSenha());
			System.out.println("Telefone: " + vo.getTelefone());
		}
	}
	

}