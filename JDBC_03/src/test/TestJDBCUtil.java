package test;

import database.JDBCUntil;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUntil.getConnection();
        JDBCUntil.printInfo(connection);

        JDBCUntil.closeConnection(connection);
    }
}
