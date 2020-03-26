<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>ToDo: criar tarefa</title>
</head>

<body>

  <h1>ToDoList - a minha lista de tarefas</h1>
  
  <h2>[<a href="javascript:history.back()">&lt; Voltar</a>] Criar tarefa</h2>

  <form action="../acao?fazer=CriaTarefa" method="POST">
    <h3>Titulo</h3>
    <input type="text" name="titulo" maxlength="50">
    <br>
  
    <h3>Texto</h3>
    <textarea
      name="texto"></textarea>
    
    <br><br>
    <button>Adicionar</button>
  </form>

  <br><br>

  <h3>ToDoList - a minha lista de tarefas by Leshto (c) 2020</h3>

</body>
</html>