package com.turingtecnologia.leshto.todolist.control.faz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;
import com.turingtecnologia.leshto.todolist.model.Tarefa;

public class MarcaTarefa implements Fazedor {

	@Override
	public void fazendo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long id = Long.parseLong(request.getParameter("id"));

		TarefaDAO dao = new TarefaDAO();
		Tarefa tarefa = dao.le(id);
		tarefa.realizar();

		response.sendRedirect("listar/tarefa.jsp?id=" + id);
	}

}
