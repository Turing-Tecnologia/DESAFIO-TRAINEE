<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page
	import="java.util.*,
	br.com.casacriativa.bd.*,
	br.com.casacriativa.modelo.*"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Casa Criativa</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600,700,900&display=swap" rel="stylesheet">
        <Link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div id="container">
            <section id="intro">
                <header>
                    <img src="imagens/27pdZLL.png" alt="Imagens da casacriativa">
                </header>
                <main>
                    <p>
                        Ficar em casa em períodos longos, não deve ser nada fácil.
                    </p>
                    <p>
                        Iremos catalogar ideias, <strong> Brincadeiras, jogos, filmes, livros, cursos, dicas </strong> e tudo que for necessário para tornar esse momento mais interessante.
                    </p>
                    <p>
                        Comece clicando em ver ideias para ver as  ideias cadastradas e contribua adicioando a sua ideia.
                    </p>
                </main>
                <section id="buttons">
                    <button onclick="onOff()" class="fat" >+ Adicionar ideias</button>
                </section>

                <footer> Robson Medeiros - <a href="https://github.com/robsonmedeiross">GitHub</a></footer>
            </section>
            <section id="last-idea">
            	 <%
               		IdeiasDao dao = new IdeiasDao();
    				List<Ideias> ideias = dao.getListaIdeias();
    				for (Ideias ideia : ideias) {
				%>
                <div class="idea">
                    <img 
                        src="https://image.flaticon.com/icons/svg/2729/2729007.svg" 
                        alt="Imagem de curso de programação"/>
                    <div class="content">
                    	<p hidden ><%=ideia.getIdIdeia()%></p>
                        <h3><%=ideia.getNomeIdeia()%></h3>
                        <p><%=ideia.getCategoriaIdeia()%></p>
                        <p hidden ><%=ideia.getIdIdeia()%></p>
                        <div class="description">
                        	<%=ideia.getDescricaoIdeia()%>
                        </div>
                        <div id="tagA">
                        <a href="altera-ideia.jsp?idIdeia=<%=ideia.getIdIdeia()%>">Alterar Ideia</a>
                        <a href="remove-ideia.jsp?idIdeia=<%=ideia.getIdIdeia()%>">Excluir Ideia</a>
                        <a href="#">Visitar site</a>
                        </div>
                    </div>
				</div>
                <%
					}
				%>
            </section>
        </div>

        <!-- Modal Adiciona -->

        <div id="modal" class="hide">
            <div class="content">
                <h1>Nova Ideia</h1>
                <form action="adiciona-ideia">
                    <div class="input-wapper">
                        <label for="title">Titulo da Ideia</label>
                        <input type="text" name="nomeIdeia" value="">
                    </div>
                    <div class="input-wapper">
                        <label  for="category"> Categoria da Ideia</label>
                        <input type="text"  name="categoriaIdeia" value="">
                    </div>
                    <div class="input-wapper">
                        <label for="image">Escolher imagem</label>
                        <input onclick="onImage()" type="text" name="nomeProduto" value="">
                    </div>
                    <div class="input-wapper">
                        <label for="description">Descrição</label>
                        <textarea name="descricaoIdeia" cols="30" rows="10"></textarea>        
                    </div>
                    <a onclick="onOff()" href="#">Voltar</a>
                    <button onclick="onAdd()">Salvar</button> 
				</form>
            </div>
        </div>

       <script src="scripts/script.js"></script>
    </body>
</html>