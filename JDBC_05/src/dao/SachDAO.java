package dao;

import model.Sach;

import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        return 0;
    }

    @Override
    public int update(Sach sach) {
        return 0;
    }

    @Override
    public int delete(Sach sach) {
        return 0;
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
