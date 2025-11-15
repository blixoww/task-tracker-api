package fr.app.task.service;

import fr.app.task.model.Task;
import fr.app.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task create(Task t) {
        return repo.save(t);
    }

    public List<Task> findAll(Optional<Task.Status> status) {
        return status.map(repo::findByStatus).orElseGet(repo::findAll);
    }

    public Optional<Task> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Task> update(Long id, Task newTask) {
        return repo.findById(id).map(task -> {
            task.setTitle(newTask.getTitle());
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            return repo.save(task);
        });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
