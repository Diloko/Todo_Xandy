package com.diogo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogo.todo.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    boolean existsByNome(String nome);

}