function marca(id) {
	window.location.href = "../acao?fazer=MarcaTarefa&id=" + id;
}

function editar() {
	var marcador = document.getElementById("marcador");
	var editaveis = document.getElementsByClassName("editaveis");
	var botao_inteligente = document.getElementById("botao-inteligente");
	
	marcador.outerHTML = marcador.outerHTML.replace('>', "disabled>");
	
	for (var i=0; i < editaveis.length; i++) {
		editaveis[i].outerHTML = editaveis[i].outerHTML.replace('disabled', '');
	}
	
	botao_inteligente.outerHTML = "<button>Salvar</button>";
}

function remover(id) {
	var yes = confirm("Deseja excluir mesmo a tarefa?");
	if (yes == true)
		window.location.href = "../acao?fazer=RemoveTarefa&id=" + id;
}

function removerTudo(id) {
	var yes = confirm("Deseja excluir TUDO? Não há arrependimento que desfaça esta operação!");
	if (yes == true)
		window.location.href = "../acao?fazer=RemoveTUDO";
}