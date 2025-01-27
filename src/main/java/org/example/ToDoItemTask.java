package org.example;

public class ToDoItemTask {

    // Fields

    private int id;

    private boolean assigned;

    private ToDoItem toDoItem;

    private Person assignee;


    //

    public ToDoItemTask(ToDoItem toDoItem, Person assignee) {
        this.toDoItem = toDoItem;
        this.assignee = assignee;
    }


    // Getters


    public int getId() {
        return id;
    }

    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    public Person getAssignee() {
        return assignee;
    }


    // Setters

    private void setAssigned() {
        if (getAssignee() != null) {
            this.assigned = true;
            return;
        }
        this.assigned = false;
    }

    public void setToDoItem(ToDoItem toDoItem) {
        if (toDoItem == null) {
            throw new IllegalArgumentException("Todo item missing");
        }
        this.toDoItem = toDoItem;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        setAssigned();
    }


    // Methods

    public boolean isAssigned() {
        return assigned;
    }

    public String summary() {
        return new String("ID: " + id +
                ", is assigned: " + assigned +
                ", todo item: " + toDoItem +
                ", assignee: " + assignee);
    }
}
