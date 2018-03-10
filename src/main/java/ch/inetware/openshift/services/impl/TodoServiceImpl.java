package ch.inetware.openshift.services.impl;

import ch.inetware.openshift.domain.Todo;
import ch.inetware.openshift.domain.TodoRepository;
import ch.inetware.openshift.services.TodoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TodoServiceImpl implements TodoService {

  @Resource
  private TodoRepository repository;

  @Override
  public List<Todo> getTodos() {
    return repository.findAll();
  }

  @Override
  public Optional<Todo> getTodo(Long id) {
    return repository.findById(id);
  }

  @Override
  public Todo addTodo(Todo todo) {
    if (todo.addedAt == null) {
      todo.addedAt = LocalDateTime.now();
    }

    return repository.save(todo);
  }

  @Override
  public void deleteTodo(Long id) {
    repository.deleteById(id);
  }


}
