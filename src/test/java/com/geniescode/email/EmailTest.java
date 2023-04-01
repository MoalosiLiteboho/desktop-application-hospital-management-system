package com.geniescode.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmailTest {
    @Test
    public void validEmailFormatTest() {
        EmailValidator emailValidator =  new EmailValidator();
        boolean trueTest = emailValidator.test("name@surname.com");
        Assertions.assertTrue(trueTest);
    }

    @Test
    public void invalidEmailFormatTest() {
        EmailValidator emailValidator =  new EmailValidator();
        boolean test = emailValidator.test("surname.com");
        Assertions.assertFalse(test);
    }

    @Test
    public void findAllEmailsTest() {
        FindAllEmails findAllEmails = new FindAllEmails();
        List<String> emails = findAllEmails.get();
        Assertions.assertNotNull(emails);
        Assertions.assertFalse(emails.isEmpty());
//        Assertions.assertTrue(emails.contains("admin@admin.com"));
    }

    @Test
    public void emailTaken() {

    }

    @Test
    public void emailNotTaken() {
        EmailTaken emailTaken = new EmailTaken();
        boolean test = emailTaken.test("name@surname.com");
        Assertions.assertFalse(test);
    }
}
