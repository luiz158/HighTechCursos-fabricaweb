package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection conn = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usuario) {		
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";		
		try (PreparedStatement ps = conn.prepareStatement(sql)){						
			// Substitui pelas ?'s no SQL
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());			
			//Executando o comando SQL no BD
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void alterar(Usuario usuario) {
		String sql = "UPDATE usuario SET nome=?, login=?, senha=? WHERE id=?";		
		try (PreparedStatement ps = conn.prepareStatement(sql)){						
			// Substitui pelas ?'s no SQL
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			//Executando o comando SQL no BD
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id=?";		
		try (PreparedStatement ps = conn.prepareStatement(sql)){						
			// Substitui pelas ?'s no SQL
			ps.setInt(1, usuario.getId());
			//Executando o comando SQL no BD
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}
	
	/**
	 * Busca de um regsitro no BD pelo número do Id do Usuário.
	 * @param id É um inteiro que representa o número do Id do Usuário a ser buscado.
	 * @return Um objeto Usuário quando encontra e nulo quando não.
	 */
	public Usuario buscarPorId(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//Posicionando o cursor no primeiro registro
			if(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				
				return usuario;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Realiza a busca de todos registros da tabela de usuários
	 * @return Uma lista de objetos Usuário contendo 0 elementos quando tiver registro
	 * ou n elementos quando tiver resultado
	 */
	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario ORDER BY id";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			//Posicionando o cursor no primeiro registro
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				//Adicionando usuário na lista
				lista.add(usuario);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
}
