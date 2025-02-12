package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class TodoItemDAOCollection implements TodoItemDAO {

    private HashSet<ToDoItem> toDoItems = new HashSet<>();

    @Override
    public ToDoItem persist(ToDoItem toDoItem) {
        toDoItems.add(toDoItem);
        return toDoItem;
    }

    @Override
    public ToDoItem findById(int id) {
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem = null;
        while (toDoItemIterator.hasNext()) {
            toDoItem = toDoItemIterator.next();
            if (toDoItem.getId() == id){
                break;
            }
        }
        return toDoItem;
    }

    @Override
    public HashSet<ToDoItem> findAll() {
        return toDoItems;
    }

    @Override
    public HashSet<ToDoItem> findAllByDoneStatus(boolean done) {
        HashSet<ToDoItem> doneTodoItems = new HashSet<>();
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()){
            toDoItem = toDoItemIterator.next();
            if (toDoItem.isDone() == done) {
                doneTodoItems.add(toDoItem);
            }
        }
        return doneTodoItems;
    }

    @Override
    public HashSet<ToDoItem> findTitleContains(String title) {
        HashSet<ToDoItem> matchingTodoItemTitles = new HashSet<>();
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()){
            toDoItem = toDoItemIterator.next();
            if (Objects.equals(toDoItem.getTitle(), title)) {
                matchingTodoItemTitles.add(toDoItem);
            }
        }
        return matchingTodoItemTitles;
    }

    @Override
    public HashSet<ToDoItem> findByPersonId(int personId) {
        HashSet<ToDoItem> matchingTodoItemCreators = new HashSet<>();
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()){
            toDoItem = toDoItemIterator.next();
            if (toDoItem.getCreator().getId() == personId) {
                matchingTodoItemCreators.add(toDoItem);
            }
        }
        return matchingTodoItemCreators;
    }

    @Override
    public HashSet<ToDoItem> findByDeadlineBefore(LocalDate date) {
        HashSet<ToDoItem> todoItemsBeforeDate = new HashSet<>();
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()) {
            toDoItem = toDoItemIterator.next();
            if (date.isBefore(toDoItem.getDeadLine())){
                todoItemsBeforeDate.add(toDoItem);
            }
        }
        return todoItemsBeforeDate;
    }

    @Override
    public HashSet<ToDoItem> findByDeadlineAfter(LocalDate date) {
        HashSet<ToDoItem> todoItemsAfterDate = new HashSet<>();
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()) {
            toDoItem = toDoItemIterator.next();
            if (date.isAfter(toDoItem.getDeadLine())){
                todoItemsAfterDate.add(toDoItem);
            }
        }
        return todoItemsAfterDate;
    }

    @Override
    public void remove(int id) {
        Iterator<ToDoItem> toDoItemIterator = toDoItems.iterator();
        ToDoItem toDoItem;
        while (toDoItemIterator.hasNext()) {
            toDoItem = toDoItemIterator.next();
            if (toDoItem.getId() == id) {
                toDoItemIterator.remove();
                break;
            }
        }
    }
}
