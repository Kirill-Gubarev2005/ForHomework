package com.stepup.myprog.edu.innoteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseConnection implements DatabaseConnection {
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:.\\Office");
    }
}
