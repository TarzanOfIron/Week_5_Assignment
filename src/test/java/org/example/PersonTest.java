package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    // First name
    @Test
    void firstNameShouldBeBotond() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertEquals("Botond", person.getFirstName());
    }

    @Test
    void emptyFirstNameFromConstructorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person(" ", "Medgyesi", "BotondM@asd.com");
        });
    }

    @Test
    void setFirstNameShouldBeBotond() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        person.setFirstName("Boti");
        assertEquals("Boti", person.getFirstName());
    }

    @Test
    void setEmptyFirstNameShouldThrowIllegalArgumentException() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName(" ");
        });
    }

    //Last name
    @Test
    void lastNameShouldBeMedgyesi() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertEquals("Medgyesi", person.getLastName());
    }

    @Test
    void emptyLastNameFromConstructorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person("Botond", "", "BotondM@asd.com");
        });
    }

    @Test
    void setLastNameShouldBeMedgyesisson() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        person.setLastName("Medgyesisson");
        assertEquals("Medgyesisson", person.getLastName());
    }

    @Test
    void setEmptyLastNameShouldThrowIllegalArgumentException() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setLastName(" ");
        });
    }


    //Email
    @Test
    void emailShouldBeBotondMATasdDOTcom() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertEquals("BotondM@asd.com", person.getEmail());
    }

    @Test
    void emptyEmailFromConstructorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person("Botond", "Medgyesi", "");
        });
    }

    @Test
    void setEmailShouldBeaaa() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        person.setEmail("aaa");
        assertEquals("aaa", person.getEmail());
    }

    @Test
    void setEmptyEmailShouldThrowIllegalArgumentException() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(" ");
        });
    }


    //Id
    @Test
    void idIncreases() {
        Person person = new Person("Botond", "Medgyesi", "aaa");
        Person person1 = new Person("Botond", "Medgyesi", "aaa");
        assertAll("id should increase by one",
            () -> assertEquals(0, person.getId()),
            () -> assertEquals(1, person1.getId())
        );
    }


    // Override Methods
    @Test
    void toStringReturnsAStringWithAllFields() {
         Person person = new Person("Botond", "Medgyesi", "aaa");
         assertEquals("Name: Botond Medgyesi\nEmail: aaa", person.toString());
    }

    @Test
    void hashCodeGeneratesHashCodeBasedOnFirstNameLastNameEmailAndId() {
        Person person = new Person("Botond", "Medgyesi", "BotiMail");
        assertEquals(person.hashCode(),person.hashCode());
    }

    @Test
    void



}