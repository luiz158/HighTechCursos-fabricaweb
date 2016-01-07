package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
