package dao;

import java.util.List;

public class AuthorDao implements DAOInterface{
    @Override
    public List selectAll() {
        return List.of();
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public boolean insert(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}
