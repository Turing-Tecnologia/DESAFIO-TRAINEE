package br.com.max.projetos.todolist.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstatisticaDAO {
	Connection connection;

	public EstatisticaDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public int getQtdTarefasPendentes() throws SQLException {
		int resultado = 0;
		PreparedStatement stmt = connection.prepareStatement("call getQtdTarefasPendentes()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resultado = rs.getInt(1);
		}
		return resultado;
	}

	
	public int getQtdTarefasNoMes() throws SQLException {
		int resultado = 0;
		PreparedStatement stmt = connection.prepareStatement("call getQtdTarefasNoMes()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resultado = rs.getInt(1);
		}
		return resultado;
	}
	
	public int getQtdTarefasNoAno() throws SQLException {
		int resultado = 0;
		PreparedStatement stmt = connection.prepareStatement("call getQtdTarefasNoAno()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resultado = rs.getInt(1);
		}
		return resultado;
	}
	
	public int getQtdTarefasNoTotal() throws SQLException {
		int resultado = 0;
		PreparedStatement stmt = connection.prepareStatement("call getQtdTarefasNoTotal()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resultado = rs.getInt(1);
		}
		return resultado;
	}
}
