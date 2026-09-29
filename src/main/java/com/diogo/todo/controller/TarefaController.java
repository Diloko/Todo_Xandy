package com.diogo.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.diogo.todo.model.entity.Tarefa;
import com.diogo.todo.service.TarefaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarefa criar(@Valid @RequestBody Tarefa tarefa) {
        return service.criar(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Tarefa buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(
            @PathVariable Long id,
            @RequestBody Tarefa tarefa) {

        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}