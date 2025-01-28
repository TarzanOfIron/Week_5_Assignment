package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void firstNameShouldBeBotond() {
        Person person = new Person("Botond", "Medgyesi", "BotondM@asd.com");
        assertEquals("Botond", person.getFirstName());
    }

    @Test
    void emptyFirstNameShouldThrowIllegalArgumentException() {
        //Person person = new Person(" ", "Medgyesi", "BotondM@asd.com");
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person(" ", "Medgyesi", "BotondM@asd.com");
        });
    }

}