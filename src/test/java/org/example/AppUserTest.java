package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    // Test setters
    @Test
    void validAppUserFromValidInputs() {
        AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        assertInstanceOf(AppUser.class, botondUser);
    }

    @Test
    void nullAsRoleThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () ->{
        AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", null);
        });
    }

    /*
    @Test
    void wrongRoleInputThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->{
            AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USE);
        });
    }
     */


    @Test
    void emptyUsernameThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->{
        AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "", "B1234", AppRole.ROLE_APP_USER);
        });
    }

    @Test
    void nullAsUsernameThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () ->{
            AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", null, "B1234", AppRole.ROLE_APP_USER);
        });
    }

    @Test
    void emptyPasswordThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->{
            AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "boti", "", AppRole.ROLE_APP_USER);
        });
    }

    @Test
    void nullAsPasswordThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () ->{
            AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "boti", null, AppRole.ROLE_APP_USER);
        });
    }


    // Test Override Methods
    @Test
    void toStringReturnsAStringWithAllInfoExceptPassword() {
        AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        assertEquals("Username: Boti\nRole: ROLE_APP_USER\nName: Botond Medgyesi\nEmail: BotiMail", botondUser.toString());
    }

    @Test
    void hashCodeGenerateHashCodeBasedOnUserNameRoleAndSuper() {
        AppUser botondUser = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        assertEquals(botondUser.hashCode(),botondUser.hashCode());
    }

    @Test
    void equalsReturnsTrueIfObj1IsInicalizedWithObj0() {
        AppUser obj0 = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        AppUser obj1 = obj0;
        assertTrue(obj1.equals(obj0));
    }

    @Test
    void equalsReturnsFalseIfObj1IsNull() {
        AppUser obj0 = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        AppUser obj1 = null;
        assertFalse(obj0.equals(obj1));
    }

    @Test
    void equalsReturnsFalseIfObj1IsAnInstanceOfADifferentClass() {
        AppUser obj0 = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        Person obj1 = new Person("asd", "dsa", "asddsa");
        assertFalse(obj0.equals(obj1));
    }

    @Test
    void equalsReturnsFalseWhenIdDiffers() {
        AppUser obj0 = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        AppUser obj1 = new AppUser("Botond", "Medgyesi", "BotiMail", "Boti", "B1234", AppRole.ROLE_APP_USER);
        assertFalse(obj0.equals(obj1));
    }


}