package org.example;

import java.util.HashSet;
import java.util.Iterator;

public class PersonDAOCollection implements PersonDAO{

     private HashSet<Person> persons = new HashSet<>();

    @Override
    public Person persist(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        Iterator<Person> personIterator = persons.iterator();
        Person person = null;
        while (personIterator.hasNext()) {
            person = personIterator.next();
            if (person.getId() == id) {
                break;
            }
        }
        return person;
    }

    @Override
    public Person findByEmail(String email) {
        Iterator<Person> personIterator = persons.iterator();
        Person person = null;
        while (personIterator.hasNext()) {
            person = personIterator.next();
            if (person.getEmail().equals(email)) {
                break;
            }
        }
        return person;
    }

    @Override
    public HashSet<Person> findAll() {
        return persons;
    }

    @Override
    public void remove(int id) {
        Iterator<Person> personIterator = persons.iterator();
        Person person;
        while (personIterator.hasNext()) {
            person = personIterator.next();
            if (person.getId() == id) {
                personIterator.remove();
                break;
            }
        }
    }
}
