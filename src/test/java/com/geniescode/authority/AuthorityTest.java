package com.geniescode.authority;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AuthorityTest {

    @Test
    public void getAuthorityByAuthorityIdTest() {
        // Test a valid authority id
        GetAuthorityById getAuthorityById = new GetAuthorityById();
        String authority = getAuthorityById.apply(1);
        Assertions.assertEquals("Admin", authority);

        // Test an invalid authority id
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> getAuthorityById.apply(-1));
        Assertions.assertEquals("Role of -1 Id is not found!", exception.getMessage());
    }

    @Test
    public void getAuthorityIdByAuthorityTest() {
        // Test a valid authority
        GetAuthorityIdByRole getAuthorityIdByRole = new GetAuthorityIdByRole();
        Integer adminId = getAuthorityIdByRole.apply("Admin");
        Assertions.assertEquals(1, adminId);

        // Test an invalid authority
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> getAuthorityIdByRole.apply("customer"));
        Assertions.assertEquals("Id of customer is not found!", exception.getMessage());
    }

    @Test
    public void getAuthorityListTest() {
        GetAuthorityList getAuthorityList = new GetAuthorityList();
        List<String> authorities = getAuthorityList.get();
        Assertions.assertNotNull(authorities);
        Assertions.assertFalse(authorities.isEmpty());
        Assertions.assertTrue(authorities.contains("Admin"));
    }
}
