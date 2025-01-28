package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemTest {

    // Title
    @Test
    void titleFromConstructorShouldBeTakeOutTheTrash() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        assertEquals("Take Out The Trash", toDoItem.getTitle());
    }

    @Test
    void setTitleShouldBeDoTheDishes() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        toDoItem.setTitle("Do The Dishes");
        assertEquals("Do The Dishes", toDoItem.getTitle());
    }

    @Test
    void emptyTitleFromConstructorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToDoItem toDoItem = new ToDoItem("", LocalDate.now().plusMonths(2));
        });
    }

    @Test
    void setEmptyTitleFromConstructorShouldThrowIllegalArgumentException() {
        ToDoItem toDoItem = new ToDoItem("Do The Dishes", LocalDate.now().plusMonths(2));
        assertThrows(IllegalArgumentException.class, () -> {
            toDoItem.setTitle("");
        });
    }


    //Task Description
    @Test
    void getTaskDescriptionShouldBeNullWhenTaskNotSet() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        assertNull(toDoItem.getTaskDescription());
    }

    @Test
    void setTaskDescriptionToEmptyShouldBeNull() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        toDoItem.setTaskDescription("");
        assertEquals("", toDoItem.getTaskDescription());
    }

    @Test
    void setTaskDescriptionToAaaShouldBeAaa() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        toDoItem.setTaskDescription("Aaa");
        assertEquals("Aaa", toDoItem.getTaskDescription());
    }


    //Deadline
    @Test
    void deadLineFromConstructorShouldBeSetToTwoMonthsFromCreatingTheTask() {
        LocalDate twoMonthsFromNow = LocalDate.now().plusMonths(2);
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", twoMonthsFromNow);
        assertEquals(twoMonthsFromNow, toDoItem.getDeadLine());
    }

    @Test
    void setDeadLineShouldBeSetToTwoMonthsFromCreatingTheTask() {
        LocalDate twoMonthsFromNow = LocalDate.now().plusMonths(2);
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now());
        toDoItem.setDeadLine(twoMonthsFromNow);
        assertEquals(twoMonthsFromNow, toDoItem.getDeadLine());
    }

    @Test
    void nullDeadLineFromConstructorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToDoItem toDoItem = new ToDoItem("Take Out The Trash",null);
        });
    }

    @Test
    void setNullDeadLineShouldThrowIllegalArgumentException() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash",LocalDate.now().plusMonths(2));
        assertThrows(IllegalArgumentException.class, () -> {
            toDoItem.setDeadLine(null);
        });
    }


    //Overdue
    @Test
    void deadLineSetToLastMonthShouldReturnTrue() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash",LocalDate.now().minusMonths(1));
        assertTrue(toDoItem.isOverDue());
    }

    @Test
    void deadLineSetToTwoMonthsFromNowShouldReturnFalse() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash",LocalDate.now().plusMonths(2));
        assertFalse(toDoItem.isOverDue());
    }


    //Done
    @Test
    void notSettingDoneShouldReturnFalse() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash",LocalDate.now().plusMonths(2));
        assertFalse(toDoItem.isDone());
    }

    @Test
    void settingDoneTrueShouldReturnTrue() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash",LocalDate.now().plusMonths(2));
        toDoItem.setDone(true);
        assertTrue(toDoItem.isDone());
    }


    //Creator
    @Test
    void getCreatorShouldBeNullWhenCreatorNotSet() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        assertNull(toDoItem.getCreator());
    }

    @Test
    void setCreatorToEmptyShouldBeNull() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        toDoItem.setTaskDescription("");
        assertEquals("", toDoItem.getTaskDescription());
    }

    @Test
    void setAPerson1AsCreatorShouldReturnPerson1ObjectId() {
        Person person1 = new Person("Botond", "Medgyesi", "email");
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        toDoItem.setCreator(person1);
        assertEquals(person1, toDoItem.getCreator());
    }


    //Summary
    @Test
    void getSummaryListsAllFields() {
        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        assertEquals("ID: 0" +
                "\nTitle: Take Out The Trash" +
                "\nTask Description: null" +
                "\nDeadline: 2025-03-28" +
                "\nDone: false" +
                "\nOverdue: false" +
                "\nCreator: null",
                toDoItem.getSummary());
    }
}