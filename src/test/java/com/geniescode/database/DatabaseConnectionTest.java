package com.geniescode.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test
    public void testGet() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.get();
        Assertions.assertNotNull(connection);
        Assertions.assertFalse(connection.isClosed());
    }
}

