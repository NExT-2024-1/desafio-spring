package next.school.cesar.desafiospring.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private boolean completed;
  private LocalDate dueDate;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  @JsonBackReference
  @ManyToOne // many(Task) to(para) one(TodoList) 
  @JoinColumn(name = "todolist_id")
  private TodoList todoList;
}
