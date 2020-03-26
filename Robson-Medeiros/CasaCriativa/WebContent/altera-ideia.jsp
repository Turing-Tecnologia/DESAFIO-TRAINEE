<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page
	import="java.util.*,
	br.com.casacriativa.bd.*,
	br.com.casacriativa.modelo.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auterando ideia</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600,700,900&display=swap" rel="stylesheet">
        <Link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<%
		IdeiasDao dao = new IdeiasDao();
		Ideias ideia = dao.getById(request.getParameter("idIdeia"));
	%>

    <div id="modal" class="">
        <div class="content">
            <h1>Alterando Ideia</h1>
            
            <form action="altera-ideia">
           	
                <div class="input-wapper">
                	<input hidden type="text" name="idIdeia" value="<%=ideia.getIdIdeia()%>">
                    <label for="title">Titulo da Ideia</label>
                    <input type="text" name="nomeIdeia" value="<%=ideia.getNomeIdeia()%>">
                </div>
                <div class="input-wapper">
                    <label  for="category"> Categoria da Ideia</label>
                    <input type="text"  name="categoriaIdeia" value="<%=ideia.getCategoriaIdeia()%>">
                </div>
                <div class="input-wapper">
                    <label for="image">Escolher imagem</label>
                    <input onclick="onImage()" type="text" name="nomeProduto" value="">
                </div>
                <div class="input-wapper">
                    <label for="description">Descrição</label>
                    <textarea name="descricaoIdeia" cols="30" rows="10"><%=ideia.getDescricaoIdeia()%></textarea>        
                </div>
                <a onclick="onIndex()" href="#">Voltar</a>
                <button>Salvar</button>
			</form>
        </div>
    </div>
         <script src="scripts/script.js"></script>
</body>
</html>