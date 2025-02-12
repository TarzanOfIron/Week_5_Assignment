package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOCollectionTest {

    //Test findAll
    @Test
    void findAllReturnsEveryPersonInTheCollection() {
        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        Person bob = new Person("Bob", "bob", "Bob@Test.se");
        Person bob2 = new Person("Bob2", "bob2", "Bob2@Test.se");
        personDAOCollection.persist(bob);
        personDAOCollection.persist(bob2);
        assertTrue(personDAOCollection.findAll().contains(bob) && personDAOCollection.findAll().contains(bob2));
    }


    //Test persist
    @Test
    void collectionContainBobAfterPersistingHim() {
        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        Person bob = new Person("Bob", "bob", "Bob@Test.se");
        personDAOCollection.persist(bob);
        assertTrue(personDAOCollection.findAll().contains(bob));
    }


    //Test remove
    @Test
    void collectionsDoesNotContainBobAfterRemovingHim() {
        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        Person bob = new Person("Bob", "bob", "Bob@Test.se");
        personDAOCollection.persist(bob);
        personDAOCollection.remove(bob.getId());
        assertFalse(personDAOCollection.findAll().contains(bob));
    }


    //Test findByEmail
    @Test
    void findByUsernameReturnsPersonWithEmail() {
        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        Person bob = new Person("Bob", "bob", "Bob@Test.se");
        personDAOCollection.persist(bob);
        assertEquals(bob, personDAOCollection.findByEmail("Bob@Test.se"));
    }

    //Test findId
    @Test
    void findByUsernameReturnsPersonWithId() {
        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        Person bob = new Person("Bob", "bob", "Bob@Test.se");
        personDAOCollection.persist(bob);
        assertEquals(bob, personDAOCollection.findById(0));
    }


}