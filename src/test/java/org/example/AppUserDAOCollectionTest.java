package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserDAOCollectionTest {


    //Test findAll
    @Test
    void findAllReturnsEveryAppUserInTheCollection() {
        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        AppUser bob = new AppUser("Bob", "bob", "Bob@Test.se", "Bob", "Bob1234", AppRole.ROLE_APP_USER);
        AppUser bob2 = new AppUser("Bob2", "bob2", "Bob2@Test.se", "Bob2", "Bob2_1234", AppRole.ROLE_APP_USER);
        appUserDAOCollection.persist(bob);
        appUserDAOCollection.persist(bob2);
        assertTrue(appUserDAOCollection.findAll().contains(bob) && appUserDAOCollection.findAll().contains(bob2));
    }


    //Test persist
    @Test
    void collectionContainBobAfterPersistingHim() {
        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        AppUser bob = new AppUser("Bob", "bob", "Bob@Test.se", "Bob", "Bob1234", AppRole.ROLE_APP_USER);
        appUserDAOCollection.persist(bob);
        assertTrue(appUserDAOCollection.findAll().contains(bob));
    }


    //Test remove
    @Test
    void collectionsDoesNotContainBobAfterRemovingHim() {
        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        AppUser bob = new AppUser("Bob", "bob", "Bob@Test.se", "Bob", "Bob1234", AppRole.ROLE_APP_USER);
        appUserDAOCollection.persist(bob);
        appUserDAOCollection.remove(bob.getUsername());
        assertFalse(appUserDAOCollection.findAll().contains(bob));
    }


    //Test findByUsername
    @Test
    void findByUsernameReturnsAppUserWithUsername() {
        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        AppUser bob = new AppUser("Bob", "bob", "Bob@Test.se", "Bob", "Bob1234", AppRole.ROLE_APP_USER);
        appUserDAOCollection.persist(bob);
        assertEquals(bob, appUserDAOCollection.findByUsername("Bob"));
    }

}