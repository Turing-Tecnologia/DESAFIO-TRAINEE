package com.turingtecnologia.leshto.todolist.control.faz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Fazedor {
	public void fazendo(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
