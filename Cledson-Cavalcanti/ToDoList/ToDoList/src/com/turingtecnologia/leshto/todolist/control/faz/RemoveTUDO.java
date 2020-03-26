package com.turingtecnologia.leshto.todolist.control.faz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;

public class RemoveTUDO implements Fazedor {

	@Override
	public void fazendo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TarefaDAO dao = new TarefaDAO();
		dao.removeTUDO();

		response.sendRedirect("index.html");
	}

}
