package fr.app.task.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;

    private Instant createdAt = Instant.now();

    public enum Status {TODO, IN_PROGRESS, DONE}

    public Task() {
    }

    public Task(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status == null ? Status.TODO : status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
