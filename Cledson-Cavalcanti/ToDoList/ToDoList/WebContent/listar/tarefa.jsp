<%@page import="com.turingtecnologia.leshto.todolist.utils.Utilidades"%>
<%@page import="com.turingtecnologia.leshto.todolist.model.Tarefa"%>
<%@page import="com.turingtecnologia.leshto.todolist.db.dao.TarefaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String strId = request.getParameter("id");
	long id = Long.parseLong(strId);
	TarefaDAO dao = new TarefaDAO();
	Tarefa tarefa = dao.le(id);
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>ToDo: <%= tarefa.getTitulo() %></title>
</head>

<body>

  <h1>ToDoList - a minha lista de tarefas</h1>

  <form action="../acao?fazer=AtualizaTarefa" method="POST">
    <input type="hidden" name="id" value="<%= strId %>">

    <h2><input id="marcador" type="checkbox" name="marcar-realizado" <%= tarefa.realizado() ? "checked" : "" %> onchange="marca(<%= strId %>);">
    <input class="editaveis" type="text" name="titulo" value="<%= tarefa.getTitulo() %>" disabled></h2>
    
    <p>Concluído em: <%= tarefa.realizado() ? Utilidades.CalendarParaStringBR(tarefa.getDataRealizacao()) : "NUNCA" %></p>

    <textarea class="editaveis" id="input-texto" name="texto" disabled><%= tarefa.getTexto().replace("<", "&lt;") %></textarea>
    <br><br>

    <button id="botao-inteligente" type="button" onclick="editar();">Editar</button>
    <button type="button" onclick="remover(<%= strId %>);">Excluir tarefa</button>
  </form>

  <br><br>
  <a href="javascript:history.back()"><button>Voltar</button></a>

  <h3>ToDoList - a minha lista de tarefas by Leshto (c) 2020</h3>

  <script src="../scripts/tarefas.js"></script>
</body>
</html>