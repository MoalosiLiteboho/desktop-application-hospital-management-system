package com.geniescode;

import com.geniescode.email.EmailTaken;
import com.geniescode.email.FindAllEmails;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new FindAllEmails().get();
        System.out.println(stringList.toString());
        System.out.println(
                new EmailTaken().test("liteboho@moaloi.com")
        );
    }
}
