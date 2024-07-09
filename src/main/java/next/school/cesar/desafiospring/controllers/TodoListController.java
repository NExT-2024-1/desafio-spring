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

import lombok.AllArgsConstructor;
import next.school.cesar.desafiospring.entities.TodoList;
import next.school.cesar.desafiospring.services.TodoListService;

@RestController
@RequestMapping("/todolists")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TodoListController {

  private TodoListService todoListService;

  @GetMapping
  public List<TodoList> getAllTodoLists() {
    return todoListService.findAll();
  }

  @PostMapping
  public TodoList createTodoList(@RequestBody TodoList todoList) {
    return todoListService.save(todoList);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TodoList> updateTodoList(@PathVariable Long id, @RequestBody TodoList todoListDetails) {
    TodoList todoList = todoListService.findById(id);
    if (todoList == null) {
      return ResponseEntity.notFound().build();
    }
    todoList.setName(todoListDetails.getName());
    todoList.setUpdatedAt(LocalDate.now());
    TodoList updatedTodoList = todoListService.save(todoList);
    return ResponseEntity.ok(updatedTodoList);
  }

  @DeleteMapping("/{id}")
  public List<TodoList> deleteTodoList(@PathVariable Long id) {
    return todoListService.deleteById(id);
  }
}
