package com.turingtecnologia.leshto.todolist.model;

import java.sql.SQLException;
import java.util.Calendar;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;

public class Tarefa {
	public static final long ID_NULO = -1;

	private final long id;
	private final Calendar dataCriacao;

	private Calendar dataRealizacao;

	private String titulo;
	private String texto;

	public Tarefa(long id, Calendar dataCriacao) {
		this.id = id;
		this.dataCriacao = dataCriacao;
	}

	public Tarefa() {
		id = ID_NULO;
		dataCriacao = null;
	}

	public boolean realizado() {
		return dataRealizacao != null;
	}

	/** Ação de marcar tarefa como realizada.
	 * 
	 * Funciona de acordo com o checkbox "[ ] Minha tarefa"
	 *
	 * @throws SQLException 
	 */
	public void realizar() throws SQLException {
		TarefaDAO dao = new TarefaDAO();
		if (dataRealizacao == null) {
			dao.marca(this, true);
		}
		else {
			dao.marca(this, false);
		}
	}

	public long getId() {
		return id;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public Calendar getDataRealizacao() {
		return dataRealizacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setDataRealizacao(Calendar dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
}
