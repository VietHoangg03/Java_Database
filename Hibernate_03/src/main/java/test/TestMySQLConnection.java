package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3366/cat";
        String username = "root";
        String password = ""; // Nếu có mật khẩu, hãy điền vào đây

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }
        } catch (Exception e) {
            System.err.println("Kết nối thất bại:");
            e.printStackTrace();
        }
    }
}
