package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class TodoItemTaskDAOCollectionTest {

    //Test findAll
    @Test
    void findAllReturnsEveryTodoItemTasksInTheCollection() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItemTask toDoItemTask = new ToDoItemTask(new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2)));
        ToDoItemTask toDoItemTask2 = new ToDoItemTask(new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2)));
        todoItemTaskDAOCollection.persist(toDoItemTask);
        todoItemTaskDAOCollection.persist(toDoItemTask2);
        assertEquals(2,todoItemTaskDAOCollection.findAll().size());
    }


    //Test persist
    @Test
    void collectionContainTodoItemTaskAfterPersistingIt() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        todoItemTaskDAOCollection.persist(toDoItemTask);
        assertTrue(todoItemTaskDAOCollection.findAll().contains(toDoItemTask));
    }


    //Test remove
    @Test
    void collectionsDoesNotContainTodoItemTaskAfterRemovingIt() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        todoItemTaskDAOCollection.persist(toDoItemTask);
        todoItemTaskDAOCollection.remove(toDoItemTask.getId());
        assertEquals(0, todoItemTaskDAOCollection.findAll().size());
    }

    // Test FindById
    @Test
    void findByIdReturnsTheTodoItemTaskWithGivenId() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        todoItemTaskDAOCollection.persist(toDoItemTask);
        assertEquals(toDoItemTask, todoItemTaskDAOCollection.findById(0));
    }

    // Test findByAssignedStatus
    @Test
    void findByAssignedStatusReturnsACollectionWithTodoItemTasksWithGivenAssignedStatus() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        ToDoItemTask toDoItemTask2 = new ToDoItemTask(toDoItem);
        todoItemTaskDAOCollection.persist(toDoItemTask);
        todoItemTaskDAOCollection.persist(toDoItemTask2);
        toDoItemTask.setAssignee(new Person("bob", "Bobsson", "Bob@Test.se"));
        toDoItemTask2.setAssignee(new Person("bob", "Bobsson", "Bob@Test.se"));
        assertEquals(todoItemTaskDAOCollection.findAll(), todoItemTaskDAOCollection.findByAssignedStatus(true));

    }

    // Test findByPersonalId
    @Test
    void findByPersonalIdReturnsACollectionOfTodoItemTasksWithAssigneeWithId() {
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        ToDoItem toDoItem = new ToDoItem("Take iout the trash", LocalDate.now().plusDays(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        ToDoItemTask toDoItemTask2 = new ToDoItemTask(toDoItem);
        todoItemTaskDAOCollection.persist(toDoItemTask);
        todoItemTaskDAOCollection.persist(toDoItemTask2);
        Person bob = new Person("bob", "Bobsson", "Bob@Test.se");
        toDoItemTask.setAssignee(bob);
        toDoItemTask2.setAssignee(bob);
        assertEquals(todoItemTaskDAOCollection.findAll(), todoItemTaskDAOCollection.findByPersonalId(0));
    }


  
}