package com.geniescode.password;

import java.util.function.Function;

public class PasswordGenerator implements Function<String, String> {
    @Override
    public String apply(String name) {
        return name + "@12345";
    }
}
