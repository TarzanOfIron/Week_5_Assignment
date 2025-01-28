package org.example;

import java.time.LocalDate;

public class ToDoItem {

    // Fields

    private int id;

    private String title;

    private String taskDescription;

    private LocalDate deadLine;

    private boolean done;

    private Person creator;


    // Constructors

    public ToDoItem(String title, LocalDate deadLine) {
        setTitle(title);
        setDeadLine(deadLine);
    }


    // Getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public Person getCreator() {
        return creator;
    }


    // Setters

    public void setTitle(String title) {
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title missing");
        }
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("Task deadline missing");
        }
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }


    // Methods

    public boolean isDone () {
        return done;
    }

    public boolean isOverDue() {
        return getDeadLine().isBefore(LocalDate.now());
    }

    public String getSummary() {
        return  ("ID: " + id +
                "\nTitle: " + title +
                "\nTask Description: " + taskDescription +
                "\nDeadline: " + deadLine +
                "\nDone: " + done +
                "\nOverdue: " + isOverDue() +
                "\nCreator: " + creator);
    }
}
