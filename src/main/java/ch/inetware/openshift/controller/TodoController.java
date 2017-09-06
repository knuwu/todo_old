package ch.inetware.openshift.controller;

import ch.inetware.openshift.domain.Todo;
import ch.inetware.openshift.services.TodoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping (path = "/v1")
public class TodoController {

  private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

  @Resource
  private TodoService todoService;

  @ApiOperation(value = "Liste alle Todo-Einträge")
  @RequestMapping(path = "/todos", method = GET)
  public List<Todo> getTodoList() {
    return todoService.getTodos();
  }

  @ApiOperation(value = "Lesen eines Todo-Eintrags")
  @RequestMapping(path = "/todo/{id}", method = GET)
  public Todo getTodoById(@PathVariable Long id) {
    LOG.info("/todo/{} called", id);
    return todoService.getTodo(id);
  }

  @ApiOperation(value = "Neuen Eintrag in Todo-Liste hinzufügen")
  @RequestMapping(path = "/todo", method = POST)
  public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
    Todo result = todoService.addTodo(todo);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(result.id).toUri();

    return ResponseEntity.created(location).build();
  }

  @ApiOperation(value = "Löschen eines Todo-Eintrags")
  @RequestMapping(path = "/todo/{id}", method = DELETE)
  public void deleteTodoById(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }
}
