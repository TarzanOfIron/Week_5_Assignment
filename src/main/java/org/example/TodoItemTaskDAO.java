package org.example;

import java.util.HashSet;

public interface TodoItemTaskDAO {

    ToDoItemTask persist(ToDoItemTask toDoItemTask);
    ToDoItemTask findById(int id);
    HashSet<ToDoItemTask> findAll();
    HashSet<ToDoItemTask> findByAssignedStatus(boolean status);
    HashSet<ToDoItemTask> findByPersonalId(int personId);
    void remove(int id);

}
