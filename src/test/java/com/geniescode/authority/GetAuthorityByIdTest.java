package com.geniescode.authority;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetAuthorityByIdTest {
    @Test
    public void testApply() {
        GetAuthorityById authority = new GetAuthorityById();
        String role = authority.apply(1);
        Assertions.assertEquals("Admin", role);

    }

}