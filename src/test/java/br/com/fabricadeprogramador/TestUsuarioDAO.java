package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testExcluir();
	}

	public static void testCadastrar() {
		// Criando o Usu�rio
		Usuario usuario = new Usuario();
		usuario.setNome("J�oz�o");
		usuario.setLogin("jzao");
		usuario.setSenha("123");

		// Inserindo Usu�rio no Banco de Dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);

		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testAlterar() {
		//Alterar Usu�rio
		Usuario usuario = new Usuario();
		usuario.setId(3);
		usuario.setNome("J�oz�o da Silva");
		usuario.setLogin("jzaoss");
		usuario.setSenha("12345678");
		
		//Alterando Usu�rio no BD
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testExcluir() {
		//Alterar Usu�rio
		Usuario usuario = new Usuario();
		usuario.setId(3);
		
		//Alterando Usu�rio no BD
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		
		System.out.println("Exclu�do com sucesso!");
	}
	
}
