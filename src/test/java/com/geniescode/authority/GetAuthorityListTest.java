package com.geniescode.authority;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetAuthorityListTest {

    @Test
    public void testGet() {
        GetAuthorityList getAuthorityList = new GetAuthorityList();
        List<String> authorities = getAuthorityList.get();
        Assertions.assertNotNull(authorities);
        Assertions.assertFalse(authorities.isEmpty());
        Assertions.assertTrue(authorities.contains("Admin"));
    }
}