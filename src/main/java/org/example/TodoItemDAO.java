package org.example;

import java.time.LocalDate;
import java.util.HashSet;

public interface TodoItemDAO {

    ToDoItem persist(ToDoItem toDoItem);
    ToDoItem findById(int id);
    HashSet<ToDoItem> findAll();
    HashSet<ToDoItem> findAllByDoneStatus(boolean done);
    HashSet<ToDoItem> findTitleContains(String title);
    HashSet<ToDoItem> findByPersonId(int personId);
    HashSet<ToDoItem> findByDeadlineBefore(LocalDate date);
    HashSet<ToDoItem> findByDeadlineAfter(LocalDate date);
    void remove(int id);


}
