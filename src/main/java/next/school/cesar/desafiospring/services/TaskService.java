package next.school.cesar.desafiospring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import next.school.cesar.desafiospring.entities.Task;
import next.school.cesar.desafiospring.repositories.TaskRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

  private final TaskRepository taskRepository;

  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  public Task save(Task task) {
	  task.setCreatedAt(LocalDate.now());
	  task.setUpdatedAt(LocalDate.now());
    return taskRepository.save(task);
  }

  public List<Task> deleteById(Long id) {
    taskRepository.deleteById(id);
    return taskRepository.findAll();
  }

  public Task findById(Long id) {
    return taskRepository.findById(id).orElse(null);
  }

  public Task updateTask(Long id, Task taskDetails) {
    Task task = taskRepository.findById(id).get();
    task.setName(taskDetails.getName());
    task.setDescription(taskDetails.getDescription());
    task.setCompleted(taskDetails.isCompleted());
    task.setDueDate(taskDetails.getDueDate());
    return taskRepository.save(task);
  }
}
