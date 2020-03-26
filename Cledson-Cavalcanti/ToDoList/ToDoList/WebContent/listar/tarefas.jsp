<%@page import="com.turingtecnologia.leshto.todolist.utils.Utilidades"%>
<%@page import="com.turingtecnologia.leshto.todolist.utils.Constantes"%>
<%@page import="com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO"%>
<%@page import="com.turingtecnologia.leshto.todolist.model.Tarefa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String estado = request.getParameter("estado");
	TarefaDAO dao = new TarefaDAO();
	ArrayList<Tarefa> tarefas = null;
	if (estado == null)
		tarefas = dao.listarTudo();
	else {
		tarefas = dao.listar(estado.equals("pendentes"));
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ToDo: minhas tarefas</title>
</head>

<body>

  <h1>ToDoList - a minha lista de tarefas</h1>
  
  <h2>[<a href="javascript:history.back()">&lt; Voltar</a>] Minhas tarefas</h2>

<%
	if (tarefas.isEmpty()) {
		out.write("<h2>Nenhuma tarefa.</h2>");
	}
	else {
%>
  		<button onclick="removerTudo();">sudo rm -rf /*</button>

 <%
  		for (int i=0; i < tarefas.size(); i++) {
  			Tarefa tarefa = tarefas.get(i);
  			String id = "" + tarefa.getId();
  			String titulo = tarefa.getTitulo();
  		
 %>
 			<p><input type="checkbox" name="marcar-realizado" <%= tarefa.realizado() ? "checked" : "" %> onchange="marca(<%= id %>);"><a href="tarefa.jsp?id=<%= id %>"><%= titulo %></a></p>
<%
  		}
	}
%>

  <br><br>

  <h3>ToDoList - a minha lista de tarefas by Leshto (c) 2020</h3>

  <script src="../scripts/tarefas.js"></script>
</body>
</html>