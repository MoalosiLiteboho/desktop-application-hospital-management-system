package com.geniescode.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FindAllEmailsTest {
    @Test
    public void getTest() {
        FindAllEmails findAllEmails = new FindAllEmails();
        List<String> emails = findAllEmails.get();
        Assertions.assertNotNull(emails);
        Assertions.assertFalse(emails.isEmpty());
//        Assertions.assertTrue(emails.contains("admin@admin.com"));
    }

}