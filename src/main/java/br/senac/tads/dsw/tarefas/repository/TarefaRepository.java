package br.senac.tads.dsw.tarefas.repository;

import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
