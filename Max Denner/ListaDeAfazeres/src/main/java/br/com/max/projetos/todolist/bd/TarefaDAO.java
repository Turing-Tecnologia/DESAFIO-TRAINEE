package br.com.max.projetos.todolist.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.max.projetos.todolist.modelo.Tarefa;

public class TarefaDAO {
	private Connection connection;

	public TarefaDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public void adicionaTarefa(Tarefa tarefa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("call adicionaTarefa(?,?,?)");
		stmt.setString(1, tarefa.getTituloTarefa());
		stmt.setString(2, tarefa.getDescricaoTarefa());
		stmt.setInt(3, tarefa.getPrioridadeTarefa());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void atualizaTarefa(Tarefa tarefa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("call atualizaTarefa(?,?,?,?)");
		stmt.setLong(1, tarefa.getIdTarefa());
		stmt.setString(2, tarefa.getTituloTarefa());
		stmt.setString(3, tarefa.getDescricaoTarefa());
		stmt.setInt(4, tarefa.getPrioridadeTarefa());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void removeTarefa(long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("call removeTarefa(?)");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void marcarComoFinalizado(long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("call marcarComoFinalizado(?)");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Tarefa> getListaTarefas() throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		PreparedStatement stmt = connection.prepareStatement("call listaTarefasPendentes()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricaoTarefa(rs.getString("descricaoTarefa"));
			tarefa.setFinalizacaoTarefa(rs.getInt("finalizacaoTarefa"));
			tarefa.setIdTarefa(rs.getLong("idTarefa"));
			tarefa.setPrioridadeTarefa(rs.getInt("prioridadeTarefa"));
			tarefa.setTituloTarefa(rs.getString("tituloTarefa"));

			java.util.Date inicio = rs.getDate("dataInicioTarefa");
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(inicio);
			tarefa.setDataInicioTarefa(dataInicio);
			if (tarefa.isFinalizacaoTarefa() != 0) {
				java.util.Date finalizacao = rs.getDate("dataTerminoTarefa");
				Calendar termino = Calendar.getInstance();
				termino.setTime(finalizacao);
				tarefa.setDataTerminoTarefa(termino);
			}

			tarefas.add(tarefa);
		}

		rs.close();
		stmt.close();
		connection.close();

		return tarefas;
	}

	public List<Tarefa> getListaTarefasFinalizadas() throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		PreparedStatement stmt = connection.prepareStatement("call listaTarefasFinalizadas()");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricaoTarefa(rs.getString("descricaoTarefa"));
			tarefa.setFinalizacaoTarefa(rs.getInt("finalizacaoTarefa"));
			tarefa.setIdTarefa(rs.getLong("idTarefa"));
			tarefa.setPrioridadeTarefa(rs.getInt("prioridadeTarefa"));
			tarefa.setTituloTarefa(rs.getString("tituloTarefa"));

			java.util.Date inicio = rs.getDate("dataInicioTarefa");
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(inicio);
			tarefa.setDataInicioTarefa(dataInicio);
			if (tarefa.isFinalizacaoTarefa() != 0) {
				java.util.Date finalizacao = rs.getDate("dataTerminoTarefa");
				Calendar termino = Calendar.getInstance();
				termino.setTime(finalizacao);
				tarefa.setDataTerminoTarefa(termino);
			}

			tarefas.add(tarefa);
		}

		rs.close();
		stmt.close();
		connection.close();

		return tarefas;
	}
	
	public Tarefa getTarefaById(long id) throws SQLException {
		Tarefa tarefa = new Tarefa();
		PreparedStatement stmt = connection.prepareStatement("select * from tarefas where idTarefa = ?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			tarefa.setDescricaoTarefa(rs.getString("descricaoTarefa"));
			tarefa.setFinalizacaoTarefa(rs.getInt("finalizacaoTarefa"));
			tarefa.setIdTarefa(rs.getLong("idTarefa"));
			tarefa.setPrioridadeTarefa(rs.getInt("prioridadeTarefa"));
			tarefa.setTituloTarefa(rs.getString("tituloTarefa"));

			java.util.Date inicio = rs.getDate("dataInicioTarefa");
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(inicio);
			tarefa.setDataInicioTarefa(dataInicio);
			if (tarefa.isFinalizacaoTarefa() != 0) {
				java.util.Date finalizacao = rs.getDate("dataTerminoTarefa");
				Calendar termino = Calendar.getInstance();
				termino.setTime(finalizacao);
				tarefa.setDataTerminoTarefa(termino);
			}
		}
		rs.close();
		stmt.close();
		connection.close();

		return tarefa;
	}
}
