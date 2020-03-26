package br.com.max.projetos.todolist.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.max.projetos.todolist.bd.EstatisticaDAO;
import br.com.max.projetos.todolist.modelo.Estatistica;

@Controller
public class EstaticasController {
	@RequestMapping("exibir-estatisticas")
	public String exibeEstatisticas(Model model) {
		Estatistica estatistica = new Estatistica();
		try {
			estatistica.setTarefasFinalizadasNoAno(new EstatisticaDAO().getQtdTarefasNoAno());
			estatistica.setTarefasFinalizadasNoMes(new EstatisticaDAO().getQtdTarefasNoMes());
			estatistica.setTarefasFinalizadasNoTotal(new EstatisticaDAO().getQtdTarefasNoTotal());
			estatistica.setTarefasPendentes(new EstatisticaDAO().getQtdTarefasPendentes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("estatistica", estatistica);
		return "estatisticas";
	}
}
