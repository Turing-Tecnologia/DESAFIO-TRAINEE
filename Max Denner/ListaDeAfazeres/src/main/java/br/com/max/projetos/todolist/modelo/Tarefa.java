package br.com.max.projetos.todolist.modelo;

import java.util.Calendar;

public class Tarefa {
	private long idTarefa;
	private String tituloTarefa;
	private String descricaoTarefa;
	private int finalizacaoTarefa;
	private int prioridadeTarefa;
	private Calendar dataInicioTarefa;
	private Calendar dataTerminoTarefa;

	public String getPrioridadeNome() {
		if (prioridadeTarefa == 1) {
			return "Alta";
		} else if (prioridadeTarefa == 2) {
			return "Média";
		} else {
			return "Baixa";
		}

	}

	public long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getTituloTarefa() {
		return tituloTarefa;
	}

	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public int isFinalizacaoTarefa() {
		return finalizacaoTarefa;
	}

	public void setFinalizacaoTarefa(int finalizacaoTarefa) {
		this.finalizacaoTarefa = finalizacaoTarefa;
	}

	public int getPrioridadeTarefa() {
		return prioridadeTarefa;
	}

	public void setPrioridadeTarefa(int prioridadeTarefa) {
		this.prioridadeTarefa = prioridadeTarefa;
	}

	public Calendar getDataInicioTarefa() {
		return dataInicioTarefa;
	}

	public void setDataInicioTarefa(Calendar dataInicioTarefa) {
		this.dataInicioTarefa = dataInicioTarefa;
	}

	public Calendar getDataTerminoTarefa() {
		return dataTerminoTarefa;
	}

	public void setDataTerminoTarefa(Calendar dataTerminoTarefa) {
		this.dataTerminoTarefa = dataTerminoTarefa;
	}
}
