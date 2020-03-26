package br.com.casacriativa.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.casacriativa.modelo.Ideias;

public class IdeiasDao {
	
	private Connection connection;
	
	public IdeiasDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaIdeia(Ideias ideia) {
		String sql = "insert into ideias "
				+ "(nomeIdeia, categoriaIdeia, descricaoIdeia)"
				+ " values (?,?,?)";

		try {
			
			// preparedStatement para inserção de dados
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, ideia.getNomeIdeia());
			stmt.setString(2, ideia.getCategoriaIdeia());
			stmt.setString(3, ideia.getDescricaoIdeia());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Ideias> getListaIdeias() {
		try {
			List<Ideias> ideias = new ArrayList<Ideias>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from ideias");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto ideia

				Ideias ideia = new Ideias();
				ideia.setIdIdeia(rs.getInt("idIdeia"));
				ideia.setNomeIdeia(rs.getString("nomeIdeia"));
				ideia.setCategoriaIdeia(rs.getString("categoriaIdeia"));
				ideia.setDescricaoIdeia(rs.getString("descricaoIdeia"));
			

				ideias.add(ideia);
			}
			rs.close();
			stmt.close();
			return ideias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removeIdeia(Ideias ideia) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("delete from ideias where idIdeia=?");
			stmt.setLong(1, ideia.getIdIdeia());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Ideias getById(String idIdeia) {
		Ideias ideia = new Ideias();

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM ideias WHERE idIdeia=?");
			stmt.setLong(1, Long.parseLong(idIdeia));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ideia.setIdIdeia(rs.getInt("idIdeia"));
				ideia.setNomeIdeia(rs.getString("nomeIdeia"));
				ideia.setCategoriaIdeia(rs.getString("categoriaIdeia"));
				ideia.setDescricaoIdeia(rs.getString("descricaoIdeia"));

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ideia;
	}
	public void alteraIdeia(Ideias ideia) {
		String sql = "update ideias set nomeIdeia=?, categoriaIdeia=?, descricaoIdeia=? where idIdeia=?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, ideia.getNomeIdeia());
			stmt.setString(2, ideia.getCategoriaIdeia());
			stmt.setString(3, ideia.getDescricaoIdeia());

			stmt.setInt(4, ideia.getIdIdeia());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
