package org.example;

import java.util.HashSet;
import java.util.Iterator;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    private HashSet<ToDoItemTask> toDoItemTasks = new HashSet<>();

    @Override
    public ToDoItemTask persist(ToDoItemTask toDoItemTask) {
        toDoItemTasks.add(toDoItemTask);
        return toDoItemTask;
    }

    @Override
    public ToDoItemTask findById(int id) {
        Iterator<ToDoItemTask> toDoItemTaskIterator = toDoItemTasks.iterator();
        ToDoItemTask toDoItemTask = null;
        while (toDoItemTaskIterator.hasNext()) {
            toDoItemTask = toDoItemTaskIterator.next();
            if (toDoItemTask.getId() == id){
                break;
            }
        }
        return toDoItemTask;
    }

    @Override
    public HashSet<ToDoItemTask> findAll() {
        return toDoItemTasks;
    }

    @Override
    public HashSet<ToDoItemTask> findByAssignedStatus(boolean status) {
        Iterator<ToDoItemTask> toDoItemTaskIterator = toDoItemTasks.iterator();
        HashSet<ToDoItemTask> tasksWithStatus = new HashSet<>();
        ToDoItemTask toDoItemTask;
        while (toDoItemTaskIterator.hasNext()) {
            toDoItemTask = toDoItemTaskIterator.next();
            if (toDoItemTask.isAssigned() == status){
                tasksWithStatus.add(toDoItemTask);
            }
        }

        return tasksWithStatus;
    }

    @Override
    public HashSet<ToDoItemTask> findByPersonalId(int personId) {
        HashSet<ToDoItemTask> tasksAssignedToThisPerson = new HashSet<>();
        Iterator<ToDoItemTask> toDoItemTaskIterator = toDoItemTasks.iterator();
        ToDoItemTask toDoItemTask;
        while (toDoItemTaskIterator.hasNext()) {
            toDoItemTask = toDoItemTaskIterator.next();
            if (toDoItemTask.getAssignee().getId() == personId){
                tasksAssignedToThisPerson.add(toDoItemTask);
            }
        }

        return tasksAssignedToThisPerson;
    }

    @Override
    public void remove(int id) {
        Iterator<ToDoItemTask> toDoItemTaskIterator = toDoItemTasks.iterator();
        ToDoItemTask toDoItemTask;
        while (toDoItemTaskIterator.hasNext()){
            toDoItemTask = toDoItemTaskIterator.next();
            if (toDoItemTask.getId() == id){
                toDoItemTaskIterator.remove();
                break;
            }
        }
    }
}
