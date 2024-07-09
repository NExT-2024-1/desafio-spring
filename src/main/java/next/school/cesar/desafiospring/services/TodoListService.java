package next.school.cesar.desafiospring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import next.school.cesar.desafiospring.entities.TodoList;
import next.school.cesar.desafiospring.repositories.TodoListRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TodoListService {

  private final TodoListRepository todoListRepository;

  public List<TodoList> findAll() {
    return todoListRepository.findAll();
  }

  public TodoList save(TodoList todoList) {
	  todoList.setCreatedAt(LocalDate.now());
	  todoList.setUpdatedAt(LocalDate.now());
    return todoListRepository.save(todoList);
  }

  public List<TodoList> deleteById(Long id) {
    todoListRepository.deleteById(id);
    return todoListRepository.findAll();
  }

  public TodoList findById(Long id) {
    return todoListRepository.findById(id).orElse(null);
  }
}
