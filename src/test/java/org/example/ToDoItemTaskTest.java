package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemTaskTest {

    //ID
    @Test
    void getIdShouldReturnZero() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        assertEquals(0, toDoItemTask.getId());
    }


    //Assigned
    @Test
    void notSettingAssigneeShouldReturnNull() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        assertFalse(toDoItemTask.isAssigned());
    }

    @Test
    void isAssignedShouldReturnsTrueWhenSettingAssigneeToPersonBotond() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        Person botond = new Person("Botond", "Medgyesi", "aaa");
        toDoItemTask.setAssignee(botond);
        assertTrue(toDoItemTask.isAssigned());
    }

    @Test
    void assignToNullShouldReturnFalseOnIsAssigned() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        Person botond = new Person("Botond", "Medgyesi", "aaa");
        toDoItemTask.setAssignee(botond);
        toDoItemTask.setAssignee(null);
        assertFalse(toDoItemTask.isAssigned());
    }


    //Assignee
    @Test
    void settingAssigneeToPersonBotond() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        Person botond = new Person("Botond", "Medgyesi", "aaa");
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        toDoItemTask.setAssignee(botond);
        assertEquals(botond, toDoItemTask.getAssignee());
    }

    @Test
    void settingAssigneeToPersonMelhemFromPersonBotond() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        Person botond = new Person("Botond", "Medgyesi", "aaa");
        Person melhem = new Person("Melhem", "Medgyesi", "bbb");
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        toDoItemTask.setAssignee(botond);
        toDoItemTask.setAssignee(melhem);
        assertEquals(melhem, toDoItemTask.getAssignee());
    }

    @Test
    void getAssigneeShouldReturnNullIfAssigneeIsNotSet() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        assertNull(toDoItemTask.getAssignee());
    }


    //ToDoItem
    @Test
    void emptyToDoItemTaskFromConstructorThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToDoItemTask toDoItemTask = new ToDoItemTask(null);
        });
    }

    @Test
    void toDoItemShouldBeTheOneSetWithTheConstructor() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        assertEquals(toDoItem, toDoItemTask.getToDoItem());
    }

    @Test
    void toDoItemShouldBeTheLatestSetTodoItem() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        ToDoItem newToDoItem = new ToDoItem("Do The Dishes", LocalDate.now().plusMonths(2));
        toDoItemTask.setToDoItem(newToDoItem);
        assertEquals(newToDoItem, toDoItemTask.getToDoItem());
    }


    //Summary
    @Test
    void getSummaryListsAllFields() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        assertEquals("ID: 0" +
                        "\nIs assigned: false" +
                        "\nTodo item: " + toDoItemTask.getToDoItem() +
                        "\nAssignee: null",
                toDoItemTask.getSummary());
    }

}