package br.com.cesario.ToDoListbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cesario.ToDoListbackend.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
