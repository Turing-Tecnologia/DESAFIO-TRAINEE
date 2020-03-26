package com.turingtecnologia.leshto.todolist.control.faz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;

public class RemoveTarefa implements Fazedor {

	@Override
	public void fazendo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		
		TarefaDAO dao = new TarefaDAO();
		dao.remove(id);
		
		response.sendRedirect("listar/tarefas.jsp");
	}

}
