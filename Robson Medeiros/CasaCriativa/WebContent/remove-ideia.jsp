<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="br.com.casacriativa.modelo.*, 
				br.com.casacriativa.bd.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluindo</title>
</head>
<body>
	<%
	IdeiasDao dao = new IdeiasDao();
	String idString = request.getParameter("idIdeia");
	int idIdeia = Integer.parseInt(idString);
	Ideias ideia = new Ideias();
	ideia.setIdIdeia(idIdeia);
	dao.removeIdeia(ideia);
%>
<script>
        window.location.href='index.jsp';
    </script>
</body>
</html>