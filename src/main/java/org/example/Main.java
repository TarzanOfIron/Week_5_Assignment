package org.example;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setFirstName("Botond");
        person1.setLastName("Medgyesi");
        person1.setEmail("asdf");
        System.out.println(person1.getSummary());
    }
}