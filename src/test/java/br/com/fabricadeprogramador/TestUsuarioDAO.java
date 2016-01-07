package br.com.fabricadeprogramador;

import java.util.Iterator;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testAutenticar();
	}

	private static void testAutenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("jao");
		usuario.setSenha("123");
		
		Usuario uRetorno = usuarioDAO.autenticar(usuario);
		System.out.println(uRetorno);		
	}

	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(4);
		System.out.println(usuario);
	}

	private static void testBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for (Usuario u : lista) {
			System.out.println(u);
		}
	}
	
	public static void testCadastrar() {
		// Criando o Usuário
		Usuario usuario = new Usuario();
		usuario.setNome("Jãozão");
		usuario.setLogin("jzao");
		usuario.setSenha("123");

		// Inserindo Usuário no Banco de Dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);

		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testAlterar() {
		//Alterar Usuário
		Usuario usuario = new Usuario();
		usuario.setId(3);
		usuario.setNome("Jãozão da Silva");
		usuario.setLogin("jzaoss");
		usuario.setSenha("12345678");
		
		//Alterando Usuário no BD
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testExcluir() {
		//Alterar Usuário
		Usuario usuario = new Usuario();
		usuario.setId(3);
		
		//Alterando Usuário no BD
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		
		System.out.println("Excluído com sucesso!");
	}
	
	public static void testSalvar() {
		Usuario usuario = new Usuario();
		// usuario.setId(1);
		usuario.setNome("Marcelo");
		usuario.setLogin("celo");
		usuario.setSenha("123");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Salvo com sucesso!");
	}
}
