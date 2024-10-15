package dao;

import database.JDBCUntil;
import model.Sach;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement stmt = con.createStatement();


            // Bước 3: thực thi câu lệnh SQL
            String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan)" +
                    " VALUES ('" + sach.getId() + "' ,'" + sach.getTenSach() + "' ," + sach.getGiaBan() + " ," + sach.getNamXuatBan() + ")";



            ketQua = stmt.executeUpdate(sql);

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
    public int update(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement stmt = con.createStatement();


            // Bước 3: thực thi câu lệnh SQL
            String sql = "UPDATE sach  SET tenSach ='%s',giaBan=%s,namXuatBan=%d WHERE id = '%s'".formatted(sach.getTenSach(), sach.getGiaBan(), sach.getNamXuatBan(), sach.getId());


            ketQua = stmt.executeUpdate(sql);

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
    public int delete(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUntil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement stmt = con.createStatement();


            // Bước 3: thực thi câu lệnh SQL
            String sql = "DELETE from sach  WHERE id = '%s'".formatted(sach.getId());


            ketQua = stmt.executeUpdate(sql);

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
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectById(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
