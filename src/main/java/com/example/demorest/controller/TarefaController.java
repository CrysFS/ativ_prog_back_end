package com.example.demorest.controller;

import com.example.demorest.model.Tarefa;
import com.example.demorest.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable long id, @RequestBody Tarefa tarefa) {
        return repository.findById(id).map(record -> {
            record.setNome(tarefa.getNome());
            record.setDataEntrega(tarefa.getDataEntrega());
            record.setResponsavel(tarefa.getResponsavel());
            Tarefa updated = repository.save(record);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}