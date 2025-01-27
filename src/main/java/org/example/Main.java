package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setFirstName("Botond");
        person1.setLastName("Medgyesi");
        person1.setEmail("asdf");
        System.out.println(person1.getSummary());

        ToDoItem tDI1 = new ToDoItem();
        tDI1.setDone(false);
        tDI1.setDeadLine(LocalDate.now().minusDays(1));
        tDI1.setCreator(person1);
        if (tDI1.isOverDue()) {
            System.out.println("true");
        }
        System.out.println(tDI1.getSummary());
    }
}