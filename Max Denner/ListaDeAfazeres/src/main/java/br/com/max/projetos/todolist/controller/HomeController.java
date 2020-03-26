package br.com.max.projetos.todolist.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.max.projetos.todolist.bd.TarefaDAO;
import br.com.max.projetos.todolist.modelo.Tarefa;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String telaInicial(Model model) {
		try {
			List<Tarefa> tarefas = new TarefaDAO().getListaTarefas();
			model.addAttribute("tarefas", tarefas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "tela-inicial";
	}
	
	@RequestMapping(value="inicio")
	public String inicio() {
		return "redirect:/";
	}
}
