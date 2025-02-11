package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AppUser person1 = new AppUser("Botond", "Medgyesi", "boti@123.se", "boti", "password", AppRole.ROLE_APP_ADMIN);
        System.out.println("Fasz" + person1.getUsername() + "fasz");

        person1.setFirstName("Botond");
        person1.setLastName("Medgyesi");
        person1.setEmail("asdf");
        System.out.println(person1);

        ToDoItem tDI1 = new ToDoItem("Task 1", LocalDate.now().plusMonths(2));
        tDI1.setDone(false);
        tDI1.setDeadLine(LocalDate.now().minusDays(1));
        if (tDI1.isOverDue()) {
            System.out.println("true");
        }
        System.out.println("===============================");
        System.out.println(tDI1);

        ToDoItem toDoItem = new ToDoItem("Take Out The Trash", LocalDate.now().plusMonths(2));
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItem);
        System.out.println("===============================");
        System.out.println(toDoItemTask);

        System.out.println("===============================");
        System.out.println("===============================");
        AppUser ap = new AppUser("Botond", "Medgyesi", "email", "Boti", "Password", AppRole.ROLE_APP_USER);
        AppUser ap1 = new AppUser("Botond", "Medgyesi", "email", "Boti", "Password", AppRole.ROLE_APP_USER);
        AppUser ap2 = new AppUser("Botond", "Medgyesi", "email", "Boti", "Password", AppRole.ROLE_APP_USER);
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println(ap.getId());
        System.out.println(ap1.getId());
        System.out.println(ap2.getId());
        System.out.println("===============================");
        System.out.println("===============================");

        System.out.println(ap);
        int aaa = 3;
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        Iterator<Integer> iteratorNums = nums.iterator();
        while (iteratorNums.hasNext()) {
            if (aaa == iteratorNums.next()){
                iteratorNums.remove();
                break;
            }
        }
        System.out.println(nums);



    }
}