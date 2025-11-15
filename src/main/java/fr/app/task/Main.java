package fr.app.task;

import fr.app.task.model.Task;
import fr.app.task.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(TaskService service) {
        return args -> {
            service.create(new Task("Tâche 1", "Ceci est une première tâche", Task.Status.TODO));
            service.create(new Task("Tâche 2", "Ceci est une seconde tâche", Task.Status.IN_PROGRESS));
        };
    }

}