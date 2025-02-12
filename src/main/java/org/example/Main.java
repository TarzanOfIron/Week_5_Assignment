package org.example;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        for (int i = 0; i <5; i++) {
            appUserDAOCollection.persist(new AppUser("Botond", "Medgyesi", "boti@123.se", "boti", "password", AppRole.ROLE_APP_ADMIN));
        }

        for (AppUser appUser : appUserDAOCollection.findAll()){
            System.out.println(appUser.getId());
        }


        System.out.println("===============================");
        System.out.println("===============================");



        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        for (int i = 0; i < 5; i++) {
            todoItemDAOCollection.persist(new ToDoItem("TodoItem", LocalDate.now()));
        }

        for (ToDoItem toDoItem : todoItemDAOCollection.findAll()){
            System.out.println(toDoItem.getId());
        }


        System.out.println("===============================");
        System.out.println("===============================");


        AppUserDAOCollection appUserDAOCollection12 = new AppUserDAOCollection();
        AppUser bob = new AppUser("Bob", "bob", "Bob@Test.se", "Bob", "Bob1234", AppRole.ROLE_APP_USER);
        appUserDAOCollection12.persist(bob);

        if (appUserDAOCollection12.findByUsername("bob") instanceof AppUser) {
            System.out.println("Fasz");
        }





    }
}