package fr.app.task.controller;

import fr.app.task.model.Task;
import fr.app.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) { this.service = service; }

    @GetMapping
    public List<Task> list(@RequestParam Optional<Task.Status> status) {
        return service.findAll(status);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task t) {
        Task saved = service.create(t);
        return ResponseEntity.created(URI.create("/tasks/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task t) {
        return service.update(id, t).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
