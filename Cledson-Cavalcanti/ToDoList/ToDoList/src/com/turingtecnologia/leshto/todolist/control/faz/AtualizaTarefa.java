package com.turingtecnologia.leshto.todolist.control.faz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;
import com.turingtecnologia.leshto.todolist.model.Tarefa;

public class AtualizaTarefa implements Fazedor {

	@Override
	public void fazendo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");

		TarefaDAO dao = new TarefaDAO();
		Tarefa tarefa = dao.le(id);

		tarefa.setTitulo(titulo);
		tarefa.setTexto(texto);

		dao.atualiza(tarefa);

		response.sendRedirect("listar/tarefa.jsp?id=" + id);
	}

}
