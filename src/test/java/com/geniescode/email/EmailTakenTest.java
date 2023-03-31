package com.geniescode.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.E;

class EmailTakenTest {
    private final EmailTaken emailTaken = new EmailTaken();

    @Test
    public void emailTaken() {

    }

    @Test
    public void emailNotTaken() {
        boolean test = emailTaken.test("name@surname.com");
        Assertions.assertFalse(test);
    }

}