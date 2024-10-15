package dao;

import database.JDBCUntil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User User) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            String sql = "INSERT INTO User (username,password,hovaten)" +
                    " VALUES (?,?,?)";

            // Bước 2: tạo ra đối tượng statement
            PreparedStatement pst = con.prepareStatement(sql);


            // Bước 3: thực thi câu lệnh SQL
            pst.setString(1, User.getUsername());
            pst.setString(2, User.getPassword());
            pst.setString(3, User.getHovaten());

            ketQua = pst.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có "+ketQua+" dòng bị thay đổi!");

            // Bước 5: Ngắt kết nối
            JDBCUntil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int update(User User) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement



            // Bước 3: thực thi câu lệnh SQL
            String sql = "UPDATE User  SET password=?,hovaten=? WHERE username = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, User.getPassword());
            pst.setString(2, User.getHovaten());
            pst.setString(3, User.getUsername());


            ketQua = pst.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có "+ketQua+" dòng bị thay đổi!");

            // Bước 5: Ngắt kết nối
            JDBCUntil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(User User) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            PreparedStatement pst = con.prepareStatement("DELETE FROM User WHERE username = ?");


            // Bước 3: thực thi câu lệnh SQL
            pst.setString(1, User.getUsername());

            ketQua = pst.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + pst);
            System.out.println("Có "+ketQua+" dòng bị thay đổi!");

            // Bước 5: Ngắt kết nối
            JDBCUntil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement stmt = con.createStatement();


            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * from User";
            System.out.println("Bạn đã thực thi: " + sql);

            ResultSet rs = stmt.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hovaten = rs.getString("hovaten");


                User User = new User(username, password, hovaten);
                ketQua.add(User);
            }


            // Bước 5: Ngắt kết nối
            JDBCUntil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public User selectById(User User) {
        User ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement


            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * from User where  username=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, User.getPassword());
            System.out.println("Bạn đã thực thi: " + sql);

            ResultSet rs = pst.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hovaten = rs.getString("hovaten");


                ketQua = new User(username, password, hovaten);
            }


            // Bước 5: Ngắt kết nối
            JDBCUntil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<User>();

        return ketQua;
    }
}
