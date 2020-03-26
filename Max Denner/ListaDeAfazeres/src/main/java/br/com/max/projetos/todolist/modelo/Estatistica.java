package br.com.max.projetos.todolist.modelo;

public class Estatistica {
	private int tarefasPendentes;
	private int tarefasFinalizadasNoMes;
	private int tarefasFinalizadasNoAno;
	private int tarefasFinalizadasNoTotal;

	public int getTarefasPendentes() {
		return tarefasPendentes;
	}

	public void setTarefasPendentes(int tarefasPendentes) {
		this.tarefasPendentes = tarefasPendentes;
	}

	public int getTarefasFinalizadasNoMes() {
		return tarefasFinalizadasNoMes;
	}

	public void setTarefasFinalizadasNoMes(int tarefasFinalizadasNoMes) {
		this.tarefasFinalizadasNoMes = tarefasFinalizadasNoMes;
	}

	public int getTarefasFinalizadasNoAno() {
		return tarefasFinalizadasNoAno;
	}

	public void setTarefasFinalizadasNoAno(int tarefasFinalizadasNoAno) {
		this.tarefasFinalizadasNoAno = tarefasFinalizadasNoAno;
	}

	public int getTarefasFinalizadasNoTotal() {
		return tarefasFinalizadasNoTotal;
	}

	public void setTarefasFinalizadasNoTotal(int tarefasFinalizadasNoTotal) {
		this.tarefasFinalizadasNoTotal = tarefasFinalizadasNoTotal;
	}
}
