package next.school.cesar.desafiospring.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafiospring.entities.Task;
import next.school.cesar.desafiospring.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public List<Task> getAllTasks() {
    return taskService.findAll();
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    return taskService.save(task);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
    Task task = taskService.findById(id);
    if (task == null) {
      return ResponseEntity.notFound().build();
    }
    task.setName(taskDetails.getName());
    task.setDescription(taskDetails.getDescription());
    task.setCompleted(taskDetails.isCompleted());
    task.setDueDate(taskDetails.getDueDate());
    task.setUpdatedAt(LocalDate.now());
    Task updatedTask = taskService.save(task);
    return ResponseEntity.ok(updatedTask);
  }

  @DeleteMapping("/{id}")
  public List<Task> deleteTask(@PathVariable Long id) {
    return taskService.deleteById(id);
  }
}
