package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {
	
	public String inserir(Categoria categoria) {		
		String retorno = "falha";
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			stmt.execute("INSERT INTO categoria (nome) VALUES ('"+categoria.getNome() + "')");
			retorno = "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}		
		return retorno;
	}
	
	public List<Categoria> listar(){
		List<Categoria> categorias = new ArrayList<Categoria>();
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from categoria");
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setCodigo(rs.getInt("codigo"));
				categoria.setNome(rs.getString("nome"));
				categorias.add(categoria);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}
		return categorias;
	}

    public Categoria porCodigo(Integer id) throws Exception {
        Conexao conn = new Conexao();
		Categoria categoria = new Categoria();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from categoria where codigo = " + id);
			if (rs.next()) {
				categoria.setCodigo(rs.getInt("codigo"));
				categoria.setNome(rs.getString("nome"));
		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.fecharConexao();
		}
		return categoria;
    }

    public void editar(Categoria categoria) throws Exception {
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			final var update = "update categoria set nome = '" + categoria.getNome() + "' where codigo = " + categoria.getCodigo();
			stmt.executeUpdate(update);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.fecharConexao();
		}
    }

	public void deletar(Integer codigo) throws Exception {
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			final var update = "delete from categoria where codigo = " + codigo;
			stmt.executeUpdate(update);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.fecharConexao();
		}

	}
}
