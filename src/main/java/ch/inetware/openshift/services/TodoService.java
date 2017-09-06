package ch.inetware.openshift.services;

import ch.inetware.openshift.domain.Todo;

import java.util.List;

public interface TodoService {

  /**
   * Liefert die Lister aller Todo-Einträge.
   * @return Liste aller Todo-Einträge
   */
  List<Todo> getTodos();


  /**
   * Liest einen einzelnen Todo-Eintrag
   * @param id Id des Todo-Eintrags
   * @return der gesuchte Todo-Eintrag
   */
   Todo getTodo(Long id);

  /**
   * Speichert einen neuen Todo-Eintrag in der Liste
   * @param todo neuer Todo-Eintrag
   */
  Todo addTodo(Todo todo);

  /**
   * Löscht den angegebenen Todo-Eintrag
   * @param id Id des zu löschenden Todo-Eintrags
   */
  void deleteTodo(Long id);
}
