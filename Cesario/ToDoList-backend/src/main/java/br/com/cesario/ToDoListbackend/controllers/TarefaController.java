package br.com.cesario.ToDoListbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesario.ToDoListbackend.models.Tarefa;
import br.com.cesario.ToDoListbackend.repository.TarefaRepository;

@RestController
@RequestMapping(value = "/todolist")
@CrossOrigin(value = "*")
public class TarefaController {

	@Autowired
	TarefaRepository repository;

	@GetMapping(value = "/listar/tarefas")
	public List<Tarefa> listarTarefas() {
		return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@PostMapping(value = "/salvar/tarefa")
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		return repository.save(tarefa);
	}

	@PutMapping(value = "/atualiza/tarefa")
	public Tarefa atualizaTarefa(@RequestBody Tarefa tarefa) {
		return repository.save(tarefa);
	}

	@DeleteMapping(value = "/excluir/tarefa")
	public void excluirTarefa(@RequestBody Tarefa tarefa) {
		repository.delete(tarefa);
	}
}
