package com.turingtecnologia.leshto.todolist.control.faz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO;
import com.turingtecnologia.leshto.todolist.model.Tarefa;

public class CriaTarefa implements Fazedor {

	@Override
	public void fazendo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Tarefa tarefa = new Tarefa();

		tarefa.setTitulo(request.getParameter("titulo"));
		tarefa.setTexto(request.getParameter("texto"));

		TarefaDAO dao = new TarefaDAO();
		dao.cria(tarefa);

		response.sendRedirect("listar/tarefas.jsp");
	}

}
