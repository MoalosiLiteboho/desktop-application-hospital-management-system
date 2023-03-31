package com.geniescode.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {
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
}