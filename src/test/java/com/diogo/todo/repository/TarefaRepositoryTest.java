package com.diogo.todo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diogo.todo.model.entity.Tarefa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository repository;

    @Test
    public void deveVerificarExistenciaDeUmaTarefa() {

        // cenário

        Tarefa tarefa = new Tarefa();

        tarefa.setNome("Estudar Spring Boot");
        tarefa.setDescricao("Projeto DSM");
        tarefa.setStatus("PENDENTE");

        repository.save(tarefa);

        // ação

        boolean resultado =
                repository.existsByNome("Estudar Spring Boot");

        // validação

        assertTrue(resultado);
    }

    @Test
    public void deveSalvarUmaTarefa() {

        Tarefa tarefa = new Tarefa();

        tarefa.setNome("Projeto DSM");
        tarefa.setDescricao("CRUD");
        tarefa.setStatus("PENDENTE");

        Tarefa resultado = repository.save(tarefa);

        assertNotNull(resultado.getId());
    }

    @Test
    public void deveExcluirUmaTarefa() {

        Tarefa tarefa = new Tarefa();

        tarefa.setNome("Excluir");
        tarefa.setStatus("PENDENTE");

        tarefa = repository.save(tarefa);

        repository.delete(tarefa);

        boolean existe =
                repository.existsByNome("Excluir");

        assertFalse(existe);
    }

    @Test
    public void naoDeveEncontrarUmaTarefaInexistente() {

        boolean existe =
                repository.existsByNome("TarefaInexistente");

        assertFalse(existe);
    }
}