package com.geniescode.authority;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetAuthorityIdByRoleTest {
    @Test
    public void testApply() {
        // Test a valid authority
        GetAuthorityIdByRole getAuthorityIdByRole = new GetAuthorityIdByRole();
        Integer adminId = getAuthorityIdByRole.apply("Admin");
        Assertions.assertEquals(1, adminId);

        // Test an invalid authority
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> getAuthorityIdByRole.apply("customer"));
        Assertions.assertEquals("Id of customer is not found!", exception.getMessage());
    }
}

