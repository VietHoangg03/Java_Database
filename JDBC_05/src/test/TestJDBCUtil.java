package test;

import database.JDBCUntil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {

        // Bước 1: Tạo kết nối
        Connection connection = JDBCUntil.getConnection();

        // Bước 2: Tạo ra đối tượng statement
        Statement statement = connection.createStatement();

        // Bước 3: Thực thi câu lệnh SQL
        String sql = "INSERT INTO Persons(last_name, first_name, gender, dob, income)" +
                "Values" +
                "    ('May','Dinh','F','2008-09-29',15000000)," +
                "    ('Linh','Nguyen','M','2004-06-12',18000000);";

        int check = statement.executeUpdate(sql);

        // Bước 4: Xử lý kết quả
        System.out.println("Số dòng thay đổi: " + check);
        if(check > 0) {
            System.out.println("Thêm dữ liệu thành công!");
        } else {
            System.out.println("Thêm dữ liệu thất bại");
        }


        // Bước 5: Ngắt kết nối
        JDBCUntil.closeConnection(connection);
    }
}
