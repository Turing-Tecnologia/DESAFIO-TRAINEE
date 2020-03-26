package br.com.max.projetos.todolist.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.max.projetos.todolist.bd.TarefaDAO;
import br.com.max.projetos.todolist.modelo.Tarefa;

@Controller
public class TarefaController {
	@RequestMapping(value = "cadastrar-tarefa", method = RequestMethod.POST)
	public String adicionaTarefa(Tarefa tarefa) {
		try {
			new TarefaDAO().adicionaTarefa(tarefa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:inicio";
	}

	@RequestMapping(value = "finalizar-tarefa")
	public String finalizarTarefa(long id) {
		try {
			new TarefaDAO().marcarComoFinalizado(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "excluir-tarefa")
	public String excluirTarefa(long id) {
		try {
			new TarefaDAO().removeTarefa(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "remover-tarefa")
	public String removerTarefa(long id) {
		try {
			new TarefaDAO().removeTarefa(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:tarefas-finalizadas";
	}

	@RequestMapping(value = "exibir-tarefa")
	public String exibirTarefa(long id, Model model) {
		try {
			model.addAttribute("tarefa", new TarefaDAO().getTarefaById(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "detalhes-tarefa";
	}
	
	@RequestMapping(value = "atualizar-tarefa", method = RequestMethod.POST)
	public String atualizarTarefa(Tarefa tarefa) {
		try {
			new TarefaDAO().atualizaTarefa(tarefa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:inicio";
	}
	
	@RequestMapping(value = "tarefas-finalizadas")
	public String listarTarefasFinalizadas(Model model) {
		try {
			List<Tarefa> tarefas = new TarefaDAO().getListaTarefasFinalizadas();
			model.addAttribute("tarefas", tarefas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "tarefas-finalizadas";
	}
}
