package com.diogo.todo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diogo.todo.model.entity.Tarefa;
import com.diogo.todo.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criar(Tarefa tarefa) {

        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setDataAtualizacao(LocalDateTime.now());

        return repository.save(tarefa);
    }

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {

        Tarefa tarefa = buscarPorId(id);

        tarefa.setNome(novaTarefa.getNome());
        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setStatus(novaTarefa.getStatus());
        tarefa.setObservacoes(novaTarefa.getObservacoes());
        tarefa.setDataAtualizacao(LocalDateTime.now());

        return repository.save(tarefa);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}