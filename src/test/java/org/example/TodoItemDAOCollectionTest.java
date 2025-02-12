package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemDAOCollectionTest {

    //Test findAll
    @Test
    void findAllReturnsEveryTodoItemInTheCollection() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItem toDoItem2 = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        todoItemDAOCollection.persist(toDoItem2);
        assertEquals(2, todoItemDAOCollection.findAll().size());
    }


    //Test persist
    @Test
    void collectionContainBobAfterPersistingHim() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertTrue(todoItemDAOCollection.findAll().contains(toDoItem));
    }


    //Test remove
    @Test
    void collectionsDoesNotContainBobAfterRemovingHim() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        todoItemDAOCollection.remove(toDoItem.getId());
        assertFalse(todoItemDAOCollection.findAll().contains(toDoItem));
    }


    //Test findId
    @Test
    void findByUsernameReturnsTodoItemWithId() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertEquals(toDoItem, todoItemDAOCollection.findById(0));
    }


    //Test findByDoneStatus
    @Test
    void findByUsernameReturnsTodoItemsWithDoneStatusTrue() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        toDoItem.setDone(true);
        assertEquals(1,todoItemDAOCollection.findAllByDoneStatus(true).size());
    }

    @Test
    void findByUsernameReturnsTodoItemsWithDoneStatusFalse() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertEquals(1,todoItemDAOCollection.findAllByDoneStatus(false).size());
    }

    // Test findTitleContains
    @Test
    void findTitleContainsReturnsCollectionOfTodoItemsWithTitle() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertEquals(todoItemDAOCollection.findAll(),todoItemDAOCollection.findTitleContains("Take iout the trash"));
    }

    // Test findByPersonalId
    @Test
    void findByPersonalIdReturnsACollectionOfTodoItemsThatAReCreatedByPersonWithId() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        Person bob = new Person("Bob", "Bobsson", "bob@Test.se");
        toDoItem.setCreator(bob);
        assertEquals(todoItemDAOCollection.findAll(), todoItemDAOCollection.findByPersonId(0));
    }

    // Test findByDeadline
    @Test
    void findByDeadlineBeforeReturnsACollectionOfTodoItemsWereGivenDateIsBeforeDeadline() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertEquals(todoItemDAOCollection.findAll(), todoItemDAOCollection.findByDeadlineBefore(LocalDate.now()));
    }


    @Test
    void findByDeadlineBeforeReturnsACollectionOfTodoItemsWereGivenDateIsAfterDeadline() {
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().minusDays(2));
        todoItemDAOCollection.persist(toDoItem);
        assertEquals(todoItemDAOCollection.findAll(), todoItemDAOCollection.findByDeadlineAfter(LocalDate.now()));
    }




}