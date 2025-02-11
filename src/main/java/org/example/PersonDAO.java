package org.example;

import java.util.HashSet;

public interface PersonDAO {

    Person persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    HashSet<Person> findAll();
    void remove(int id);
}
