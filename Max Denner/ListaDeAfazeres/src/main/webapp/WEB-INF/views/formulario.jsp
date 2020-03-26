<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="formulario" method="post" action="cadastrar-tarefa">
                     <fieldset id="cadastrarOuEscolher">
                     		<div class="row">
                        	<div class="col-md-12">
                              <div class="form-group">
                                <a>                                 	
                                	<button type="button" id="yes" onclick="cadastrar();" class="form-control btn btn-info"><b>Cadastrar nova tarefa &nbsp; <i class="now-ui-icons ui-1_simple-add"></i></b></button>
                              	</a>
                              </div>
                           </div>
                           </div>
                     	</fieldset>
                        <fieldset id = "cadastrarTarefa" hidden="true">
                           <legend>Informações da Tarefa</legend>
                           <div class="row">
                              <div class="col-md-8 pr-1">
                                 <div class="form-group">
                                    <label for="titulo">Título da Tarefa</label>
                                    <input type="text"  id="titulo" name="tituloTarefa" class="form-control" placeholder="Ex.: Lavar a louça">
                                 </div>
                              </div>
                              <div class="col-md-4 pl-1">
                                 <div class="form-group">
                                    <label for="prioridade">Prioridade</label>
                                    <select name="prioridadeTarefa" id="prioridade" class="form-control">
                                       <option value="3">Baixa</option>
                                       <option value="2">Média</option>
                                       <option value="1">Alta</option>
                                    </select>
                                 </div>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-md-12 pr-1">
                                 	<div class="form-group">
                                 		<label for="descricao">Descrição da tarefa</label>
                                 		<textarea rows="4" cols="80" class="form-control" name="descricaoTarefa" id="descricao" placeholder="Ex.: Uma tarefa muito importante!"></textarea>
                                 	</div>
                              </div>
                           </div>
                        <div class="row">
                           <div class="col-md-6">
                              	<div class="form-group">
                                	<button type="button" class="btn btn-primary form-control" onclick="cancelar();"><i class="now-ui-icons ui-1_simple-remove"></i>&nbsp; Cancelar
                             	</button>
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <button type="submit" class="form-control btn btn-success">Cadastrar Tarefa&nbsp;<i class="now-ui-icons ui-1_check"></i></button>
                              </div>
                           </div>
                        </div>
                        </fieldset>
                     </form>
                  
</body>
</html>