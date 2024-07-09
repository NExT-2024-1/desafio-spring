package next.school.cesar.desafiospring.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  // one(TodoList) to(para) many(Task)
  @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
  private List<Task> tasks;
}
