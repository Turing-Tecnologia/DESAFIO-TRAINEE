package com.turingtecnologia.leshto.todolist.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.turingtecnologia.leshto.todolist.db.ConnectionFactory;
import com.turingtecnologia.leshto.todolist.model.Tarefa;
import com.turingtecnologia.leshto.todolist.utils.Constantes;

public class TarefaDAO {
	public void cria(Tarefa tarefa) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "INSERT INTO tarefas(titulo, texto) VALUES(?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, tarefa.getTitulo());
		stmt.setString(2, tarefa.getTexto());
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}

	public Tarefa le(long id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tarefas WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Tarefa tarefa = null;

		if (rs.next()) {
			tarefa = resultSetParaTarefa(rs);
		}

		rs.close();
		stmt.close();
		conn.close();

		return tarefa;
	}

	public ArrayList<Tarefa> listarTudo() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tarefas ORDER BY data_criacao DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

		while (rs.next()) {
			tarefas.add(resultSetParaTarefa(rs));
		}

		rs.close();
		stmt.close();
		conn.close();

		return tarefas;
	}

	public ArrayList<Tarefa> listar(boolean pendentes) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tarefas WHERE data_realizacao IS" +
				(pendentes ? " " : " NOT ") +
				"NULL ORDER BY data_criacao DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

		while (rs.next()) {
			tarefas.add(resultSetParaTarefa(rs));
		}

		rs.close();
		stmt.close();
		conn.close();

		return tarefas;
	}

	private Tarefa resultSetParaTarefa(ResultSet rs) throws SQLException {
		Tarefa tarefa;

		// 1. LEITURA DE ATRIBUTOS SOMENTE LEITURA
		long id = rs.getLong("id");

		Calendar dataCriacao = Calendar.getInstance();
		dataCriacao.setTime(rs.getDate("data_criacao"));

		// 2. CONVERSÃO DE ATRIBUTOS "NULÁVEIS"
		Calendar dataRealizacao = null;

		Date sqlDateRealizacao = rs.getDate("data_realizacao");
		if (sqlDateRealizacao != null) {
			dataRealizacao = Calendar.getInstance();
			dataRealizacao.setTime(sqlDateRealizacao);
		}

		// 3. CONSTRUÇÃO DO OBJETO
		tarefa = new Tarefa(id, dataCriacao);
		tarefa.setTitulo(rs.getString("titulo"));
		tarefa.setTexto(rs.getString("texto"));
		tarefa.setDataRealizacao(dataRealizacao);

		return tarefa;
	}

	public void atualiza(Tarefa tarefa) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "UPDATE tarefas SET titulo=?, texto=? WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, tarefa.getTitulo());
		stmt.setString(2, tarefa.getTexto());

		stmt.setLong(3, tarefa.getId());
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}

	public void remove(long id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "DELETE FROM tarefas WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}

	public void marca(Tarefa tarefa, boolean realizado) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "UPDATE tarefas SET data_realizacao=" +
				(realizado ? "CURRENT_TIMESTAMP" : "NULL") +
				" WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setLong(1, tarefa.getId());
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}

	public void removeTUDO() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "DELETE FROM tarefas";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}
}
